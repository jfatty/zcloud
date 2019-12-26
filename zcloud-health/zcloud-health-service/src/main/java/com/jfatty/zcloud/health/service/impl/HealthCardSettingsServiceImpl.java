package com.jfatty.zcloud.health.service.impl;


import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.mapper.HealthCardSettingsMapper;
import com.jfatty.zcloud.health.service.HealthCardSettingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电子健康卡平台配置信息表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-26
 */
@Slf4j
@Service
public class HealthCardSettingsServiceImpl extends BaseHealthServiceImpl<HealthCardSettings,HealthCardSettingsMapper> implements HealthCardSettingsService {

    private HealthCardSettingsMapper healthCardSettingsMapper ;

    @Autowired
    public void setHealthCardSettingsMapper(HealthCardSettingsMapper healthCardSettingsMapper) {
        super.setBaseMapper(healthCardSettingsMapper);
        this.healthCardSettingsMapper = healthCardSettingsMapper;
    }

}
