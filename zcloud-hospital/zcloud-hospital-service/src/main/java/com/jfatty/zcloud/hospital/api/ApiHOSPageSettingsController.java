package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.hospital.entity.HOSPageSettings;
import com.jfatty.zcloud.hospital.interfaces.IHOSPageSettings;
import com.jfatty.zcloud.hospital.req.HOSPageSettingsReq;
import com.jfatty.zcloud.hospital.res.HOSPageSettingsRes;
import com.jfatty.zcloud.hospital.service.HOSPageSettingsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

