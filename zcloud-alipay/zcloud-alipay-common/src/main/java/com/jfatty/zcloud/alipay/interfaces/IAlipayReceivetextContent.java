package com.jfatty.zcloud.alipay.interfaces;

import com.jfatty.zcloud.alipay.entity.AlipayReceivetextContent;
import com.jfatty.zcloud.alipay.req.AlipayReceivetextContentReq;
import com.jfatty.zcloud.alipay.res.AlipayReceivetextContentRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 用户消息详情
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayReceivetextContent"})
public interface IAlipayReceivetextContent extends BInterface<AlipayReceivetextContent,AlipayReceivetextContentReq,AlipayReceivetextContentRes> {




}
