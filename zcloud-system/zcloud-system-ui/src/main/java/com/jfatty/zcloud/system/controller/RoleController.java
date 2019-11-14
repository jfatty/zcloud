package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.Role;
import com.jfatty.zcloud.system.feign.RoleFeignClient;
import com.jfatty.zcloud.system.interfaces.IRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/12
 * @email jfatty@163.com
 */
@Slf4j
@RestController
public class RoleController implements IRole {


    @Autowired
    private RoleFeignClient roleFeignClient ;

    @Override
    public RELResultUtils<Role> table(Map<String, Object> params) {
        return roleFeignClient.table(params);
    }

    @Override
    public List<Role> list() {
        System.out.println("===========================>  list " );
        return roleFeignClient.list() ;
    }

    @Override
    public RELResultUtils<Role> table(String v, Integer pageIndex, Integer pageSize) {
        return roleFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object save(Role entity) {
        return roleFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return roleFeignClient.view(id);
    }

    @Override
    public Object edit(Role entity) {
        return roleFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return roleFeignClient.delete(params);
    }
}
