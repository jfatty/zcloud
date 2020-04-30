package com.jfatty.zcloud.alipay.interfaces;

import com.jfatty.zcloud.alipay.entity.AlipayGzentity;
import com.jfatty.zcloud.alipay.req.AlipayGzentityReq;
import com.jfatty.zcloud.alipay.res.AlipayGzentityRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 关注回复
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayGzentity"})
public interface IAlipayGzentity extends BInterface<AlipayGzentity,AlipayGzentityReq,AlipayGzentityRes> {



}
