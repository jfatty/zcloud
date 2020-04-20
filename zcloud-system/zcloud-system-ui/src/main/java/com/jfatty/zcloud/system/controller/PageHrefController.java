package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.PageHref;
import com.jfatty.zcloud.system.feign.PageHrefFeignClient;
import com.jfatty.zcloud.system.req.PageHrefReq;
import com.jfatty.zcloud.system.res.PageHrefRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * 描述 界面链接跳转开发配置
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */

@Slf4j
@RestController
@RequestMapping("/pageHref")
public class PageHrefController  implements IBaseController<PageHref,PageHrefReq,PageHrefRes> {

    @Autowired
    private PageHrefFeignClient pageHrefFeignClient ;


    @Override
    public RELResultUtils<PageHrefRes> table(Map<String, Object> params) {
        return pageHrefFeignClient.table(params);
    }

    @Override
    public RELResultUtils<PageHrefRes> table(String v, Integer pageIndex, Integer pageSize) {
        return pageHrefFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return pageHrefFeignClient.list();
    }

    @Override
    public List<PageHrefRes> list(Long v) {
        return pageHrefFeignClient.list(v);
    }

    @Override
    public Object save(PageHrefReq entity) {
        return pageHrefFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return pageHrefFeignClient.view(id);
    }

    @Override
    public Object edit(PageHrefReq entity) {
        return pageHrefFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return pageHrefFeignClient.delete(params);
    }
}
