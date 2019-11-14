package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.Department;
import com.jfatty.zcloud.system.mapper.DepartmentMapper;
import com.jfatty.zcloud.system.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class DepartmentServiceImpl extends BaseSystemServiceImpl<Department,DepartmentMapper> implements DepartmentService {

    private DepartmentMapper departmentMapper ;

    @Autowired
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        super.setBaseMapper(departmentMapper);
        this.departmentMapper = departmentMapper;
    }
}
