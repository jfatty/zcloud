package com.jfatty.zcloud.alipay.core;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.jfatty.zcloud.alipay.entity.AlipayConfig;

public class AlipayClientFactory {

	public static  AlipayClient getAlipayClientInstance(AlipayConfig config) {
		AlipayClient client = new DefaultAlipayClient(config.getAlipayGateway(), config.getAppid(), config.getPrivateKey(),
				config.getAlipayFormat(), config.getSignCharset(), config.getAlipayPublicKey(),config.getSignType());
		return client;
	}
}