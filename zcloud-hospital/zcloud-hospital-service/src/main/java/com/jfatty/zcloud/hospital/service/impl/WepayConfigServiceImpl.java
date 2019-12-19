package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.WepayConfig;
import com.jfatty.zcloud.hospital.mapper.WepayConfigMapper;
import com.jfatty.zcloud.hospital.service.WepayConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信支付配置信息表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-19
 */
@Slf4j
@Service
public class WepayConfigServiceImpl extends BaseHospitalServiceImpl<WepayConfig , WepayConfigMapper> implements WepayConfigService {

    private WepayConfigMapper wepayConfigMapper ;

    @Autowired
    public void setWepayConfigMapper(WepayConfigMapper wepayConfigMapper) {
        super.setBaseMapper(wepayConfigMapper);
        this.wepayConfigMapper = wepayConfigMapper;
    }

    @Override
    public WepayConfig getByAppId(String appId) {
        return wepayConfigMapper.getByAppId(appId);
    }
}
