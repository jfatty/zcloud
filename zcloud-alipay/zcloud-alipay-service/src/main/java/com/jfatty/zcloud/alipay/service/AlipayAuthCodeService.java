package com.jfatty.zcloud.alipay.service;

import com.jfatty.zcloud.alipay.entity.AlipayAuthCode;
import com.jfatty.zcloud.base.service.BaseService;

public interface AlipayAuthCodeService extends BaseService<AlipayAuthCode> {


    AlipayAuthCode getByAuthCode(String code, String appId);
}
