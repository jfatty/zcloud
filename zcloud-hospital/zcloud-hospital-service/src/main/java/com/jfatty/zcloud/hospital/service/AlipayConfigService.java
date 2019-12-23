package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.AlipayConfig;

/**
 * <p>
 * 支付宝支付配置信息表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-23
 */
public interface AlipayConfigService extends BaseHospitalService<AlipayConfig> {

    AlipayConfig getByAppId(String appId);
}
