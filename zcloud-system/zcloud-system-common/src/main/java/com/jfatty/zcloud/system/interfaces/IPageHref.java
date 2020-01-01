package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.PageHref;
import com.jfatty.zcloud.system.req.PageHrefReq;
import com.jfatty.zcloud.system.res.PageHrefRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2020/1/1
 * @email jfatty@163.com
 */
@RequestMapping(value={"/pageHref"})
public interface IPageHref extends BInterface<PageHref,PageHrefReq,PageHrefRes> {


}
