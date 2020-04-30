package com.jfatty.zcloud.alipay.interfaces;

import com.jfatty.zcloud.alipay.entity.AlipayReceivetext;
import com.jfatty.zcloud.alipay.req.AlipayReceivetextReq;
import com.jfatty.zcloud.alipay.res.AlipayReceivetextRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 文本消息
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayReceivetext"})
public interface IAlipayReceivetext extends BInterface<AlipayReceivetext,AlipayReceivetextReq,AlipayReceivetextRes> {




}
