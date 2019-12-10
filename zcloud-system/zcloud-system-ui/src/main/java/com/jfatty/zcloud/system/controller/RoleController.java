package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Role;
import com.jfatty.zcloud.system.feign.RoleFeignClient;
import com.jfatty.zcloud.system.interfaces.IRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@RequestMapping(value={"/role"})
public class RoleController implements IBaseController<Role> {


    @Autowired
    private RoleFeignClient roleFeignClient ;

    @Override
    public RELResultUtils<Role> table(Map<String, Object> params) {
        return roleFeignClient.table(params);
    }

    @Override
    public Object list() {
        System.out.println("===========================>  list " );
        return roleFeignClient.list() ;
    }

    @Override
    public List<Role> list(Long v) {
        return roleFeignClient.list(v);
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
        System.out.println(" view ====> " + id );
        return roleFeignClient.view(id) ;
    }

    @Override
    public Object edit(Role entity) {
        return roleFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return roleFeignClient.delete(params);
    }

    @RequestMapping(value={"/user"},method = RequestMethod.GET)
    public Object roles(HttpServletRequest request, HttpSession session,String userId) {
        System.out.println(" ==========>  " + userId);
        return roleFeignClient.roles(userId);
    }

}
