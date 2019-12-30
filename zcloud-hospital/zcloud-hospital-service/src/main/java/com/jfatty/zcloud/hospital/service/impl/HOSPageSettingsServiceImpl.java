package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.HOSPageSettings;
import com.jfatty.zcloud.hospital.mapper.HOSPageSettingsMapper;
import com.jfatty.zcloud.hospital.service.HOSPageSettingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 智慧医疗页面配置信息表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-30
 */
@Slf4j
@Service
public class HOSPageSettingsServiceImpl extends BaseHospitalServiceImpl<HOSPageSettings, HOSPageSettingsMapper> implements HOSPageSettingsService {

    private HOSPageSettingsMapper hosPageSettingsMapper ;

    @Autowired
    public void setHosPageSettingsMapper(HOSPageSettingsMapper hosPageSettingsMapper) {
        super.setBaseMapper(hosPageSettingsMapper);
        this.hosPageSettingsMapper = hosPageSettingsMapper;
    }
}
