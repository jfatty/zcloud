package com.jfatty.zcloud.alipay.service;

import com.jfatty.zcloud.alipay.entity.AlipayReceivetext;

/**
 * 描述 文本处理接口
 *
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */
public interface AlipayTextDealInterfaceService {

    /**
     * 文本消息处理接口
     * @param receiveText 文本消息实体类
     */
    void dealTextMessage(AlipayReceivetext receiveText);

}
