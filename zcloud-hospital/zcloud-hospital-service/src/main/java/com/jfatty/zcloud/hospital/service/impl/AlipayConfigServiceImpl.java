package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.AlipayConfig;
import com.jfatty.zcloud.hospital.mapper.AlipayConfigMapper;
import com.jfatty.zcloud.hospital.service.AlipayConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付宝支付配置信息表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-23
 */
@Slf4j
@Service
public class AlipayConfigServiceImpl extends BaseHospitalServiceImpl<AlipayConfig, AlipayConfigMapper> implements AlipayConfigService {

    private AlipayConfigMapper alipayConfigMapper ;


    @Autowired
    public void setAlipayConfigMapper(AlipayConfigMapper alipayConfigMapper) {
        super.setBaseMapper(alipayConfigMapper);
        this.alipayConfigMapper = alipayConfigMapper;
    }

    @Override
    public AlipayConfig getByAppId(String appId) {
        return alipayConfigMapper.getByAppId(appId);
    }
}
