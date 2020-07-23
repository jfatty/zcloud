package com.jfatty.zcloud.health.api;

import com.jfatty.zcloud.base.utils.IDCardUtil;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.health.entity.HCSHealthCardInfo;
import com.jfatty.zcloud.health.entity.HCSIDCardInfo;
import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.entity.HealthCardUser;
import com.jfatty.zcloud.health.req.*;
import com.jfatty.zcloud.health.res.*;
import com.jfatty.zcloud.health.service.HCSIDCardInfoService;
import com.jfatty.zcloud.health.utils.AESUtil;
import com.jfatty.zcloud.health.vo.*;
import com.jfatty.zcloud.hospital.req.ComplexPatientReq;
import com.jfatty.zcloud.hospital.req.NumoPatientDeatilReq;
import com.jfatty.zcloud.hospital.req.NumoPatientInfoReq;
import com.jfatty.zcloud.hospital.res.WebRegPatientRes;
import com.jfatty.zcloud.system.entity.Address;
import com.jfatty.zcloud.system.feign.AddressFeignClient;
import com.jfatty.zcloud.wechat.feign.WechatFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *  描述 电子健康卡平台
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Api(tags = "**主**001**电子健康卡平台对接API" ,value = "电子健康卡平台**对接**")
@Slf4j
@RestController
@RequestMapping(value={"/api/healthCardStation"})
public class ApiHealthCardStationController extends ApiHealthCardStationBaseController  {


    @Autowired
    private HCSIDCardInfoService hcsidCardInfoService ;

    @Autowired
    private RedisTemplate redisTemplate ;

    @Autowired
    private StringRedisTemplate stringRedisTemplate ;

    @Autowired
    private WechatFeignClient wechatFeignClient ;

    @Autowired
    private AddressFeignClient addressFeignClient ;


