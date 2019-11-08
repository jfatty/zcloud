package com.jfatty.zcloud.alipay.service;

import com.jfatty.zcloud.alipay.entity.AlipayConfig;

import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */
public interface AlipayCoreService {


    String excute(Map<String, String> params, AlipayConfig config) throws Exception ;

}
