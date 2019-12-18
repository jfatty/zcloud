package com.jfatty.zcloud.hospital.controller;


import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.Menu;
import com.jfatty.zcloud.hospital.feign.MenuFeignClient;
import com.jfatty.zcloud.hospital.req.MenuReq;
import com.jfatty.zcloud.hospital.res.MenuRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 智慧医疗首页菜单表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController implements IBaseController<Menu,MenuReq,MenuRes> {

    @Autowired
    private MenuFeignClient menuFeignClient ;

    @Override
    public RELResultUtils<MenuRes> table(Map<String, Object> params) {
        return menuFeignClient.table(params);
    }

    @Override
    public RELResultUtils<MenuRes> table(String v, Integer pageIndex, Integer pageSize) {
        return menuFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return menuFeignClient.list();
    }

    @Override
    public List<MenuRes> list(Long v) {
        return menuFeignClient.list(v);
    }

    @Override
    public Object save(MenuReq entity) {
        return menuFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return menuFeignClient.view(id);
    }

    @Override
    public Object edit(MenuReq entity) {
        return menuFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return menuFeignClient.delete(params);
    }


}

