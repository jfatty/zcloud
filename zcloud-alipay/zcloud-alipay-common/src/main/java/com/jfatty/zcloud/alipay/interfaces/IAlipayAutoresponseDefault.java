package com.jfatty.zcloud.alipay.interfaces;

import com.jfatty.zcloud.alipay.entity.AlipayAutoresponseDefault;
import com.jfatty.zcloud.alipay.req.AlipayAutoresponseDefaultReq;
import com.jfatty.zcloud.alipay.res.AlipayAutoresponseDefaultRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 默认关键字回复
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayAutoresponseDefault"})
public interface IAlipayAutoresponseDefault extends BInterface<AlipayAutoresponseDefault,AlipayAutoresponseDefaultReq,AlipayAutoresponseDefaultRes> {



}
