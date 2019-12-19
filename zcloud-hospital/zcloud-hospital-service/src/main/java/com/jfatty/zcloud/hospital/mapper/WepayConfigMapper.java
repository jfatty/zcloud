package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.WepayConfig;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 微信支付配置信息表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-12-19
 */
public interface WepayConfigMapper extends IBaseMapper<WepayConfig> {

    WepayConfig getByAppId(@Param("appId") String appId);
}
