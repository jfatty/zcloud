package com.jfatty.zcloud.alipay.mapper;

import com.jfatty.zcloud.alipay.entity.AlipayAuthCode;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface AlipayAuthCodeMapper extends IBaseMapper<AlipayAuthCode> {


    AlipayAuthCode getByAuthCode(@Param("code") String code, @Param("appId") String appId);

}
