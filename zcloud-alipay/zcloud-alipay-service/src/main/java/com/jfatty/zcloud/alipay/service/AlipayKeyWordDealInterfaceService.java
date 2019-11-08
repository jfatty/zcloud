package com.jfatty.zcloud.alipay.service;

import com.jfatty.zcloud.alipay.entity.AlipayConfig;

/**
 * 描述 关键字处理接口，以后对关注有任何的处理只实现接口
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */
public interface AlipayKeyWordDealInterfaceService {

    /**
     * 关键字处理接口方法
     * @param content 接受文本内容
     * @param toUserid 微信公众账号ID
     */
    String dealKeyMessage(String content, AlipayConfig config, String toUserid);

}
