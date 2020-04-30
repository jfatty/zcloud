package com.jfatty.zcloud.alipay.interfaces;

import com.jfatty.zcloud.alipay.entity.AlipayNewsitem;
import com.jfatty.zcloud.alipay.req.AlipayNewsitemReq;
import com.jfatty.zcloud.alipay.res.AlipayNewsitemRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 图文素材新闻
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayNewsitem"})
public interface IAlipayNewsitem extends BInterface<AlipayNewsitem,AlipayNewsitemReq,AlipayNewsitemRes> {




}
