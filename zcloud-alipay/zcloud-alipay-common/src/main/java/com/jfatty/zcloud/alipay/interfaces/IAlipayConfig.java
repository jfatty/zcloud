package com.jfatty.zcloud.alipay.interfaces;

import com.jfatty.zcloud.alipay.entity.AlipayConfig;
import com.jfatty.zcloud.alipay.req.AlipayConfigReq;
import com.jfatty.zcloud.alipay.res.AlipayConfigRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 支付宝支付配置信息
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayConfig"})
public interface IAlipayConfig extends BInterface<AlipayConfig,AlipayConfigReq,AlipayConfigRes> {


}