    @ApiOperation(value=" 001**** 3.2.2 注册健康卡接口")
    @RequestMapping(value="/registerHealthCard", method=RequestMethod.POST)
    public RETResultUtils<RegHealthCardInfoRes> registerHealthCard(@RequestBody RegHealthCardInfoReq regHealthCardInfoReq){
        log.error("========>001**** 3.2.2 注册健康卡接口  入参 [{}]",regHealthCardInfoReq.toString());
        String addressStr = "" ;
        String openId = regHealthCardInfoReq.getOpenId();
        Integer openIdType = regHealthCardInfoReq.getOpenIdType() ;
        String hospitalId = regHealthCardInfoReq.getHospitalId() ;
        HCSHealthCardInfo hcsHealthCardInfo = new HCSHealthCardInfo();
        BeanUtils.copyProperties(regHealthCardInfoReq,hcsHealthCardInfo);
        String phone1 = regHealthCardInfoReq.getPhone1();
        String kaptcha = regHealthCardInfoReq.getKaptcha();
        if(StringUtils.isEmptyOrBlank(phone1))
            return RETResultUtils._509("请填入正确的手机号");
        if(StringUtils.isEmptyOrBlank(kaptcha))
            return RETResultUtils._509("验证码不能为空") ;
        //验证手机验证码
        String code = (String) redisTemplate.opsForValue().get(phone1);
        if(StringUtils.isEmptyOrBlank(code))
            return RETResultUtils._506("验证码已经失效") ;
        if(!code.equalsIgnoreCase(kaptcha))
            return RETResultUtils._509("验证码错误") ;
        //删除缓存
        redisTemplate.delete(phone1);
        //校验身份证号码
        String idCard = regHealthCardInfoReq.getIdNumber();
        IDCardUtil idCardUtil = new IDCardUtil(idCard) ;
        //校验身份证号码是否合法
        String gender = idCardUtil.getGender() ;
        if ( null == gender){
            log.error("===>[{}]","证件号码不合法:"+idCard);
            return RETResultUtils._509("证件号码不合法:"+idCard) ;
        }

        //处理地址信息
        HCSAddressReq pubAddress = regHealthCardInfoReq.getPubAddress();
        if ( null != pubAddress){
            Address address = new Address();
            //拷贝共用地址信息
            BeanUtils.copyProperties(pubAddress,address);
            //设置所属ID
            address.setBelongId(idCard);
            addressFeignClient.updateByBelongId(address);
            addressStr = address.getAddressStr();
            regHealthCardInfoReq.setAddress(addressStr);
            hcsHealthCardInfo.setAddress(addressStr);
        }

        NumoPatientInfoReq numoPatientInfoReq = new NumoPatientInfoReq();
        BeanUtils.copyProperties(regHealthCardInfoReq,numoPatientInfoReq);
        numoPatientInfoReq.setIdCard(regHealthCardInfoReq.getIdNumber());
        numoPatientInfoReq.setTel(regHealthCardInfoReq.getPhone1());
        try {
            String birthday = idCardUtil.getBirthdayStr();
            //切分前端请求中的名族信息
            String nas[] = regHealthCardInfoReq.getNation().split(":::");
            //查询数据库中是否存在对应证件号码关联的健康卡信息
            HCSHealthCardInfo db_HCSHealthCardInfo = hcsHealthCardInfoService.getByIdCardNumber(regHealthCardInfoReq.getIdNumber());
            //与his系统进行绑定
            RETResultUtils<String> result = complexPatientFeignClient.addComplexPatient(numoPatientInfoReq);
            log.error("===>与his系统进行绑定 返回结果[{}]",result.toString());
            if ( !result.isOK() )
                return RETResultUtils.faild(result.getMsg());
            String CID = "" ;
            if (db_HCSHealthCardInfo != null){
                CID = db_HCSHealthCardInfo.getId();
            } else {
                //保存用户健康卡注册数据
                CID = hcsHealthCardInfoService.saveId(hcsHealthCardInfo);
            }
            //定义返回参数
            RegHealthCardInfoRes regHealthCardInfoRes = new RegHealthCardInfoRes();
            //定义健康卡请求参数
            HCSHealthCardInfoReq hcsHealthCardInfoReq = new HCSHealthCardInfoReq();
            BeanUtils.copyProperties(regHealthCardInfoReq,hcsHealthCardInfoReq);
            //设置证件类型
            hcsHealthCardInfoReq.setIdType("01");
            //设置请求性别
            hcsHealthCardInfoReq.setGender(gender);
            //设置请求身份证号码
            hcsHealthCardInfoReq.setBirthday(birthday);
            //重新设置请求参数中的名族信息
            hcsHealthCardInfoReq.setNation(nas[0]);
            //设置请求第二个手机号码
            hcsHealthCardInfoReq.setPhone2("");
            //调用业务层获取健康卡数据
            HealthCardInfoVO healthCardInfoVO = healthCardStationService.registerHealthCard(hospitalId,hcsHealthCardInfoReq);
            //二维码文本
            String qrCodeText = healthCardInfoVO.getQrCodeText() ;
            //拷贝健康卡数据到返回参数
            BeanUtils.copyProperties(healthCardInfoVO,regHealthCardInfoRes);
            //拷贝健康卡数据到数据存储实体
            BeanUtils.copyProperties(healthCardInfoVO,hcsHealthCardInfo);
            //数据存储ID
            hcsHealthCardInfo.setId(CID);
            //重新设置名族信息
            hcsHealthCardInfo.setNation(regHealthCardInfoReq.getNation());
            //处理健康卡与微信用户之间的绑定关系
            HealthCardSettings settings = healthCardSettingsService.getByHospitalId(hospitalId) ;
            //设置微信升级模板消息url
            String wechatUrl = String.format(settings.getTplUrl(),"update",idCard) ;
            hcsHealthCardInfo.setWechatUrl(wechatUrl);
            //设置详情url
            String detailUrl = String.format(settings.getDetailUrl(),settings.getHospitalId(),idCard) ;
            hcsHealthCardInfo.setDetailUrl(detailUrl);
            log.error("==============================开始=========================================");
            String patId = syncHealthCard2HIS(hcsHealthCardInfo) ;
            hcsHealthCardInfo.setPatid(patId);
            if ( StringUtils.isNotEmptyAndBlank(patId) && StringUtils.isNotEmptyAndBlank(qrCodeText) ) {
                log.error("==============================开始绑定健康卡和院内 ID 关系接口=========================================");
                healthCardStationService.bindCardRelation(hospitalId,patId,qrCodeText);
                log.error("==============================开始绑定健康卡和院内 ID 关系接口=========================================");
            }
            //更新电子健康卡信息
            hcsHealthCardInfoService.updateById(hcsHealthCardInfo);
            log.error("==============================结束=========================================");
            updateHealthCardUser(settings.getWxAppId(),hospitalId,openId,openIdType,HealthCardUser.ACTIVE_YES,HealthCardUser.BATCH_NO,true);
            //关联微信用户与电子健康卡之间的关联关系
            healthCardUserService.tieHealthCard(openId,openIdType,hospitalId,CID);

            //返回注册电子健康卡数据
            return new RETResultUtils(regHealthCardInfoRes) ;
        } catch (Exception e) {
            log.error("001**** 3.2.2 注册健康卡接口 出现异常[{}]",e.getMessage());
            return RETResultUtils.faild(e.getMessage());
        }
        //return RETResultUtils.faild("网络异常!请稍后重试");

    }


