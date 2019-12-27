package com.jfatty.zcloud.health.api;

import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.health.entity.HCSHealthCardInfo;
import com.jfatty.zcloud.health.req.HCSHealthCardInfoReq;
import com.jfatty.zcloud.health.res.DynamicQRCodeRes;
import com.jfatty.zcloud.health.res.HCSHealthCardInfoRes;
import com.jfatty.zcloud.health.res.RegBatHealthCardInfoRes;
import com.jfatty.zcloud.health.res.RegHealthCardInfoRes;
import com.jfatty.zcloud.health.service.HCSHealthCardInfoService;
import com.jfatty.zcloud.health.service.HealthCardStationService;
import com.jfatty.zcloud.health.vo.DynamicQRCodeVO;
import com.jfatty.zcloud.health.vo.HealthCardInfoVO;
import com.jfatty.zcloud.health.vo.ReportHISDataVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Api(tags = "电子健康卡平台**对接**API" ,value = "电子健康卡平台**对接**")
@Slf4j
@RestController
@RequestMapping(value={"/api/healthCardStation"})
public class ApiHealthCardStationController {

    @Autowired
    private HealthCardStationService healthCardStationService ;

    @Autowired
    private HCSHealthCardInfoService hcsHealthCardInfoService ;


    @ApiOperation(value=" 001**** 3.2.2 注册健康卡接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379")
    })
    @RequestMapping(value="/registerHealthCard", method=RequestMethod.POST)
    public RETResultUtils<RegHealthCardInfoRes> registerHealthCard(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId, @RequestBody HCSHealthCardInfoReq hcsHealthCardInfoReq){
        try {
            HCSHealthCardInfo hcsHealthCardInfo = new HCSHealthCardInfo();
            BeanUtils.copyProperties(hcsHealthCardInfoReq,hcsHealthCardInfo);
            hcsHealthCardInfoService.save(hcsHealthCardInfo,null);
            RegHealthCardInfoRes regHealthCardInfoRes = new RegHealthCardInfoRes();
            HealthCardInfoVO healthCardInfoVO = healthCardStationService.registerHealthCard(appId,hcsHealthCardInfoReq);
            BeanUtils.copyProperties(healthCardInfoVO,regHealthCardInfoRes);
            return new RETResultUtils(regHealthCardInfoRes) ;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


    @ApiOperation(value=" 002**** 3.2.3 通过健康卡授权码获取接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "healthCode", value = "版本号",dataType = "String",defaultValue = "F9D3F8A308FC0EABC581F5903CAA1094")
    })
    @RequestMapping(value="/getHealthCardByHealthCode", method=RequestMethod.GET)
    public  RETResultUtils<HCSHealthCardInfoRes> getHealthCardByHealthCode(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId , @RequestParam(value = "healthCode" , defaultValue = "F9D3F8A308FC0EABC581F5903CAA1094") String healthCode){
        try {
            HCSHealthCardInfoRes hcsHealthCardInfoRes  = new HCSHealthCardInfoRes();
            HealthCardInfoVO healthCardInfoVO = healthCardStationService.getHealthCardByHealthCode(appId,healthCode);
            BeanUtils.copyProperties(healthCardInfoVO,hcsHealthCardInfoRes);
            return new RETResultUtils(hcsHealthCardInfoRes) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    @ApiOperation(value=" 003**** 3.2.4 通过健康卡二维码获取接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "qrCodeText", value = "版本号",dataType = "String",defaultValue = "1.0.0")
    })
    @RequestMapping(value="/getHealthCardByQRCode", method=RequestMethod.POST)
    public RETResultUtils<HCSHealthCardInfoRes>  getHealthCardByQRCode(@RequestParam(value = "appId" , defaultValue = "sdbhlajksddasbdjsb" ) String appId , @RequestParam(value = "qrCodeText" , defaultValue = "shuhsuuhusaw9882828j") String qrCodeText ){

        try {
            HCSHealthCardInfoRes hcsHealthCardInfoRes  = new HCSHealthCardInfoRes();
            HealthCardInfoVO healthCardInfoVO = healthCardStationService.getHealthCardByQRCode(appId,qrCodeText);
            BeanUtils.copyProperties(healthCardInfoVO,hcsHealthCardInfoRes);
            return new RETResultUtils(hcsHealthCardInfoRes) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @ApiOperation(value=" 004**** 3.2.6 绑定健康卡和院内 ID 关系接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "patId", value = "版本号",dataType = "String",defaultValue = "1.0.0"),
            @ApiImplicitParam(name = "qrCodeText", value = "操作码例如 绑定就诊卡 预约挂号 添加就诊人",dataType = "String",defaultValue = "yygh")
    })
    @RequestMapping(value="/bindCardRelation", method=RequestMethod.POST)
    public RETResultUtils<Boolean> bindCardRelation(@RequestParam(value = "appId" , defaultValue = "sdbhlajksddasbdjsb" ) String appId , @RequestParam(value = "patId" , defaultValue = "patId") String patId,//
                                                    @RequestParam(value = "qrCodeText" , defaultValue = "shuhsuuhusaw9882828j") String qrCodeText ){

        try {
            return  new RETResultUtils(healthCardStationService.bindCardRelation(appId,patId,qrCodeText)) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    @ApiOperation(value=" 005**** 3.2.7 用卡数据监测接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379")
    })
    @RequestMapping(value="/reportHISData", method=RequestMethod.POST)
    public Object reportHISData(@RequestParam(value = "appId" , defaultValue = "sdbhlajksddasbdjsb" ) String appId , @RequestBody ReportHISDataVO reportHISDataVO ){
        try {
            healthCardStationService.reportHISData(appId,reportHISDataVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @ApiOperation(value=" 006**** 3.2.8 获取卡包订单  ID接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "qrCodeText", value = "操作码例如 绑定就诊卡 预约挂号 添加就诊人",dataType = "String",defaultValue = "yygh")
    })
    @RequestMapping(value="/getOrderIdByOutAppId", method=RequestMethod.GET)
    public RETResultUtils<String> getOrderIdByOutAppId(@RequestParam(value = "appId" , defaultValue = "sdbhlajksddasbdjsb" ) String appId ,  @RequestParam(value = "qrCodeText" , defaultValue = "shuhsuuhusaw9882828j") String qrCodeText  ){
        try {
            return new RETResultUtils(healthCardStationService.getOrderIdByOutAppId(appId,qrCodeText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @ApiOperation(value=" 007**** 3.2.9 注册批量健康卡接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "qrCodeText", value = "操作码例如 绑定就诊卡 预约挂号 添加就诊人",dataType = "String",defaultValue = "yygh")
    })
    @RequestMapping(value="/registerBatchHealthCard", method=RequestMethod.POST)
    public RETResultUtils<List<RegBatHealthCardInfoRes>> registerBatchHealthCard(@RequestParam(value = "appId" , defaultValue = "sdbhlajksddasbdjsb" ) String appId , @RequestParam(value = "qrCodeText" , defaultValue = "shuhsuuhusaw9882828j") String qrCodeText  ){
        try {
            List<HealthCardInfoVO> healthCardInfos = new ArrayList<HealthCardInfoVO>();
            List<HealthCardInfoVO> list = healthCardStationService.registerBatchHealthCard(appId,healthCardInfos);
            List<RegBatHealthCardInfoRes> regBatHealthCardInfos = new ArrayList<RegBatHealthCardInfoRes>();
            list.forEach(
                    healthCardInfo -> {
                        RegBatHealthCardInfoRes info = new RegBatHealthCardInfoRes();
                        BeanUtils.copyProperties(healthCardInfo,info);
                        regBatHealthCardInfos.add(info);
                    }
            );
            return new RETResultUtils(regBatHealthCardInfos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @ApiOperation(value=" 008**** 3.2.10 获取动态二维码接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "healthCardId", value = "版本号",dataType = "String",defaultValue = "1.0.0"),
            @ApiImplicitParam(name = "idType", value = "操作码例如 绑定就诊卡 预约挂号 添加就诊人",dataType = "String",defaultValue = "yygh"),
            @ApiImplicitParam(name = "idNumber", value = "操作码例如 绑定就诊卡 预约挂号 添加就诊人",dataType = "String",defaultValue = "yygh")
    })
    @RequestMapping(value="/getDynamicQRCode", method=RequestMethod.GET)
    public RETResultUtils<DynamicQRCodeRes>  getDynamicQRCode(@RequestParam(value = "appId" , defaultValue = "sdbhlajksddasbdjsb" ) String appId , @RequestParam(value = "healthCardId" , defaultValue = "healthCardId") String healthCardId ,
                                                              @RequestParam(value = "idType" , defaultValue = "idType") String idType , @RequestParam(value = "idNumber" , defaultValue = "idNumber") String idNumber ){
        try {
            DynamicQRCodeRes dynamicQRCodeRes = new DynamicQRCodeRes();
            DynamicQRCodeVO dynamicQRCodeVO =  healthCardStationService.getDynamicQRCode(appId,healthCardId,idType,idNumber);
            BeanUtils.copyProperties(dynamicQRCodeVO,dynamicQRCodeRes);
            return new RETResultUtils(dynamicQRCodeRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
