package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.base.utils.PrivilegeMenu;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Privilege;
import com.jfatty.zcloud.system.interfaces.IPrivilege;
import com.jfatty.zcloud.system.service.PrivilegeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping(value={"/api/privilege"})
public class ApiPrivilegeController extends ApiBaseSystemController<Privilege>  implements IPrivilege {

    private PrivilegeService privilegeService;

    @Autowired
    public void setPrivilegeService(PrivilegeService privilegeService) {
        super.setBaseService(privilegeService);
        this.privilegeService = privilegeService;
    }


    @Override
    public RELResultUtils<Privilege> table(String v, Integer pageIndex, Integer pageSize) {
        log.error("v ==> " + v + "   ====>" + pageIndex + "   =====>" + pageSize);
        return super.table(v, pageIndex, pageSize);
    }

    @RequestMapping(value={"/getMenu"},method=RequestMethod.POST)
    public List<PrivilegeMenu> getMenu(HttpServletRequest request, HttpSession session , @RequestBody AccountUnique user) {
        List<PrivilegeMenu> list = privilegeService.getPrivilegeMenu(user);
        return list ;
    }

}
