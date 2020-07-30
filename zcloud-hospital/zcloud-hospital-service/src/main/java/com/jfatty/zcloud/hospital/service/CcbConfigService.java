package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.CcbConfig;

/**
 * <p>
 * 建行支付配置信息表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2020-07-27
 */
public interface CcbConfigService extends BaseHospitalService<CcbConfig> {

    CcbConfig getByMchId(String mchId);

}
