package com.jfatty.zcloud.health.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.health.entity.HCSHealthCardInfo;
import com.jfatty.zcloud.health.req.HCSHealthCardInfoReq;
import com.jfatty.zcloud.health.res.HCSHealthCardInfoRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/27
 * @email jfatty@163.com
 */
@RequestMapping(value={"/healthCardInfo"})
public interface IHCSHealthCardInfo extends BInterface<HCSHealthCardInfo,HCSHealthCardInfoReq,HCSHealthCardInfoRes> {

}
