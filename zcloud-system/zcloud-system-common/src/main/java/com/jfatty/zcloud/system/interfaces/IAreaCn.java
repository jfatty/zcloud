package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.AreaCn;
import com.jfatty.zcloud.system.req.AreaCnReq;
import com.jfatty.zcloud.system.res.AreaCnRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/27
 * @email jfatty@163.com
 */
@RequestMapping(value={"/areaCn"})
public interface IAreaCn  extends BInterface<AreaCn,AreaCnReq,AreaCnRes> {

}
