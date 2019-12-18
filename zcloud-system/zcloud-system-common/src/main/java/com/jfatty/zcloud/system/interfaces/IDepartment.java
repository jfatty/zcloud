package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.Department;
import com.jfatty.zcloud.system.req.DepartmentReq;
import com.jfatty.zcloud.system.res.DepartmentRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@RequestMapping(value={"/department"})
public interface IDepartment extends BInterface<Department,DepartmentReq,DepartmentRes> {

}
