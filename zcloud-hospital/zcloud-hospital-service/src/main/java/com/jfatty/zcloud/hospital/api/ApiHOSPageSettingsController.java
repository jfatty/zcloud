package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.hospital.entity.HOSPageSettings;
import com.jfatty.zcloud.hospital.interfaces.IHOSPageSettings;
import com.jfatty.zcloud.hospital.req.HOSPageSettingsReq;
import com.jfatty.zcloud.hospital.res.HOSPageSettingsRes;
import com.jfatty.zcloud.hospital.service.HOSPageSettingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 智慧医疗页面配置信息表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-30
 */
@Api(tags = "智慧医疗页面配置信息API" ,value = "智慧医疗页面配置信息")
@Slf4j
@RestController
@RequestMapping("/api/pageSettings")
public class ApiHOSPageSettingsController  extends ApiBaseHospitalController<HOSPageSettings,HOSPageSettingsReq,HOSPageSettingsRes>  implements IHOSPageSettings {

    private HOSPageSettingsService hosPageSettingsService ;

    @Autowired
    public void setHosPageSettingsService(HOSPageSettingsService hosPageSettingsService) {
        super.setBaseService(hosPageSettingsService);
        this.hosPageSettingsService = hosPageSettingsService;
    }


    @ApiOperation(value="001****首页页面配置信息获取")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",required = true,defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "version", value = "版本号",required = true,dataType = "String",defaultValue = "4.0.0")
    })
    @RequestMapping(value={"/getPageSettings"},method=RequestMethod.GET)
    public RETResultUtils<HOSPageSettingsRes> getPageSettings(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId  ,
                                                       @RequestParam(value = "version" , defaultValue = "4.0.0") String version ) {
        HOSPageSettings hosPageSettings = hosPageSettingsService.getByAppId(appId,version);
        if (hosPageSettings == null)
            return RETResultUtils._509(appId+"未查询到页面配置信息");
        HOSPageSettingsRes hosPageSettingsRes = new HOSPageSettingsRes();
        BeanUtils.copyProperties(hosPageSettings,hosPageSettingsRes);
        return  new RETResultUtils(hosPageSettingsRes);
    }



}

