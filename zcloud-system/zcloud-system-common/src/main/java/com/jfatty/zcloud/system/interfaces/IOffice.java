package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.Office;
import com.jfatty.zcloud.system.req.OfficeReq;
import com.jfatty.zcloud.system.res.OfficeRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@RequestMapping(value={"/office"})
public interface IOffice extends BInterface<Office,OfficeReq,OfficeRes> {
}
