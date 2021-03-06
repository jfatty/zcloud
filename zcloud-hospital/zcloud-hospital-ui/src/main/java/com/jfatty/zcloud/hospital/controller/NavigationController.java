package com.jfatty.zcloud.hospital.controller;


import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.Navigation;
import com.jfatty.zcloud.hospital.feign.NavigationFeignClient;
import com.jfatty.zcloud.hospital.req.NavigationReq;
import com.jfatty.zcloud.hospital.res.NavigationRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Slf4j
@RestController
@RequestMapping("/navigation")
public class NavigationController implements IBaseController<Navigation,NavigationReq,NavigationRes> {

    @Autowired
    private NavigationFeignClient navigationFeignClient ;

    @Override
    public RELResultUtils<NavigationRes> table(Map<String, Object> params) {
        return navigationFeignClient.table(params);
    }

    @Override
    public RELResultUtils<NavigationRes> table(String v, Integer pageIndex, Integer pageSize) {
        return navigationFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return navigationFeignClient.list();
    }

    @Override
    public List<NavigationRes> list(Long v) {
        return navigationFeignClient.list(v);
    }

    @Override
    public Object save(NavigationReq entity) {
        return navigationFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return navigationFeignClient.view(id);
    }

    @Override
    public Object edit(NavigationReq entity) {
        return navigationFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return navigationFeignClient.delete(params);
    }

}

