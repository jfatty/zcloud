package com.jfatty.zcloud.hospital.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.hospital.entity.ModuleRelationship;
import com.jfatty.zcloud.hospital.feign.ModuleRelationshipFeignClient;
import com.jfatty.zcloud.hospital.req.ModuleRelationshipReq;
import com.jfatty.zcloud.hospital.res.ModuleRelationshipRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 描述 系统模块与菜单对应关系
 *
 * @author jfatty on 2020/4/17
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping("/moduleRelationship")
public class ModuleRelationshipController implements IBaseController<ModuleRelationship,ModuleRelationshipReq,ModuleRelationshipRes> {

    @Autowired
    private ModuleRelationshipFeignClient moduleRelationshipFeignClient ;

    @RequestMapping(value={"/bindMenus"},method=RequestMethod.GET)
    public ResultUtils bindMenus(@RequestParam(value = "moduleId" , defaultValue = "52f1f164bd094b3eb0f58521dca85a1") String moduleId){
        return moduleRelationshipFeignClient.bindMenus(moduleId);
    }

    @RequestMapping(value={"/bindMenus"},method=RequestMethod.POST)
    public ResultUtils bind2Menus(@RequestBody Map<String,Object> params){
        return moduleRelationshipFeignClient.bind2Menus(params);
    }

    @Override
    public RELResultUtils<ModuleRelationshipRes> table(Map<String, Object> params) {
        return moduleRelationshipFeignClient.table(params);
    }

    @Override
    public RELResultUtils<ModuleRelationshipRes> table(String v, Integer pageIndex, Integer pageSize) {
        return moduleRelationshipFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return moduleRelationshipFeignClient.list();
    }

    @Override
    public List<ModuleRelationshipRes> list(Long v) {
        return moduleRelationshipFeignClient.list(v);
    }

    @Override
    public Object save(ModuleRelationshipReq entity) {
        return moduleRelationshipFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return moduleRelationshipFeignClient.view(id);
    }

    @Override
    public Object edit(ModuleRelationshipReq entity) {
        return moduleRelationshipFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return moduleRelationshipFeignClient.delete(params);
    }
}
