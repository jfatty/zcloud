package com.jfatty.zcloud.system.api;

import com.jfatty.zcloud.system.entity.Department;
import com.jfatty.zcloud.system.interfaces.IDepartment;
import com.jfatty.zcloud.system.req.DepartmentReq;
import com.jfatty.zcloud.system.res.DepartmentRes;
import com.jfatty.zcloud.system.service.DepartmentService;
import io.swagger.annotations.Api;
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
@Api(tags = "系统部门API" ,value = "系统部门")
@Slf4j
@RestController
@RequestMapping(value={"/api/department"})
public class ApiDepartmentController extends ApiBaseSystemController<Department,DepartmentReq,DepartmentRes>  implements IDepartment {

    private DepartmentService departmentService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        super.setBaseService(departmentService);
        this.departmentService = departmentService;
    }
}
