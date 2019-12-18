package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.Department;
import com.jfatty.zcloud.system.feign.DepartmentFeignClient;
import com.jfatty.zcloud.system.req.DepartmentReq;
import com.jfatty.zcloud.system.res.DepartmentRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping(value={"/department"})
public class DepartmentController implements IBaseController<Department,DepartmentReq,DepartmentRes> {

    @Autowired
    private DepartmentFeignClient departmentFeignClient ;

    @Override
    public RELResultUtils<DepartmentRes> table(Map<String, Object> params) {
        return departmentFeignClient.table(params);
    }

    @Override
    public RELResultUtils<DepartmentRes> table(String v, Integer pageIndex, Integer pageSize) {
        return departmentFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return departmentFeignClient.list();
    }

    @Override
    public List<DepartmentRes> list(Long v) {
        return departmentFeignClient.list(v);
    }

    @Override
    public Object save(DepartmentReq entity) {
        return departmentFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return departmentFeignClient.view(id);
    }

    @Override
    public Object edit(DepartmentReq entity) {
        return departmentFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return departmentFeignClient.delete(params);
    }
}
