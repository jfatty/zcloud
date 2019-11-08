package com.jfatty.zcloud.alipay.service;

import com.jfatty.zcloud.alipay.entity.AlipayConfig;
import com.jfatty.zcloud.base.service.BaseService;

/**
 * <p>
 * 支付宝支付配置信息表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-11-08
 */
public interface AlipayConfigService extends BaseService<AlipayConfig> {

    /**
     * 根据appid获取对应支付宝生活服务号或者支付配置信息
     * @param appid
     * @return
     */
    AlipayConfig getAlipayConfig(String appid);
}
