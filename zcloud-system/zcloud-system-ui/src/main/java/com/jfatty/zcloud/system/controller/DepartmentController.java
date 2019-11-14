package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.Department;
import com.jfatty.zcloud.system.feign.DepartmentFeignClient;
import com.jfatty.zcloud.system.interfaces.IDepartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@RestController
public class DepartmentController implements IDepartment {

    @Autowired
    private DepartmentFeignClient departmentFeignClient ;

    @Override
    public RELResultUtils<Department> table(Map<String, Object> params) {
        return departmentFeignClient.table(params);
    }

    @Override
    public RELResultUtils<Department> table(String v, Integer pageIndex, Integer pageSize) {
        return departmentFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public List<Department> list() {
        return departmentFeignClient.list();
    }

    @Override
    public Object save(Department entity) {
        return departmentFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return departmentFeignClient.view(id);
    }

    @Override
    public Object edit(Department entity) {
        return departmentFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return departmentFeignClient.delete(params);
    }
}
