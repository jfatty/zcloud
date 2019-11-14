package com.jfatty.zcloud.system.api;

import com.jfatty.zcloud.system.entity.Department;
import com.jfatty.zcloud.system.interfaces.IDepartment;
import com.jfatty.zcloud.system.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/department"})
public class ApiDepartmentController extends ApiBaseSystemController<Department>  implements IDepartment {

    private DepartmentService departmentService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        super.setBaseService(departmentService);
        this.departmentService = departmentService;
    }
}
