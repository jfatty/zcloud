package com.jfatty.zcloud.alipay.interfaces;

import com.jfatty.zcloud.alipay.entity.AlipayMenu;
import com.jfatty.zcloud.alipay.req.AlipayMenuReq;
import com.jfatty.zcloud.alipay.res.AlipayMenuRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 支付宝菜单
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayMenu"})
public interface IAlipayMenu extends BInterface<AlipayMenu,AlipayMenuReq,AlipayMenuRes> {



}
