package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.utils.PrivilegeMenu;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Privilege;
import com.jfatty.zcloud.system.feign.PrivilegeFeignClient;
import com.jfatty.zcloud.system.interfaces.IPrivilege;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class PrivilegeController implements IPrivilege {

    @Autowired
    private PrivilegeFeignClient privilegeFeignClient ;

    @Override
    public RELResultUtils<Privilege> table(Map<String, Object> params) {
        return privilegeFeignClient.table(params);
    }

    @Override
    public RELResultUtils<Privilege> table(String v, Integer pageIndex, Integer pageSize) {
        log.error("v ==> " + v + "   ====>" + pageIndex + "   =====>" + pageSize);
        return privilegeFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public List<Privilege> list() {
        return privilegeFeignClient.list();
    }

    @Override
    public Object save(Privilege entity) {
        return privilegeFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return privilegeFeignClient.view(id);
    }

    @Override
    public Object edit(Privilege entity) {
        return privilegeFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return privilegeFeignClient.delete(params);
    }

    @RequestMapping(value={"/getMenu"},method=RequestMethod.GET)
    public Object getMenu(HttpServletRequest request, HttpSession session) {
        //获取当前用户
        AccountUnique user = new AccountUnique() ;
        user.setId("4028819069B8658C0169B8658C700000");
        List<PrivilegeMenu> list = privilegeFeignClient.getPrivilegeMenu(user);
        return list ;
    }
}
