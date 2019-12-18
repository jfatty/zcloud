package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Role;
import com.jfatty.zcloud.system.interfaces.IRole;
import com.jfatty.zcloud.system.req.RoleReq;
import com.jfatty.zcloud.system.res.RoleRes;
import com.jfatty.zcloud.system.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/role"})
public class ApiRoleController extends ApiBaseSystemController<Role,RoleReq,RoleRes>  implements IRole {


    private RoleService roleService ;

    @Autowired
    public void setRoleService(RoleService roleService) {
        super.setBaseService(roleService);
        this.roleService = roleService;
    }

//    @Override
//    public Object view(String id) {
//        Role role = new Role();
//        //role.setCreateTime(LocalDateTime.now());
//        role.setId(id);
//        role.setName("杨文杰");
//        //return "hi" + role + "======>" + LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
//        return role;
//    }

    @RequestMapping(value={"/user"},method=RequestMethod.GET)
    public Object roles(HttpServletRequest request, HttpSession session, String userId) {
        //获取当前用户
        AccountUnique user = new AccountUnique() ;//(AccountUnique)ShiroKit.getUser();
        user.setUserName("root");
        if(user != null){
            List<SystemTree> list = roleService.getRoleList(user,userId);
            return ResultUtils.success(list);
        }
        return ResultUtils.failure(401,"用户未登录或登录超时");

    }


}
