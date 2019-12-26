package com.jfatty.zcloud.health.api;


import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.interfaces.IHealthCardSettings;
import com.jfatty.zcloud.health.req.HealthCardSettingsReq;
import com.jfatty.zcloud.health.res.HealthCardSettingsRes;
import com.jfatty.zcloud.health.service.HealthCardSettingsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 电子健康卡平台配置信息表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-26
 */
@Api(tags = "电子健康卡平台配置信息API" ,value = "电子健康卡平台配置信息")
@Slf4j
@RestController
@RequestMapping(value={"/api/healthCardSettings"})
public class ApiHealthCardSettingsController  extends ApiBaseHealthController<HealthCardSettings,HealthCardSettingsReq,HealthCardSettingsRes>  implements IHealthCardSettings {

    private HealthCardSettingsService healthCardSettingsService ;

    @Autowired
    public void setHealthCardSettingsService(HealthCardSettingsService healthCardSettingsService) {
        super.setBaseService(healthCardSettingsService);
        this.healthCardSettingsService = healthCardSettingsService;
    }
}

