package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.base.utils.*;
import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Privilege;
import com.jfatty.zcloud.system.interfaces.IPrivilege;
import com.jfatty.zcloud.system.req.PrivilegeReq;
import com.jfatty.zcloud.system.res.PrivilegeRes;
import com.jfatty.zcloud.system.service.AccountUniqueService;
import com.jfatty.zcloud.system.service.PrivilegeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/privilege"})
public class ApiPrivilegeController extends ApiBaseSystemController<Privilege,PrivilegeReq,PrivilegeRes>  implements IPrivilege {

    private PrivilegeService privilegeService;

    @Autowired
    private AccountUniqueService accountUniqueService ;

    @Autowired
    public void setPrivilegeService(PrivilegeService privilegeService) {
        super.setBaseService(privilegeService);
        this.privilegeService = privilegeService;
    }

//    @Override
//    public RELResultUtils<Privilege> table(Map<String, Object> params) {
//        String key = "name" ;
//        String name = (String) params.get(key);
//        if(!StringUtils.isEmptyOrBlank(name)){
//            params.put(key,"%"+name+"%");
//        } else {
//            params.remove(key);
//        }
//        return super.table(params);
//    }

//    @Override
//    public RELResultUtils<Privilege> table(String v, Integer pageIndex, Integer pageSize) {
//        log.error("v ==> " + v + "   ====>" + pageIndex + "   =====>" + pageSize);
//        return super.table(v, pageIndex, pageSize);
//    }

    @RequestMapping(value={"/getMenu"},method=RequestMethod.POST)
    public List<PrivilegeMenu> getMenu(HttpServletRequest request, HttpSession session , @RequestBody AccountUnique user) {
        List<PrivilegeMenu> list = privilegeService.getPrivilegeMenu(user);
        return list ;
    }

    @RequestMapping(value={"/role"},method=RequestMethod.GET)
    public ResultUtils roles(HttpServletRequest request,HttpSession session,String  privilegeId) {
        List<SystemTree> list = privilegeService.getRoleList(privilegeId);
        return ResultUtils.success(list) ;
    }

    @RequestMapping(value={"/copy"},method=RequestMethod.POST)
    public ResultUtils copy(HttpServletRequest request,HttpSession session,@RequestBody Privilege privilege) {
        AccountUnique user = accountUniqueService.getById("4028819069B8658C0169B8658C700000");
        Privilege db_privilege = privilegeService.getById(privilege.getId());
        String title = privilege.getTitle() ;
        BeanUtils.copyProperties(db_privilege,privilege);
        privilege.setId(UUIDGenerator.uuid());
        privilege.setTitle(title);
        //privilege.setCreateOperator(user.getId());
        //privilege.setCreateTime(getSimpleTimeString());
        privilege.setUpdateOperator(user.getId());
        privilege.setUpdateTime(LocalDateTime.now());
        try {
            privilegeService.save(privilege,user);
            return ResultUtils.build(200, "SUCCESS") ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtils.build(500, "FAILED") ;
    }

}
