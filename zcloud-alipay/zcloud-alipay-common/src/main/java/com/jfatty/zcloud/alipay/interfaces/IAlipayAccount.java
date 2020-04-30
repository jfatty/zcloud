package com.jfatty.zcloud.alipay.interfaces;

import com.jfatty.zcloud.alipay.entity.AlipayAccount;
import com.jfatty.zcloud.alipay.req.AlipayAccountReq;
import com.jfatty.zcloud.alipay.res.AlipayAccountRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 支付宝账号信息
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayAccount"})
public interface IAlipayAccount extends BInterface<AlipayAccount,AlipayAccountReq,AlipayAccountRes> {



}
