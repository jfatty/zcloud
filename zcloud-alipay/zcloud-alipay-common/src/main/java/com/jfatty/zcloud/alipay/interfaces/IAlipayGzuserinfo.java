package com.jfatty.zcloud.alipay.interfaces;

import com.jfatty.zcloud.alipay.entity.AlipayGzuserinfo;
import com.jfatty.zcloud.alipay.req.AlipayGzuserinfoReq;
import com.jfatty.zcloud.alipay.res.AlipayGzuserinfoRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 支付宝关注用户 接口
 *
 * @author jfatty on 2019/11/11
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayGzuserinfo"})
public interface IAlipayGzuserinfo  extends BInterface<AlipayGzuserinfo,AlipayGzuserinfoReq,AlipayGzuserinfoRes> {


}
