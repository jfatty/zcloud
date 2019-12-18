package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.PageConfig;
import com.jfatty.zcloud.system.req.PageConfigReq;
import com.jfatty.zcloud.system.res.PageConfigRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/13
 * @email jfatty@163.com
 */
@RequestMapping(value={"/pageConfig"})
public interface IPageConfig extends BInterface<PageConfig,PageConfigReq,PageConfigRes> {
}
