package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.PrivilegeMenu;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Privilege;
import com.jfatty.zcloud.system.feign.PrivilegeFeignClient;
import com.jfatty.zcloud.system.req.PrivilegeReq;
import com.jfatty.zcloud.system.res.PrivilegeRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping(value={"/privilege"})
public class PrivilegeController implements IBaseController<Privilege,PrivilegeReq,PrivilegeRes>{

    @Autowired
    private PrivilegeFeignClient privilegeFeignClient ;

    @Override
    public RELResultUtils<PrivilegeRes> table(Map<String, Object> params) {
        return privilegeFeignClient.table(params);
    }

    @Override
    public RELResultUtils<PrivilegeRes> table(String v, Integer pageIndex, Integer pageSize) {
        log.error("v ==> " + v + "   ====>" + pageIndex + "   =====>" + pageSize);
        return privilegeFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return privilegeFeignClient.list();
    }

    @Override
    public List<PrivilegeRes> list(Long v) {
        return null;
    }

    @Override
    public Object save(PrivilegeReq entity) {
        return privilegeFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return privilegeFeignClient.view(id);
    }

    @Override
    public Object edit(PrivilegeReq entity) {
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

    @RequestMapping(value={"/copy"},method=RequestMethod.POST)
    public Object copy(HttpServletRequest request,HttpSession session,@RequestBody Privilege privilege) {
        return privilegeFeignClient.copy(privilege) ;
    }

    @GetMapping(value={"/role"})
    public Object roles(HttpServletRequest request,HttpSession session,String privilegeId) {
        return privilegeFeignClient.getRoleList(privilegeId);
    }


}
