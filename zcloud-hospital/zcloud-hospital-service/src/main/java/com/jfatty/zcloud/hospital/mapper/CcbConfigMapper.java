package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.CcbConfig;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 建行支付配置信息表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-07-27
 */
public interface CcbConfigMapper extends IBaseMapper<CcbConfig> {

    CcbConfig getByMchId(@Param("mchId") String mchId);
}
