package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.system.entity.Role;
import com.jfatty.zcloud.system.interfaces.IRole;
import com.jfatty.zcloud.system.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/role"})
public class ApiRoleController extends ApiBaseSystemController<Role>  implements IRole {


    private RoleService roleService ;

    @Autowired
    public void setRoleService(RoleService roleService) {
        super.setBaseService(roleService);
        this.roleService = roleService;
    }

    @Override
    public Object view(String id) {
        Role role = new Role();
        //role.setCreateTime(LocalDateTime.now());
        role.setId(id);
        role.setName("杨文杰");
        //return "hi" + role + "======>" + LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return role;
    }


}
