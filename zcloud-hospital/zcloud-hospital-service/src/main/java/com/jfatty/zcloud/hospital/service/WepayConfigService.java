package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.WepayConfig;

/**
 * <p>
 * 微信支付配置信息表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-19
 */
public interface WepayConfigService extends BaseHospitalService<WepayConfig> {

    WepayConfig getByAppId(String appId);
}
