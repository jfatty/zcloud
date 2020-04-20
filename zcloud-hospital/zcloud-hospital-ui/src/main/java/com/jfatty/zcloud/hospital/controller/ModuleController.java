package com.jfatty.zcloud.hospital.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.Module;
import com.jfatty.zcloud.hospital.feign.ModuleFeignClient;
import com.jfatty.zcloud.hospital.req.ModuleReq;
import com.jfatty.zcloud.hospital.res.ModuleRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述 系统模块
 *
 * @author jfatty on 2020/4/17
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping("/module")
public class ModuleController implements IBaseController<Module,ModuleReq,ModuleRes> {

    @Autowired
    private ModuleFeignClient moduleFeignClient ;

    @Override
    public RELResultUtils<ModuleRes> table(Map<String, Object> params) {
        return moduleFeignClient.table(params);
    }

    @Override
    public RELResultUtils<ModuleRes> table(String v, Integer pageIndex, Integer pageSize) {
        return moduleFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return moduleFeignClient.list();
    }

    @Override
    public List<ModuleRes> list(Long v) {
        return moduleFeignClient.list(v);
    }

    @Override
    public Object save(ModuleReq entity) {
        return moduleFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return moduleFeignClient.view(id);
    }

    @Override
    public Object edit(ModuleReq entity) {
        return moduleFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return moduleFeignClient.delete(params);
    }
}
