package com.jfatty.zcloud.system.controller;


import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.PageElement;
import com.jfatty.zcloud.system.feign.PageElementFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 界面标签元素开发配置 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Slf4j
@RestController
@RequestMapping("/pageElement")
public class PageElementController  implements IBaseController<PageElement> {

    @Autowired
    private PageElementFeignClient pageElementFeignClient;

    @Override
    public RELResultUtils<PageElement> table(Map<String, Object> params) {
        return pageElementFeignClient.table(params);
    }

    @Override
    public RELResultUtils<PageElement> table(String v, Integer pageIndex, Integer pageSize) {
        return pageElementFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return pageElementFeignClient.list();
    }

    @Override
    public List<PageElement> list(Long v) {
        return pageElementFeignClient.list(v);
    }

    @Override
    public Object save(PageElement entity) {
        return pageElementFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return pageElementFeignClient.view(id);
    }

    @Override
    public Object edit(PageElement entity) {
        return pageElementFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return pageElementFeignClient.delete(params);
    }
}

