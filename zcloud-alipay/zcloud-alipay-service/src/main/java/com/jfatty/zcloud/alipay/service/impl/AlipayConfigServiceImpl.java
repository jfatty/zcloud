package com.jfatty.zcloud.alipay.service.impl;

import com.jfatty.zcloud.alipay.entity.AlipayConfig;
import com.jfatty.zcloud.alipay.mapper.AlipayConfigMapper;
import com.jfatty.zcloud.alipay.service.AlipayConfigService;
import com.jfatty.zcloud.base.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付宝支付配置信息表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-11-08
 */
@Slf4j
@Service
public class AlipayConfigServiceImpl extends BaseServiceImpl<AlipayConfig, AlipayConfigMapper> implements AlipayConfigService {

    private AlipayConfigMapper alipayConfigMapper ;

    @Autowired
    public void setAlipayConfigMapper(AlipayConfigMapper alipayConfigMapper) {
        super.setBaseMapper(alipayConfigMapper);
        this.alipayConfigMapper = alipayConfigMapper;
    }

    @Override
    public AlipayConfig getAlipayConfig(String appid) {
        return alipayConfigMapper.getAlipayConfig(appid);
    }
}
