package com.jfatty.zcloud.alipay.interfaces;

import com.jfatty.zcloud.alipay.entity.AlipayAutoresponse;
import com.jfatty.zcloud.alipay.req.AlipayAutoresponseReq;
import com.jfatty.zcloud.alipay.res.AlipayAutoresponseRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 支付宝自动回复
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayAutoresponse"})
public interface IAlipayAutoresponse extends BInterface<AlipayAutoresponse,AlipayAutoresponseReq,AlipayAutoresponseRes> {



}
