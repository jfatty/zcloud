package com.jfatty.zcloud.health.api;

import com.jfatty.zcloud.base.utils.IDCardUtil;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.health.entity.HCSHealthCardInfo;
import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.entity.HealthCardUser;
import com.jfatty.zcloud.health.res.HCSHealthCardInfoRes;
import com.jfatty.zcloud.health.service.HCSHealthCardInfoService;
import com.jfatty.zcloud.health.service.HealthCardSettingsService;
import com.jfatty.zcloud.health.service.HealthCardStationService;
import com.jfatty.zcloud.health.service.HealthCardUserService;
import com.jfatty.zcloud.health.vo.HealthCardInfoVO;
import com.jfatty.zcloud.system.feign.PageHrefFeignClient;
import com.jfatty.zcloud.system.res.PageHrefRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;


/**
 * 描述
 *
 * @author jfatty on 2019/12/29
 * @email jfatty@163.com
 */
@Api(tags = "**副**002**电子健康卡平台对接API" ,value = "电子健康卡平台**对接**")
@Slf4j
@Controller
@RequestMapping(value={"/api/healthCardStation"})
public class ApiHealthCardStationViewController {

    @Autowired
    private HealthCardStationService healthCardStationService ;

    @Autowired
    private HCSHealthCardInfoService hcsHealthCardInfoService ;

    @Autowired
    private HealthCardSettingsService healthCardSettingsService;

    @Autowired
    private HealthCardUserService healthCardUserService ;

    @Autowired
    private PageHrefFeignClient pageHrefFeignClient ;

