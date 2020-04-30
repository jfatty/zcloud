package com.jfatty.zcloud.alipay.interfaces;

import com.jfatty.zcloud.alipay.entity.AlipayTexttemplate;
import com.jfatty.zcloud.alipay.req.AlipayTexttemplateReq;
import com.jfatty.zcloud.alipay.res.AlipayTexttemplateRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 文本模板
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayTexttemplate"})
public interface IAlipayTexttemplate extends BInterface<AlipayTexttemplate,AlipayTexttemplateReq,AlipayTexttemplateRes> {




}
