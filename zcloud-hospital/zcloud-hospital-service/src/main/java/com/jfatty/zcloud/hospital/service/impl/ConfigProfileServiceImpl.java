package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.ConfigProfile;
import com.jfatty.zcloud.hospital.mapper.ConfigProfileMapper;
import com.jfatty.zcloud.hospital.service.ConfigProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 智慧医疗系统配置配置 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2020-05-20
 */
@Slf4j
@Service
public class ConfigProfileServiceImpl extends BaseHospitalServiceImpl<ConfigProfile, ConfigProfileMapper> implements ConfigProfileService {


    private ConfigProfileMapper configProfileMapper ;

    @Autowired
    public void setConfigProfileMapper(ConfigProfileMapper configProfileMapper) {
        super.setBaseMapper(configProfileMapper);
        this.configProfileMapper = configProfileMapper;
    }

    @Override
    public ConfigProfile getConfigProfileByAppId(String appId) {
        return configProfileMapper.getConfigProfileByAppId(appId);
    }
}