    @ApiOperation(value=" 002**** 3.2.4 通过健康卡二维码获取接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "qrCodeText", value = "二维码文本",dataType = "String",defaultValue = "272EB52D0696FD625B6F3E1A830728532779BEB87520CC83948C50A43F439F58:1")
    })
    @RequestMapping(value="/getHealthCardByQRCode", method=RequestMethod.POST)
    public RETResultUtils<HCSHealthCardInfoRes>  getHealthCardByQRCode(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId ,  @RequestParam(value = "qrCodeText" , defaultValue = "272EB52D0696FD625B6F3E1A830728532779BEB87520CC83948C50A43F439F58:1") String qrCodeText ){
        try {
            HCSHealthCardInfoRes hcsHealthCardInfoRes  = new HCSHealthCardInfoRes();
            HealthCardInfoVO healthCardInfoVO = healthCardStationService.getHealthCardByQRCode(hospitalId,qrCodeText);
            BeanUtils.copyProperties(healthCardInfoVO,hcsHealthCardInfoRes);
            return new RETResultUtils(hcsHealthCardInfoRes) ;
        } catch (Exception e) {
            log.error("002**** 3.2.4 通过健康卡二维码获取接口 出现异常[{}]",e.getMessage());
            return RETResultUtils.faild(e.getMessage());
        }
        //return RETResultUtils.faild("网络异常!请稍后重试");

    }

    @ApiOperation(value=" 003**** 3.2.5 OCR接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646",required = true)
            //,@ApiImplicitParam(name = "IDCardFile", value = "身份证正面图片文件",dataType = "file",required = true)
    })
    @RequestMapping(value="/ocrInfo", method=RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public RETResultUtils<HCSIDCardInfoRes> ocrInfo(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId ,@RequestPart(value = "IDCardFile") MultipartFile IDCardFile ){
        BASE64Encoder encoder = new BASE64Encoder();
        String imageContent = null;
        try {
            imageContent = encoder.encode(IDCardFile.getBytes());
        } catch (IOException e) {
            log.error("hospitalId==>[{}] 调用OCR接口 BASE64字节转化失败 [{}]",hospitalId,e.getMessage());
            return RETResultUtils.faild("BASE64字节转化失败");
        }
        imageContent = imageContent.replaceAll("\r|\n","");
        HCSIDCardInfoVO hcsidCardInfoVO = null;
        try {
            log.debug("=====>开始调用腾讯卡管理平台<===OCR接口");
            hcsidCardInfoVO = healthCardStationService.ocrInfo(hospitalId,imageContent);
            log.debug("=====>结束调用腾讯卡管理平台<===OCR接口");
        } catch (Exception e) {
            log.error("hospitalId==>[{}] 调用OCR接口异常[{}]",hospitalId,e.getMessage());
            return RETResultUtils.faild(e.getMessage());
        }
        String birth = hcsidCardInfoVO.getBirth() ;
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//对日期进行格式化
        try {
            birth = df.format(format.parse(birth));
            hcsidCardInfoVO.setBirth(birth);
        } catch (ParseException e) {
            log.error("hospitalId==>[{}] 调用OCR接口出生日期格式转换异常[{}]",hospitalId,e.getMessage());
        }
        HCSIDCardInfo db_hcsidCardInfo = hcsidCardInfoService.getById(hcsidCardInfoVO.getId());
        if( db_hcsidCardInfo == null){
            db_hcsidCardInfo = new HCSIDCardInfo();
            BeanUtils.copyProperties(hcsidCardInfoVO,db_hcsidCardInfo);
            hcsidCardInfoService.save(db_hcsidCardInfo);
        }else {
            BeanUtils.copyProperties(hcsidCardInfoVO,db_hcsidCardInfo);
            hcsidCardInfoService.updateById(db_hcsidCardInfo);
        }
        HCSIDCardInfoRes hcsidCardInfoRes = new HCSIDCardInfoRes();
        BeanUtils.copyProperties(hcsidCardInfoVO,hcsidCardInfoRes);
        //改变名族为字典
        String nation = hcsidCardInfoRes.getNation();
        String nationDic = hcsHealthCardInfoService.getNationDicStr(nation);
        hcsidCardInfoRes.setIdCard(IDCardUtil.coverStarts(hcsidCardInfoRes.getIdCard(),8,14));
        hcsidCardInfoRes.setNation(nationDic);
        return new RETResultUtils(hcsidCardInfoRes) ;
        //return RETResultUtils.faild("网络异常!请稍后重试");
    }

    @ApiOperation(value=" 004**** 3.2.6 绑定健康卡和院内 ID 关系接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "patId", value = "院内ID",dataType = "String",defaultValue = "1003243"),
            @ApiImplicitParam(name = "qrCodeText", value = "二维码文本",dataType = "String",defaultValue = "C7DA29345B6DF90A6F5BBEBD73EBE2EDA26F341A6CFEEEB121XXX:1")
    })
    @RequestMapping(value="/bindCardRelation", method=RequestMethod.POST)
    public RETResultUtils<Boolean> bindCardRelation(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId ,  @RequestParam(value = "patId" , defaultValue = "10086") String patId,//
                                                    @RequestParam(value = "qrCodeText" , defaultValue = "C7DA29345B6DF90A6F5BBEBD73EBE2EDA26F341A6CFEEEB121XXX:1") String qrCodeText ){
        try {
            return  new RETResultUtils(healthCardStationService.bindCardRelation(hospitalId,patId,qrCodeText)) ;
        } catch (Exception e) {
            log.error("004**** 3.2.6 绑定健康卡和院内 ID 关系接口 出现异常[{}]",e.getMessage());
        }
        return RETResultUtils.faild("网络异常!请稍后重试");

    }


    @ApiOperation(value=" 005**** 3.2.7 用卡数据监测接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646")
    })
    @RequestMapping(value="/reportHISData", method=RequestMethod.POST)
    public RETResultUtils<Boolean> reportHISData(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId ,  @RequestBody ReportHISDataVO reportHISDataVO ){
        try {
            healthCardStationService.reportHISData(hospitalId,reportHISDataVO);
            return new RETResultUtils(true);
        } catch (Exception e) {
            log.error("005**** 3.2.7 用卡数据监测接口 出现异常[{}]",e.getMessage());
            return RETResultUtils.faild(e.getMessage());
        }
        //return RETResultUtils.faild("网络异常!请稍后重试");
    }

    @ApiOperation(value=" 006****  3.2.8 获取卡包订单  ID接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "qrCodeText", value = "二维码文本",dataType = "String",defaultValue = "C7DA29345B6DF90A6F5BBEBD73EBE2EDA26F341A6CFEEEB121XXX:1")
    })
    @RequestMapping(value="/getOrderIdByOutAppId", method=RequestMethod.GET)
    public RETResultUtils<String> getOrderIdByOutAppId(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId ,   @RequestParam(value = "qrCodeText" , defaultValue = "C7DA29345B6DF90A6F5BBEBD73EBE2EDA26F341A6CFEEEB121XXX:1") String qrCodeText  ){
        try {
            return new RETResultUtils(healthCardStationService.getOrderIdByOutAppId(hospitalId,qrCodeText));
        } catch (Exception e) {
            log.error("006**** 3.2.8 获取卡包订单  ID接口 出现异常[{}]",e.getMessage());
            return RETResultUtils.faild(e.getMessage()) ;
        }
        //return RETResultUtils.faild("网络异常!请稍后重试");

    }

    @ApiOperation(value=" 007**** 3.2.9 注册批量健康卡接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646")
    })
    @RequestMapping(value="/registerBatchHealthCard", method=RequestMethod.POST)
    public RELResultUtils<RegBatHealthCardInfoRes> registerBatchHealthCard(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId ,@RequestBody ComplexPatientReq complexPatientReq ){
        try {

            RELResultUtils<WebRegPatientRes> resultUtils = complexPatientFeignClient.getComplexPatients(complexPatientReq);
            //List<HealthCardInfoVO> healthCardInfos = new ArrayList<HealthCardInfoVO>();
            //获取老用户就诊人列表失败
            if ( !resultUtils.isOK() ) {
                return RELResultUtils._506("未获取到对应老用户就诊人列表");
            }
            String openId = complexPatientReq.getOpenId() ;
            Integer openIdType = complexPatientReq.getOpenIdType() ;
            List<WebRegPatientRes> webRegPatientList = resultUtils.getData();

            HealthCardSettings settings =  healthCardSettingsService.getByHospitalId(hospitalId);

            String appid = settings.getAppid();
            String appSecret = settings.getAppSecret() ;
            String wechatUrl = settings.getWechatUrl() ;

            List<com.jfatty.zcloud.health.model.HealthCardInfo> reqHealthCardInfos = new ArrayList<com.jfatty.zcloud.health.model.HealthCardInfo>();

            for (WebRegPatientRes item : webRegPatientList) {
                String idCard = item.getSfzh() ;
                //校验用户是否已经注册过电子健康卡
                if ( hcsHealthCardInfoService.verification(idCard,item.getBrid(),hospitalId) ) {
                    continue;
                }
                com.jfatty.zcloud.health.model.HealthCardInfo healthCardInfoItem = new com.jfatty.zcloud.health.model.HealthCardInfo();
                IDCardUtil idCardUtil = new IDCardUtil(idCard) ;
                String gender = idCardUtil.getGender() ;
                String birthday = idCardUtil.getBirthdayStr();

                //设置WechatCode
                healthCardInfoItem.setWechatCode(settings.getWechatCode());
                healthCardInfoItem.setName(item.getXm());
                healthCardInfoItem.setIdNumber(idCard);
                healthCardInfoItem.setGender(gender);
                healthCardInfoItem.setBirthday(birthday);
                //设置院内病人ID
                healthCardInfoItem.setPatid(item.getBrid());
                healthCardInfoItem.setNation("未知");
                healthCardInfoItem.setIdType("01");
                healthCardInfoItem.setPhone2("");
                String phone1 = item.getYddh() ;
                if(StringUtils.isEmptyOrBlank(phone1)){
                    healthCardInfoItem.setPhone1("18062158054");
                }else {
                    healthCardInfoItem.setPhone1(phone1);
                }
                String address = item.getDz() ;
                if(StringUtils.isEmptyOrBlank(address)){
                    healthCardInfoItem.setAddress("");
                }else {
                    healthCardInfoItem.setAddress(address);
                }

                //设置openId
                healthCardInfoItem.setOpenId(openId);

                //设置微信升级模板消息url
                String tplUrl = String.format(settings.getTplUrl(),"update",idCard) ;

                //设置wechatUrl
                String uuid =  UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
                String conStr =  uuid + "&" + openId + "&" + hospitalId ;
                //appid + 加密后的conStr 再编码号的
                String encryptData = appid + AESUtil.encrypt(conStr.getBytes(),appSecret.getBytes());

                //openUrl = "https://health.tengmed.com/open/batchActiveCard?open_id=%s&redirect_uri=%s" ;
                String url = String.format(wechatUrl,encryptData,URLEncoder.encode(tplUrl));
                healthCardInfoItem.setWechatUrl(url);
                log.error("===>批量注册电子健康卡 入参元素 [{}]",healthCardInfoItem.toString());
                //添加到集合
                reqHealthCardInfos.add(healthCardInfoItem);

            }
            if ( CollectionUtils.isEmpty(reqHealthCardInfos) ) {
                log.error("===>批量注册电子健康卡 就诊人列表 已完成批量建卡 openId===>[{}]",openId);
                return RELResultUtils._506("===>批量注册电子健康卡 就诊人列表 已完成批量建卡");
            }
            List<com.jfatty.zcloud.health.model.HealthCardInfo> resHealthCardInfos = healthCardStationService.registerBatchHealthCard(hospitalId,reqHealthCardInfos);
            if ( CollectionUtils.isEmpty(resHealthCardInfos) ) {
                return RELResultUtils._506("===>批量注册电子健康卡 卡关平台返回空数据");
            }
            //更新微信用户openId 为批量操作用户
            updateHealthCardUser(settings.getWxAppId(),hospitalId,openId,openIdType,HealthCardUser.ACTIVE_NO,HealthCardUser.BATCH_YES,false);
            //定义返回结果集合
            List<RegBatHealthCardInfoRes> regBatHealthCardInfos = new ArrayList<RegBatHealthCardInfoRes>();

            for ( com.jfatty.zcloud.health.model.HealthCardInfo healthCardInfo :  resHealthCardInfos ){
                String qrCodeText = healthCardInfo.getQrCodeText() ;
                log.error("===>批量注册电子健康卡 平台返回元素 [{}] ",healthCardInfo.toString());
                RegBatHealthCardInfoRes info = new RegBatHealthCardInfoRes();
                BeanUtils.copyProperties(healthCardInfo,info);
                //添加到返回集合
                regBatHealthCardInfos.add(info);
                //获取身份证号
                String idNumber = healthCardInfo.getIdNumber() ;
                //mysql中可能查询结果为空
                HCSHealthCardInfo db_HCSHealthCardInfo = hcsHealthCardInfoService.getByIdCardNumber(idNumber);

                HCSHealthCardInfo hcsHealthCardInfo = new HCSHealthCardInfo();
                BeanUtils.copyProperties(healthCardInfo,hcsHealthCardInfo);

                //同步电子健康卡信息到HIS
                String patId = syncHealthCard2HIS(hcsHealthCardInfo) ;
                healthCardInfo.setPatid(patId);
                if ( StringUtils.isNotEmptyAndBlank(patId) && StringUtils.isNotEmptyAndBlank(qrCodeText) ) {
                    log.error("==============================开始绑定健康卡和院内 ID 关系接口=========================================");
                    healthCardStationService.bindCardRelation(hospitalId,patId,qrCodeText);
                    log.error("==============================开始绑定健康卡和院内 ID 关系接口=========================================");
                }
                String upWechatUrl = String.format(settings.getTplUrl(),"update",idNumber) ;
                String CID = "" ;
                if (db_HCSHealthCardInfo != null){
                    db_HCSHealthCardInfo.setWechatUrl(upWechatUrl);
                    db_HCSHealthCardInfo.setPatid(healthCardInfo.getPatid());
                    hcsHealthCardInfoService.updateById(db_HCSHealthCardInfo);
                    CID = db_HCSHealthCardInfo.getId() ;
                    //关联微信用户与电子健康卡之间的关联关系
                    healthCardUserService.tieHealthCard(openId,openIdType,hospitalId,CID);
                }else {
                    //保存用户健康卡注册数据
                    db_HCSHealthCardInfo = new HCSHealthCardInfo();
                    BeanUtils.copyProperties(healthCardInfo,db_HCSHealthCardInfo);
                    db_HCSHealthCardInfo.setWechatUrl(upWechatUrl);
                    db_HCSHealthCardInfo.setHospitalId(settings.getHospitalId());
                    //设置详情url
                    String detailUrl = String.format(settings.getDetailUrl(),settings.getHospitalId(),idNumber) ;
                    db_HCSHealthCardInfo.setDetailUrl(detailUrl);
                    try {
                        CID = hcsHealthCardInfoService.saveId(db_HCSHealthCardInfo);
                        //关联微信用户与电子健康卡之间的关联关系
                        healthCardUserService.tieHealthCard(openId,openIdType,hospitalId,CID);
                    } catch (Exception e) {
                        log.error("===>新增电子健康卡信息到MySQL 出错 错误信息 [{}]",e.getMessage());
                    }
                }

            }
            return new RELResultUtils(regBatHealthCardInfos);
        } catch (Exception e) {
            log.error("007**** 3.2.9 注册批量健康卡接口 出现异常[{}]",e.getMessage());
            return RELResultUtils.faild(e.getMessage());
        }
        //return RELResultUtils.faild("网络异常!请稍后重试");

    }


    @ApiOperation(value=" 008**** 3.2.10 获取动态二维码接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "healthCardInfoId", value = "健康卡信息记录ID(系统健康卡ID)",dataType = "String",defaultValue = "2C9580916F47F3AA016F47F3AA0F0000")
    })
    @RequestMapping(value="/getDynamicQRCode", method=RequestMethod.GET)
    public RETResultUtils<DynamicQRCodeRes>  getDynamicQRCode(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId , @RequestParam(value = "healthCardInfoId" , defaultValue = "2C9580916F47F3AA016F47F3AA0F0000") String healthCardInfoId  ){
        try {
            HCSHealthCardInfo hcsHealthCardInfo = getHcsHealthCardInfo(healthCardInfoId);
            DynamicQRCodeRes dynamicQRCodeRes = new DynamicQRCodeRes();
            DynamicQRCodeVO dynamicQRCodeVO =  healthCardStationService.getDynamicQRCode(hospitalId,hcsHealthCardInfo.getHealthCardId(),hcsHealthCardInfo.getIdType(),hcsHealthCardInfo.getIdNumber());
            BeanUtils.copyProperties(dynamicQRCodeVO,dynamicQRCodeRes);
            return new RETResultUtils(dynamicQRCodeRes);
        } catch (Exception e) {
            log.error("008**** 3.2.10 获取动态二维码接口 出现异常[{}]",e.getMessage());
            return RETResultUtils.faild(e.getMessage());
        }
        //return RETResultUtils.faild("网络异常!请稍后重试");
    }

    @ApiOperation(value=" 008**** 3.2.10-2 获取 静态或动态 二维码接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "healthCardInfoId", value = "健康卡信息记录ID(系统健康卡ID)",dataType = "String",defaultValue = "2C9580916F47F3AA016F47F3AA0F0000"),
            @ApiImplicitParam(name = "codeType", value = "二维码类型 传0或者1，0返回动态码，1返回静态码 ",dataType = "String",defaultValue = "0")
    })
    @RequestMapping(value="/getQRCode", method=RequestMethod.GET)
    public RETResultUtils<DynamicQRCodeRes>  getQRCode(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId ,//
                                                       @RequestParam(value = "healthCardInfoId" , defaultValue = "2C9580916F47F3AA016F47F3AA0F0000") String healthCardInfoId,
                                                       @RequestParam(value = "codeType" , defaultValue = "0") String codeType  ){
        try {
            HCSHealthCardInfo hcsHealthCardInfo = getHcsHealthCardInfo(healthCardInfoId);
            DynamicQRCodeRes dynamicQRCodeRes = new DynamicQRCodeRes();
            DynamicQRCodeVO dynamicQRCodeVO =  healthCardStationService.getDynamicQRCode(hospitalId,hcsHealthCardInfo.getHealthCardId(),hcsHealthCardInfo.getIdType(),hcsHealthCardInfo.getIdNumber(),codeType);
            BeanUtils.copyProperties(dynamicQRCodeVO,dynamicQRCodeRes);
            //设置健康卡二维码颜色
            dynamicQRCodeRes.setCodeColor(dynamicQRCodeVO.getColor());
            hcsHealthCardInfo.setCodeColor(dynamicQRCodeVO.getColor());
            hcsHealthCardInfoService.updateById(hcsHealthCardInfo);
            return new RETResultUtils(dynamicQRCodeRes);
        } catch (Exception e) {
            log.error("008**** 3.2.10 获取动态二维码接口 出现异常[{}]",e.getMessage());
            return RETResultUtils.faild(e.getMessage());
        }
        //return RETResultUtils.faild("网络异常!请稍后重试");
    }


    @ApiOperation(value=" 009**** 电子健康卡列表获取 ")
    @RequestMapping(value="/getHealthCardList", method=RequestMethod.POST)
    public RELResultUtils<SimpleHealthCardInfoRes> getHealthCardList(@RequestBody SimpleHealthCardInfoReq simpleHealthCardInfoReq){
        String openId = simpleHealthCardInfoReq.getOpenId();
        if ( StringUtils.isEmptyOrBlank(openId) || "null".equalsIgnoreCase(openId) ){
            return RELResultUtils._509("openId 不能为空");
        }
        try {
            Integer openIdType = simpleHealthCardInfoReq.getOpenIdType() ;
            String hospitalId = simpleHealthCardInfoReq.getHospitalId() ;
            //处理健康卡与微信用户之间的绑定关系
            HealthCardSettings settings = healthCardSettingsService.getByHospitalId(hospitalId) ;
            HealthCardUser healthCardUser = healthCardUserService.getByOpts(settings.getWxAppId(),hospitalId,openId,openIdType);
            if ( healthCardUser == null ){
                healthCardUser = new HealthCardUser();
                healthCardUser.setAppid(settings.getWxAppId());
                healthCardUser.setHospitalId(hospitalId);
                healthCardUser.setOpenId(openId);
                healthCardUser.setOpenIdType(openIdType);
                String userId = healthCardUserService.saveId(healthCardUser);
                healthCardUser.setId(userId);
            }
            List<String> healthCardInfoIds = healthCardUserService.getByOpenId(openId,openIdType);
            if (CollectionUtils.isEmpty(healthCardInfoIds))
                return RELResultUtils._506("您暂无电子健康卡E0");
            List<HCSHealthCardInfo> hcsHealthCardInfos = hcsHealthCardInfoService.getBatchHealthCardByInfoIds(healthCardInfoIds,hospitalId);
            if(CollectionUtils.isEmpty(hcsHealthCardInfos))
                return RELResultUtils._506("您暂无电子健康卡E1");
            //设置激活电子健康卡状态
            healthCardUser.setIsActive(HealthCardUser.ACTIVE_YES);
            healthCardUserService.updateById(healthCardUser);
            List<SimpleHealthCardInfoRes> resList = new ArrayList<SimpleHealthCardInfoRes>();
            for (HCSHealthCardInfo healthCardInfo : hcsHealthCardInfos ){
                SimpleHealthCardInfoRes simpleHealthCardInfoRes = new SimpleHealthCardInfoRes();
                BeanUtils.copyProperties(healthCardInfo,simpleHealthCardInfoRes);
                simpleHealthCardInfoRes.setIssueCardOrg(settings.getIssueCardOrg());
                resList.add(simpleHealthCardInfoRes);
            }
            return new RELResultUtils(resList);
        } catch (Exception e) {
            log.error("009**** 电子健康卡列表获取 出现异常[{}]",e.getMessage());
        }
        return RELResultUtils.faild("网络异常!请稍后重试");
    }

    @ApiOperation(value=" 010**** 获取电子电子健康卡详情信息 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "healthCardInfoId", value = "健康卡信息记录ID(系统健康卡ID)",dataType = "String",defaultValue = "2C9580916F47F3AA016F47F3AA0F0000")
    })
    @RequestMapping(value="/getHealthCardInfo", method=RequestMethod.GET)
    public RETResultUtils<HCSHealthCardInfoRes> getHealthCardInfo(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId , @RequestParam(value = "healthCardInfoId" , defaultValue = "2C9580916F47F3AA016F47F3AA0F0000") String healthCardInfoId  ) {

        HCSHealthCardInfo hcsHealthCardInfo = getHcsHealthCardInfo(healthCardInfoId);
        HCSHealthCardInfoRes hcsHealthCardInfoRes = new HCSHealthCardInfoRes();
        BeanUtils.copyProperties(hcsHealthCardInfo,hcsHealthCardInfoRes);
        hcsHealthCardInfoRes.setId(hcsHealthCardInfo.getIdNumber());
        //改变名族为字典
        String nation = hcsHealthCardInfoRes.getNation();
        String nationDic = hcsHealthCardInfoService.getNationDicStr(nation);
        hcsHealthCardInfoRes.setIdNumber(IDCardUtil.coverStarts(hcsHealthCardInfoRes.getIdNumber(),8,14));
        hcsHealthCardInfoRes.setNation(nationDic);
        return new RETResultUtils(hcsHealthCardInfoRes);
    }


    @ApiOperation(value=" 011**** 解绑电子健康卡接口")
    @RequestMapping(value="/untieHealthCard", method=RequestMethod.POST)
    public RETResultUtils<Boolean> untieHealthCard(@RequestBody UntieHealthCardReq untieHealthCardReq){
        String healthCardInfoId = untieHealthCardReq.getHealthCardInfoId();
        try {
            HCSHealthCardInfo hcsHealthCardInfo = getHcsHealthCardInfo(healthCardInfoId);
            NumoPatientDeatilReq numoPatientDeatilReq = new NumoPatientDeatilReq();
            numoPatientDeatilReq.setOpenId(untieHealthCardReq.getOpenId());
            numoPatientDeatilReq.setOpenIdType(untieHealthCardReq.getOpenIdType());
            String patid = hcsHealthCardInfo.getPatid();
            if ( StringUtils.isNotEmptyAndBlank(patid) ){
                numoPatientDeatilReq.setBrid(patid);
                complexPatientFeignClient.deleteComplexPatient(numoPatientDeatilReq);
            }
            Boolean result = healthCardUserService.untieHealthCard(untieHealthCardReq.getOpenId(),untieHealthCardReq.getOpenIdType(),untieHealthCardReq.getHospitalId(),hcsHealthCardInfo.getId());
            if (result)
                return new RETResultUtils("电子健康卡解绑成功",result);
            return RETResultUtils._506("电子健康卡解绑失败") ;
        } catch (Exception e) {
            log.error("011**** 解绑电子健康卡接口 出现异常[{}]",e.getMessage());
            return RETResultUtils.faild("网络异常!请稍后重试");
        }

    }


    @ApiOperation(value=" 012**** 测试发送电子健康卡升级模板消息 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "healthCardInfoId", value = "健康卡信息记录ID(系统健康卡ID)",dataType = "String",defaultValue = "2C9580916F47F3AA016F47F3AA0F0000"),
            @ApiImplicitParam(name = "openId", value = "微信 openId",dataType = "String",defaultValue = "owisqt8cS_7a3GVnyP70oUIjK5vU")
    })
    @RequestMapping(value="/testSendTplMessage", method=RequestMethod.GET)
    public RETResultUtils<Boolean> testSendTplMessage(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId , //
                                                      @RequestParam(value = "healthCardInfoId" , defaultValue = "2C9580916F47F3AA016F47F3AA0F0000" ) String healthCardInfoId ,
                                                                  @RequestParam(value = "openId" , defaultValue = "owisqt8cS_7a3GVnyP70oUIjK5vU") String openId  ) {

        HealthCardSettings settings = healthCardSettingsService.getByHospitalId(hospitalId);
        HCSHealthCardInfo hcsHealthCardInfo = getHcsHealthCardInfo(healthCardInfoId);
        String url = String.format(settings.getTplUrl(),"update",hcsHealthCardInfo.getIdNumber());
        wechatFeignClient.sendTemplateMessage(settings.getWxAppId(),openId,settings.getTplId(),url,"您已成功将就诊卡升级为健康卡！","2014年7月21日 18:36","健康卡可完全替代就诊卡，支持区域内多家医院跨院就医，无需重复办卡，实现线上挂号缴费，线下扫码就医。","点击查看健康卡");
        return new RETResultUtils(true);
    }

    @ApiOperation(value=" 013**** 测试AES加解密 ")
    @RequestMapping(value="/testAES", method=RequestMethod.GET)
    public RETResultUtils<Boolean> testAES(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId , //
                                           @RequestParam(value = "secret" , defaultValue = "6b1e48ba2e47736a47085fa98jeudhsd") String secret, //
                                           @RequestParam(value = "openId" , defaultValue = "owisqt8cS_7a3GVnyP70oUIjK5vU") String openId) {
        String uuid= UUID.randomUUID().toString().toUpperCase().replace("-","");
        String uoh=uuid+"&"+openId+"&"+hospitalId;
        byte[] contentBytes=uoh.getBytes();
        byte[] keyBytes=secret.getBytes();

        //加密
        String en = AESUtil.encrypt(contentBytes,keyBytes);
        log.error("===>加密 [{}]",en);
        //解密
        byte[] enb=en.getBytes();
        byte[] de = AESUtil.decrypt(enb,keyBytes);
        String str = new String(de);
        log.error("===>解密 [{}]",str);
        return new RETResultUtils(true);
    }


    //
    @ApiOperation(value=" 014****开关设置默认电子健康卡")
    @RequestMapping(value="/setDefaultHealthCard", method=RequestMethod.POST)
    public RETResultUtils<String> setDefaultHealthCard(@RequestBody DefaultHealthCardReq defaultHealthCardReq){
        String openId = defaultHealthCardReq.getOpenId() ;
        if( StringUtils.isEmptyOrBlank( openId ) )
            return RETResultUtils._509("openId不能为空");
        Integer openIdType = defaultHealthCardReq.getOpenIdType() ;
        String hospitalId = defaultHealthCardReq.getHospitalId() ;
        if( StringUtils.isEmptyOrBlank( hospitalId ) )
            return RETResultUtils._509("医院Id不能为空");
        String healthCardInfoId = defaultHealthCardReq.getHealthCardInfoId() ;
        if( StringUtils.isEmptyOrBlank( hospitalId ) )
            return RETResultUtils._509("健康卡Id不能为空");
        Integer bindStatus  = defaultHealthCardReq.getBindStatus();
        boolean result = false;
        try {
            result  = healthCardUserService.bindDefaultHealthCard(openId,openIdType,
                    hospitalId,
                    healthCardInfoId,bindStatus);
            String msg = bindStatus == 1 ? "":"取消" ;
            if(result)
                return new RETResultUtils(msg+"设置默认电子健康卡成功");
        } catch (Exception e) {
            log.error("开关设置默认电子健康卡出现异常 [{}]",e.getMessage());
            return RETResultUtils.faild("网络崩溃了,请联系运维小哥");
        }
        return RETResultUtils.faild("网络延时,请稍后重试");
    }

}
