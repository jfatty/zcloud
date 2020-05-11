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
import com.jfatty.zcloud.health.service.*;
import com.jfatty.zcloud.health.vo.*;
import com.jfatty.zcloud.hospital.feign.ComplexPatientFeignClient;
import com.jfatty.zcloud.hospital.req.ComplexPatientReq;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Api(tags = "**主**001**电子健康卡平台对接API" ,value = "电子健康卡平台**对接**")
@Slf4j
@RestController
@RequestMapping(value={"/api/healthCardStation"})
public class ApiHealthCardStationController {

    @Autowired
    private HealthCardStationService healthCardStationService ;

    @Autowired
    private HCSHealthCardInfoService hcsHealthCardInfoService ;

    @Autowired
    private HCSIDCardInfoService hcsidCardInfoService ;

    @Autowired
    private HealthCardSettingsService healthCardSettingsService;

    @Autowired
    private HealthCardUserService healthCardUserService ;

    @Autowired
    private RedisTemplate redisTemplate ;

    @Autowired
    private StringRedisTemplate stringRedisTemplate ;

    @Autowired
    private ComplexPatientFeignClient complexPatientFeignClient ;

    @Autowired
    private WechatFeignClient wechatFeignClient ;

    @Autowired
    private AddressFeignClient addressFeignClient ;

    @Autowired
    private HealthCard2HISService healthCard2HISService ;

