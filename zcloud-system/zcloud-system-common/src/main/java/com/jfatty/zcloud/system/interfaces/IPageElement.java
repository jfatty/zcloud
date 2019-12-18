package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.PageElement;
import com.jfatty.zcloud.system.req.PageElementReq;
import com.jfatty.zcloud.system.res.PageElementRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/13
 * @email jfatty@163.com
 */
@RequestMapping(value={"/pageElement"})
public interface IPageElement extends BInterface<PageElement,PageElementReq,PageElementRes> {
}
