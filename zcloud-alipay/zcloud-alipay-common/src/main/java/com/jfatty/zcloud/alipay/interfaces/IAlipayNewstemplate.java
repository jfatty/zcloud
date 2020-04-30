package com.jfatty.zcloud.alipay.interfaces;

import com.jfatty.zcloud.alipay.entity.AlipayNewstemplate;
import com.jfatty.zcloud.alipay.req.AlipayNewstemplateReq;
import com.jfatty.zcloud.alipay.res.AlipayNewstemplateRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 图文素材模板
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayNewstemplate"})
public interface IAlipayNewstemplate extends BInterface<AlipayNewstemplate,AlipayNewstemplateReq,AlipayNewstemplateRes> {


}