    @ApiOperation(value=" 001**** 3.2.2 注册健康卡接口")
    @RequestMapping(value="/registerHealthCard", method=RequestMethod.POST)
    public RETResultUtils<RegHealthCardInfoRes> registerHealthCard(@RequestBody RegHealthCardInfoReq regHealthCardInfoReq){
        try {

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
            if ( null == gender)
                return RETResultUtils._509("证件号码不合法:"+idCard) ;

            String openId = regHealthCardInfoReq.getOpenId();
            Integer openIdType = regHealthCardInfoReq.getOpenIdType() ;
            String hospitalId = regHealthCardInfoReq.getHospitalId() ;


            String birthday = idCardUtil.getBirthdayStr();
            //切分前端请求中的名族信息
            String nas[] = regHealthCardInfoReq.getNation().split(":::");
            //查询数据库中是否存在对应证件号码关联的健康卡信息
            HCSHealthCardInfo db_HCSHealthCardInfo = hcsHealthCardInfoService.getByIdCardNumber(regHealthCardInfoReq.getIdNumber());
            String CID = "" ;
            if (db_HCSHealthCardInfo != null){
                CID = db_HCSHealthCardInfo.getId();
            }else {
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
            String wechatUrl = String.format(settings.getTplUrl(),"update",CID) ;
            hcsHealthCardInfo.setWechatUrl(wechatUrl);
            //设置详情url
            String detailUrl = String.format(settings.getDetailUrl(),settings.getHospitalId(),CID) ;
            hcsHealthCardInfo.setDetailUrl(detailUrl);
            log.error("==============================开始=========================================");
            //同步his电子健康信息
            try{
                System.out.println(hcsHealthCardInfo.toString());
                RegHealthCardInfoVO regHealthCardInfoVO = healthCard2HISService.regHealthCardInfo(hcsHealthCardInfo);
                log.error("返回信息 [{}]",regHealthCardInfoVO.getMsg());
                if ( regHealthCardInfoVO != null && regHealthCardInfoVO.success() ){
                    hcsHealthCardInfo.setPatid(regHealthCardInfoVO.getBrid());
                }else {
                    log.error("====>同步his电子健康信息失败 错误信息[{}]" , regHealthCardInfoVO!=null?regHealthCardInfoVO.getMsg():"返回对象为空");
                }
            } catch ( Exception e) {
                log.error("====>同步his电子健康信息失败 出现异常[{}]" ,e.getMessage());
            }
            //更新电子健康卡信息
            hcsHealthCardInfoService.updateById(hcsHealthCardInfo);
            log.error("==============================结束=========================================");
            HealthCardUser healthCardUser = healthCardUserService.getByOpts(settings.getWxAppId(),hospitalId,openId,openIdType);
            if ( healthCardUser == null ){
                healthCardUser = new HealthCardUser();
                healthCardUser.setAppid(settings.getWxAppId());
                healthCardUser.setHospitalId(hospitalId);
                healthCardUser.setOpenId(openId);
                healthCardUser.setOpenIdType(openIdType);
                healthCardUserService.saveId(healthCardUser);
            }
            healthCardUserService.tieHealthCard(openId,openIdType,hospitalId,CID);
            //处理地址信息
            HCSAddressReq pubAddress = regHealthCardInfoReq.getPubAddress();
            if ( null != pubAddress){
                Address address = new Address();
                //拷贝共用地址信息
                BeanUtils.copyProperties(pubAddress,address);
                //设置所属ID
                address.setBelongId(CID);
                addressFeignClient.updateByBelongId(address);
            }
            //返回注册电子健康卡数据
            return new RETResultUtils(regHealthCardInfoRes) ;
        } catch (Exception e) {
            log.error("001**** 3.2.2 注册健康卡接口 出现异常[{}]",e.getMessage());
        }

        return RETResultUtils.faild("网络异常!请稍后重试");

    }


//    @ApiOperation(value=" 002**** 3.2.3 通过健康卡授权码获取接口")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
//            @ApiImplicitParam(name = "healthCode", value = "健康卡授权码",dataType = "String",defaultValue = "F9D3F8A308FC0EABC581F5903CAA1094")
//    })
//    @RequestMapping(value="/getHealthCardByHealthCode", method=RequestMethod.GET)
//    public  RETResultUtils<HCSHealthCardInfoRes> getHealthCardByHealthCode(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId , @RequestParam(value = "healthCode" , defaultValue = "F9D3F8A308FC0EABC581F5903CAA1094") String healthCode){
//        try {
//            HCSHealthCardInfoRes hcsHealthCardInfoRes  = new HCSHealthCardInfoRes();
//            HealthCardInfoVO healthCardInfoVO = healthCardStationService.getHealthCardByHealthCode(hospitalId,healthCode);
//            BeanUtils.copyProperties(healthCardInfoVO,hcsHealthCardInfoRes);
//            return new RETResultUtils(hcsHealthCardInfoRes) ;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }


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
        }
        return RETResultUtils.faild("网络异常!请稍后重试");

    }

    @ApiOperation(value=" 003**** 3.2.5 OCR接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646",required = true)
            //,@ApiImplicitParam(name = "IDCardFile", value = "身份证正面图片文件",dataType = "file",required = true)
    })
    @RequestMapping(value="/ocrInfo", method=RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public RETResultUtils<HCSIDCardInfoRes> ocrInfo(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId ,@RequestPart(value = "IDCardFile") MultipartFile IDCardFile ){
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            String imageContent = encoder.encode(IDCardFile.getBytes());
            imageContent = imageContent.replaceAll("\r|\n","");
            HCSIDCardInfoVO hcsidCardInfoVO = healthCardStationService.ocrInfo(hospitalId,imageContent);
            HCSIDCardInfo db_hcsidCardInfo = hcsidCardInfoService.getById(hcsidCardInfoVO.getId());
            String birth = hcsidCardInfoVO.getBirth() ;
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//对日期进行格式化
            birth = df.format(format.parse(birth));
            hcsidCardInfoVO.setBirth(birth);
            BeanUtils.copyProperties(hcsidCardInfoVO,db_hcsidCardInfo);
            if( db_hcsidCardInfo == null){
                hcsidCardInfoService.save(db_hcsidCardInfo);
            }else {
                hcsidCardInfoService.updateById(db_hcsidCardInfo);
            }
            HCSIDCardInfo up_hcsidCardInfo = hcsidCardInfoService.getById(hcsidCardInfoVO.getId());
            HCSIDCardInfoRes hcsidCardInfoRes = new HCSIDCardInfoRes();
            BeanUtils.copyProperties(up_hcsidCardInfo,hcsidCardInfoRes);
            //改变名族为字典
            String nation = hcsidCardInfoRes.getNation();
            String nationDic = hcsHealthCardInfoService.getNationDicStr(nation);
            hcsidCardInfoRes.setIdCard(IDCardUtil.coverStarts(hcsidCardInfoRes.getIdCard(),8,14));
            hcsidCardInfoRes.setNation(nationDic);
            return new RETResultUtils(hcsidCardInfoRes) ;
        } catch (Exception e) {
            log.error("hospitalId==>[{}] 调用OCR接口异常[{}]",hospitalId,e.getMessage());
        }
        return RETResultUtils.faild("网络异常!请稍后重试");
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
        } catch (Exception e) {
            log.error("005**** 3.2.7 用卡数据监测接口 出现异常[{}]",e.getMessage());
        }
        return RETResultUtils.faild("网络异常!请稍后重试");
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
        }
        return RETResultUtils.faild("网络异常!请稍后重试");

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

            HealthCardSettings settings =  healthCardSettingsService.getByHospitalId(hospitalId);

            List<WebRegPatientRes> webRegPatientList = resultUtils.getData();

            List<com.jfatty.zcloud.health.model.HealthCardInfo> healthCardInfos = new ArrayList<com.jfatty.zcloud.health.model.HealthCardInfo>();

            int flag = 1 ;
            for (WebRegPatientRes item : webRegPatientList) {
                com.jfatty.zcloud.health.model.HealthCardInfo healthCardInfoItem = new com.jfatty.zcloud.health.model.HealthCardInfo();
                String idCard = item.getSfzh() ;
                IDCardUtil idCardUtil = new IDCardUtil(idCard) ;
                String gender = idCardUtil.getGender() ;
                String birthday = idCardUtil.getBirthdayStr();
                healthCardInfoItem.setWechatCode(settings.getWechatCode());
                healthCardInfoItem.setName(item.getXm());
                healthCardInfoItem.setIdNumber(idCard);
                healthCardInfoItem.setGender(gender);
                healthCardInfoItem.setBirthday(birthday);
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
                healthCardInfos.add(healthCardInfoItem);
                if (flag == 1)
                    break;
            }

            healthCardInfos = healthCardStationService.registerBatchHealthCard(hospitalId,healthCardInfos);
            List<RegBatHealthCardInfoRes> regBatHealthCardInfos = new ArrayList<RegBatHealthCardInfoRes>();

            for ( com.jfatty.zcloud.health.model.HealthCardInfo healthCardInfo :  healthCardInfos ){
                RegBatHealthCardInfoRes info = new RegBatHealthCardInfoRes();
                BeanUtils.copyProperties(healthCardInfo,info);
                regBatHealthCardInfos.add(info);

                HCSHealthCardInfo db_HCSHealthCardInfo = hcsHealthCardInfoService.getByIdCardNumber(healthCardInfo.getIdNumber());
                if (db_HCSHealthCardInfo != null){
                    BeanUtils.copyProperties(healthCardInfo,db_HCSHealthCardInfo);
                    hcsHealthCardInfoService.updateById(db_HCSHealthCardInfo);
                }else {
                    try {
                        BeanUtils.copyProperties(healthCardInfo,db_HCSHealthCardInfo);
                        hcsHealthCardInfoService.saveId(db_HCSHealthCardInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(healthCardInfo);
            }

            return new RELResultUtils(regBatHealthCardInfos);
        } catch (Exception e) {
            log.error("007**** 3.2.9 注册批量健康卡接口 出现异常[{}]",e.getMessage());
        }
        return RELResultUtils.faild("网络异常!请稍后重试");

    }


    @ApiOperation(value=" 008**** 3.2.10 获取动态二维码接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "healthCardInfoId", value = "健康卡信息记录ID(系统健康卡ID)",dataType = "String",defaultValue = "2C9580916F47F3AA016F47F3AA0F0000")
    })
    @RequestMapping(value="/getDynamicQRCode", method=RequestMethod.GET)
    public RETResultUtils<DynamicQRCodeRes>  getDynamicQRCode(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId , @RequestParam(value = "healthCardInfoId" , defaultValue = "2C9580916F47F3AA016F47F3AA0F0000") String healthCardInfoId  ){
        try {
            HCSHealthCardInfo hcsHealthCardInfo = hcsHealthCardInfoService.getById(healthCardInfoId);
            DynamicQRCodeRes dynamicQRCodeRes = new DynamicQRCodeRes();
            DynamicQRCodeVO dynamicQRCodeVO =  healthCardStationService.getDynamicQRCode(hospitalId,hcsHealthCardInfo.getHealthCardId(),hcsHealthCardInfo.getIdType(),hcsHealthCardInfo.getIdNumber());
            BeanUtils.copyProperties(dynamicQRCodeVO,dynamicQRCodeRes);
            return new RETResultUtils(dynamicQRCodeRes);
        } catch (Exception e) {
            log.error("008**** 3.2.10 获取动态二维码接口 出现异常[{}]",e.getMessage());
        }
        return RETResultUtils.faild("网络异常!请稍后重试");
    }


    @ApiOperation(value=" 009**** 电子健康卡列表获取 ")
    @RequestMapping(value="/getHealthCardList", method=RequestMethod.POST)
    public RELResultUtils<SimpleHealthCardInfoRes> getHealthCardList(@RequestBody SimpleHealthCardInfoReq simpleHealthCardInfoReq){
        try {
            String openId = simpleHealthCardInfoReq.getOpenId();
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
                healthCardUserService.saveId(healthCardUser);
            }
            List<String> healthCardInfoIds = healthCardUserService.getByOpenId(openId,openIdType);
            if (CollectionUtils.isEmpty(healthCardInfoIds))
                return RELResultUtils._506("您暂无电子健康卡E0");
            List<HCSHealthCardInfo> hcsHealthCardInfos = hcsHealthCardInfoService.getBatchHealthCardByInfoIds(healthCardInfoIds,hospitalId);
            if(CollectionUtils.isEmpty(hcsHealthCardInfos))
                return RELResultUtils._506("您暂无电子健康卡E1");
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
        HCSHealthCardInfo hcsHealthCardInfo = hcsHealthCardInfoService.getById(healthCardInfoId);
        HCSHealthCardInfoRes hcsHealthCardInfoRes = new HCSHealthCardInfoRes();
        BeanUtils.copyProperties(hcsHealthCardInfo,hcsHealthCardInfoRes);
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
        try {
            Boolean result = healthCardUserService.untieHealthCard(untieHealthCardReq.getOpenId(),untieHealthCardReq.getOpenIdType(),untieHealthCardReq.getHospitalId(),untieHealthCardReq.getHealthCardInfoId());
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
        String url = String.format(settings.getTplUrl(),"update",healthCardInfoId);
        wechatFeignClient.sendTemplateMessage(settings.getWxAppId(),openId,settings.getTplId(),url,"您已成功将就诊卡升级为健康卡！","2014年7月21日 18:36","健康卡可完全替代就诊卡，支持区域内多家医院跨院就医，无需重复办卡，实现线上挂号缴费，线下扫码就医。","点击查看健康卡");
        return new RETResultUtils(true);
    }


}
