package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.AlipayConfig;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 支付宝支付配置信息表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-12-23
 */
public interface AlipayConfigMapper extends IBaseMapper<AlipayConfig> {

    AlipayConfig getByAppId(@Param("appId") String appId);
}
