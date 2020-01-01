package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.PageImage;
import com.jfatty.zcloud.system.req.PageImageReq;
import com.jfatty.zcloud.system.res.PageImageRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/31
 * @email jfatty@163.com
 */
@RequestMapping(value={"/pageImage"})
public interface IPageImage extends BInterface<PageImage,PageImageReq,PageImageRes> {

}
