package com.jfatty.zcloud.alipay.mapper;

import com.jfatty.zcloud.alipay.entity.AlipayConfig;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 支付宝支付配置信息表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-11-08
 */
public interface AlipayConfigMapper extends IBaseMapper<AlipayConfig> {


    /**
     * 根据appid获取对应支付宝生活服务号或者支付配置信息
     * @param appid
     * @return
     */
    AlipayConfig getAlipayConfig(@Param("appid") String appid);

}
