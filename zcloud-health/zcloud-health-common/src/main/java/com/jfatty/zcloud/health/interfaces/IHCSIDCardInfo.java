package com.jfatty.zcloud.health.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.health.entity.HCSIDCardInfo;
import com.jfatty.zcloud.health.req.HCSIDCardInfoReq;
import com.jfatty.zcloud.health.res.HCSIDCardInfoRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/idCardInfo"})
public interface IHCSIDCardInfo extends BInterface<HCSIDCardInfo,HCSIDCardInfoReq,HCSIDCardInfoRes> {



}
