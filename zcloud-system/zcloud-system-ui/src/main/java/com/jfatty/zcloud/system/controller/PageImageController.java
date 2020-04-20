package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.PageImage;
import com.jfatty.zcloud.system.feign.PageImageFeignClient;
import com.jfatty.zcloud.system.req.PageImageReq;
import com.jfatty.zcloud.system.res.PageImageRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述 界面图片开发配置
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping("/pageImage")
public class PageImageController  implements IBaseController<PageImage,PageImageReq,PageImageRes> {

    @Autowired
    private PageImageFeignClient  pageImageFeignClient ;

    @Override
    public RELResultUtils<PageImageRes> table(Map<String, Object> params) {
        return pageImageFeignClient.table(params);
    }

    @Override
    public RELResultUtils<PageImageRes> table(String v, Integer pageIndex, Integer pageSize) {
        return pageImageFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return pageImageFeignClient.list();
    }

    @Override
    public List<PageImageRes> list(Long v) {
        return pageImageFeignClient.list(v);
    }

    @Override
    public Object save(PageImageReq entity) {
        return pageImageFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return pageImageFeignClient.view(id);
    }

    @Override
    public Object edit(PageImageReq entity) {
        return pageImageFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return pageImageFeignClient.delete(params);
    }
}
