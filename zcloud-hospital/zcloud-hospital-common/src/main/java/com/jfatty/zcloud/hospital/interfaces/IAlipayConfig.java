package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.AlipayConfig;
import com.jfatty.zcloud.hospital.req.AlipayConfigReq;
import com.jfatty.zcloud.hospital.res.AlipayConfigRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/24
 * @email jfatty@163.com
 */
@RequestMapping(value={"/alipayConfig"})
public interface IAlipayConfig extends BInterface<AlipayConfig,AlipayConfigReq,AlipayConfigRes> {



}
