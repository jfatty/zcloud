package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.WepayConfig;
import com.jfatty.zcloud.hospital.req.WepayConfigReq;
import com.jfatty.zcloud.hospital.res.WepayConfigRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/19
 * @email jfatty@163.com
 */
@RequestMapping(value={"/protocol"})
public interface IWepayConfig extends BInterface<WepayConfig,WepayConfigReq,WepayConfigRes> {
}