    @ApiOperation(value=" 001****通过健康卡授权码获取用户健康卡信息接口 3.2.3 通过健康卡授权码获取接口",tags = "注意：页面自动跳转,页面加载时获取URL路径中携带的参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "openId", value = "微信 openId",dataType = "String",defaultValue = "owisqt8cS_7a3GVnyP70oUIjK5vU"),
            @ApiImplicitParam(name = "openIdType", value = "微信 2 openId 类型",dataType = "Integer",defaultValue = "2"),
            @ApiImplicitParam(name = "healthCode", value = "健康卡授权码",dataType = "String",defaultValue = "F9D3F8A308FC0EABC581F5903CAA1094")
    })
    @RequestMapping(value="/{hospitalId}/{openId}/{openIdType}/getHealthCardByHealthCode", method=RequestMethod.GET)
    public void getHealthCardByHealthCodePath(@PathVariable("hospitalId") String hospitalId ,//
                                              @PathVariable("openId") String openId ,//
                                              @PathVariable("openIdType") Integer openIdType ,//
                                              @RequestParam(value = "healthCode" , defaultValue = "F9D3F8A308FC0EABC581F5903CAA1094") String healthCode, HttpServletResponse response){
        try {

            //注意1：健康卡授权码healthCode有效期为30分钟且只能使用一次，一经使用立即失效。每次刷新会分配新的healthCode，为了保持平滑过渡，最近刷新的两个healthCode均有效，且次新healthCode将在5分钟后失效。
            //注意2：当用户在该页面点击添加健康卡按钮时，开放平台返回healthCode=0，因此ISV必须判断该情况：当healthCode=0时跳转到新用户建卡页面；
            //注意3：当用户在该页面点击暂不授权按钮时，开放平台返回healthCode=-1，因此ISV必须判断该情况：当healthCode=-1时跳转到上一个页面；
            log.error("hospitalId======>[{}]健康平台回传healthCode======>[{}]",hospitalId,healthCode);
            RELResultUtils<PageHrefRes> pageHrefRes = pageHrefFeignClient.getPageHrefsOpts("",hospitalId,"","getHealthCardByHealthCodePath");
            List<PageHrefRes> hrefs = pageHrefRes.getData();
            for (PageHrefRes herf : hrefs){
                if ( StringUtils.isEmptyOrBlank(herf.getVerifyCode()) && healthCode.length() > 2 ){
                    HCSHealthCardInfoRes hcsHealthCardInfoRes  = new HCSHealthCardInfoRes();

                    HealthCardInfoVO healthCardInfoVO = healthCardStationService.getHealthCardByHealthCode(hospitalId,healthCode);
                    BeanUtils.copyProperties(healthCardInfoVO,hcsHealthCardInfoRes);

                    HCSHealthCardInfo db_HCSHealthCardInfo = hcsHealthCardInfoService.getByIdCardNumber(healthCardInfoVO.getIdNumber());
                    HCSHealthCardInfo hcsHealthCardInfo = new HCSHealthCardInfo();

                    BeanUtils.copyProperties(healthCardInfoVO,hcsHealthCardInfo);

                    HealthCardSettings settings = healthCardSettingsService.getByHospitalId(hospitalId) ;

                    hcsHealthCardInfo.setHospitalId(settings.getHospitalId());
                    hcsHealthCardInfo.setNation(db_HCSHealthCardInfo.getNation());
                    String CID = "" ;
                    if (db_HCSHealthCardInfo != null){
                        CID = db_HCSHealthCardInfo.getId();
                        hcsHealthCardInfo.setId(CID);
                        hcsHealthCardInfoService.updateById(hcsHealthCardInfo);
                    }else {
                        CID = hcsHealthCardInfoService.saveId(hcsHealthCardInfo);
                    }
                    //设置微信升级模板消息url
                    String wechatUrl = String.format(settings.getTplUrl(),"update",CID) ;
                    hcsHealthCardInfo.setWechatUrl(wechatUrl);
                    //设置详情url
                    String detailUrl = String.format("http://dev.jfatty.com/health/api/healthCardStation/%s/getHealthCardByHealthCardInfoId?hospitalId=%s",settings.getHospitalId(),CID) ;
                    hcsHealthCardInfo.setDetailUrl(detailUrl);
                    //更新电子健康卡信息
                    hcsHealthCardInfoService.updateById(hcsHealthCardInfo);


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
                    //设置电子健康卡信息ID
                    hcsHealthCardInfoRes.setId(CID);
                    //改变名族为字典
                    String nation = hcsHealthCardInfoRes.getNation();
                    String nationDic = hcsHealthCardInfoService.getNationDicStr(nation);
                    hcsHealthCardInfoRes.setIdNumber(IDCardUtil.coverStarts(hcsHealthCardInfoRes.getIdNumber(),8,14));
                    hcsHealthCardInfoRes.setNation(nationDic);
                    //"http://dev.jfatty.com/HealthCardDemo/personal.html"
                    //ls_health/cardDetail
                    String path = herf.getTargetHref() ;
                    String params = getPostParams(hcsHealthCardInfoRes);
                    params = URLEncoder.encode(params,"UTF-8");
                    log.error("编码后的URL参数[{}]",params);
                    path = path + "?" + params ;
                    //去健康卡详情页面
                    log.error("去健康卡详情页面 [{}]",path);
                    response.sendRedirect(path);
                }else if ( healthCode.equals(herf.getVerifyCode()) && healthCode.length() < 3){
                    //"0".equals(healthCode)
                    //ls_health/createCard
                    //response.sendRedirect("http://dev.jfatty.com/HealthCardDemo/regist_new.html");
                    //"-1".equals(healthCode)
                    //不授权直接页面重定向返回健康卡列表页面 并且URL中携带参数提供给页面做判断
                    //ls_health/home
                    log.error("页面跳转 [{}]",herf.getTargetHref());
                    response.sendRedirect(herf.getTargetHref());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("001****通过健康卡授权码获取用户健康卡信息接口 3.2.3 通过健康卡授权码获取接口 出现异常[{}]",e.getMessage());
        }
    }


    @ApiOperation(value=" 002****通过医院ID与健康卡信息记录ID(系统健康卡ID)跳转至电子健康卡详情页面",tags = "注意：页面自动跳转,页面加载时获取URL路径中携带的参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "healthCardInfoId", value = "健康卡信息记录ID(系统健康卡ID)",dataType = "String",defaultValue = "2C9580916F47F3AA016F47F3AA0F0000")
    })
    @RequestMapping(value="/{hospitalId}/getHealthCardByHealthCardInfoId", method=RequestMethod.GET)
    public void getHealthCardByHealthCardInfoId(@PathVariable("hospitalId") String hospitalId , @RequestParam(value = "healthCardInfoId" , defaultValue = "2C9580916F47F3AA016F47F3AA0F0000") String healthCardInfoId, HttpServletResponse response){
        try {
            HCSHealthCardInfoRes hcsHealthCardInfoRes  = new HCSHealthCardInfoRes();
            HCSHealthCardInfo hcsHealthCardInfo = hcsHealthCardInfoService.getById(healthCardInfoId);
            BeanUtils.copyProperties(hcsHealthCardInfo,hcsHealthCardInfoRes);
            //改变名族为字典
            String nation = hcsHealthCardInfoRes.getNation();
            String nationDic = hcsHealthCardInfoService.getNationDicStr(nation);
            hcsHealthCardInfoRes.setIdNumber(IDCardUtil.coverStarts(hcsHealthCardInfoRes.getIdNumber(),8,14));
            hcsHealthCardInfoRes.setNation(nationDic);
            RELResultUtils<PageHrefRes> pageHrefRes = pageHrefFeignClient.getPageHrefsOpts("",hospitalId,"getHealthCardByHealthCardInfoId","");
            List<PageHrefRes> hrefs = pageHrefRes.getData();
            for (PageHrefRes herf : hrefs){
                //http://dev.jfatty.com/HealthCardDemo/personal.html
                String path = herf.getTargetHref() ;
                String params = getPostParams(hcsHealthCardInfoRes);
                params = URLEncoder.encode(params,"UTF-8");
                log.error("编码后的URL参数[{}]",params);
                path = path + "?" + params ;
                //去健康卡详情页面
                log.error("去健康卡详情页面 [{}]",path);
                response.sendRedirect(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("002****通过医院ID与健康卡信息记录ID(系统健康卡ID)跳转至电子健康卡详情页面 出现异常[{}]",e.getMessage());
        }
    }


//    流程说明
//    1、用户进入服务号打开健康卡二维码，点击二维码下方的进入卡包Button；
//    2、ISV调用 获取卡包订单ID接口，获取并缓存订单ID(orderId)；
//    3、ISV使用orderId配置跳转领取卡包的URL https://health.tengmed.com/open/takeMsCard?order_id=${orderId}&redirect_uri=${redirect_uri}，其中${orderId}是orderId值，${redirect_uri}是在领取卡包页面点击返回时，回跳到ISV页面的URL，如果是服务号打开，则必须包含 https:// 或 http:// 前缀；如果是小程序的webview打开，则${redirect_uri}指返回小程序的页面路径（如page/index，如果返回跳转来的页面，写为back就行）；服务号与小程序打开都必须要对${redirect_uri}进行编码。
//    4、开放平台根据orderId判断用户是否已领卡包，如果没有，则由卫健委服务号创建，用户点击领取；如果已领，则直接展示；
//    5、用户在微信卡包中查看电子健康卡。

    //加入微信卡包 addWechatPack
    @ApiOperation(value=" 003**** 用户点击 加入微信卡包 跳转至微信卡包电子健康卡领取页面",tags = "注意：页面自动跳转,页面加载时获取URL路径中携带的参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "healthCardInfoId", value = "健康卡信息记录ID(系统健康卡ID)",dataType = "String",defaultValue = "2C9580916F47F3AA016F47F3AA0F0000")
    })
    @RequestMapping(value="/{hospitalId}/addWechatPack", method=RequestMethod.GET)
    public void addWechatPack(@PathVariable("hospitalId") String hospitalId , @RequestParam(value = "healthCardInfoId" , defaultValue = "2C9580916F47F3AA016F47F3AA0F0000") String healthCardInfoId, HttpServletResponse response){
        try {
            HCSHealthCardInfo hcsHealthCardInfo = hcsHealthCardInfoService.getById(healthCardInfoId);
            String orderId = healthCardStationService.getOrderIdByOutAppId(hospitalId,hcsHealthCardInfo.getQrCodeText()) ;
            HCSHealthCardInfoRes hcsHealthCardInfoRes  = new HCSHealthCardInfoRes();
            BeanUtils.copyProperties(hcsHealthCardInfo,hcsHealthCardInfoRes);
            //改变名族为字典
            String nation = hcsHealthCardInfoRes.getNation();
            String nationDic = hcsHealthCardInfoService.getNationDicStr(nation);
            hcsHealthCardInfoRes.setIdNumber(IDCardUtil.coverStarts(hcsHealthCardInfoRes.getIdNumber(),8,14));
            hcsHealthCardInfoRes.setNation(nationDic);
            RELResultUtils<PageHrefRes> pageHrefRes = pageHrefFeignClient.getPageHrefsOpts("",hospitalId,"addWechatPack","");
            List<PageHrefRes> hrefs = pageHrefRes.getData();
            for (PageHrefRes herf : hrefs){
                //https://health.tengmed.com/open/takeMsCard?order_id=%s&redirect_uri=http://dev.jfatty.com/HealthCardDemo/personal.html
                String path = herf.getTargetHref() ;
                String params = getPostParams(hcsHealthCardInfoRes);
                params = URLEncoder.encode(params,"UTF-8");
                log.error("编码后的URL参数[{}]",params);
                String redirect_uri  = String.format(path,orderId) ;
                redirect_uri = redirect_uri + "?" + params ;
                log.error("加入微信卡包的重定向URL参数[{}]",redirect_uri);
                //加入微信卡包后去健康卡详情页面
                log.error("加入微信卡包后去健康卡详情页面 [{}]",redirect_uri);
                response.sendRedirect(redirect_uri);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("003**** 用户点击 加入微信卡包 跳转至微信卡包电子健康卡领取页面 出现异常[{}]",e.getMessage());
        }
    }


    /**
     *
     * @Title: getPostParams
     * @Description: 将实体类clazz的属性转换为url参数
     * @param clazz	参数实体类
     * @return
     * String
     */
    private String getPostParamsXXX(Object clazz) {
        Field[] fields = clazz.getClass().getDeclaredFields();

        StringBuilder requestURL = new StringBuilder();
        try {
            boolean flag = true;
            String property, value;
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                // 允许访问私有变量
                field.setAccessible(true);

                // 属性名
                property = field.getName();
                // 属性值
                value = field.get(clazz).toString();

                System.out.println(property+":"+value);
            }
        } catch (Exception e) {
            log.error("用户播放轨迹查询Qos 日志失败,参数为：" + clazz.toString());
        }
        return requestURL.toString();
    }


    /**
     *
     * @Title: getPostParams
     * @Description: 将实体类clazz的属性转换为url参数
     * @param clazz	参数实体类
     * @return
     * String
     */
    private static String getPostParams(Object clazz) {
        // 遍历属性类、属性值
        Field[] fields = clazz.getClass().getDeclaredFields();

        StringBuilder requestURL = new StringBuilder();
        try {
            boolean flag = true;
            String property, value;
            System.out.println(fields.length);

            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                // 允许访问私有变量
                field.setAccessible(true);

                // 属性名
                property = field.getName();
                Object tmp = field.get(clazz);
                if (tmp == null)
                    continue;
                // 属性值
                value = field.get(clazz).toString();
                String params = property + "=" + value;
                if (flag) {
                    requestURL.append(params);
                    flag = false;
                } else {
                    requestURL.append("&" + params);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("URL参数为：" + clazz.toString());
        }
        return requestURL.toString();
    }


//    public static void main(String[] args) {
//        HCSHealthCardInfoRes hcsHealthCardInfoRes  = new HCSHealthCardInfoRes();
//        hcsHealthCardInfoRes.setAddress("湖北");
//        hcsHealthCardInfoRes.setBirthday("1994-11-10");
//        hcsHealthCardInfoRes.setGender("男");
//        hcsHealthCardInfoRes.setHealthCardId("225585828");
//        hcsHealthCardInfoRes.setNation("土家族");
//        hcsHealthCardInfoRes.setName("杨三");
//        hcsHealthCardInfoRes.setIdNumber("2585858588");
//        String url = getPostParams(hcsHealthCardInfoRes);
//        System.out.println(url);
//    }



}
