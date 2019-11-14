package com.jfatty.zcloud.system.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.utils.PrivilegeMenu;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Privilege;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * 描述
 *
 * @author jfatty on 2019/11/12
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-system-service" , path = "/api/privilege")
public interface PrivilegeFeignClient extends BInterface<Privilege> {

    /**
     * 获取权限列表菜单
     * @param user
     * @return
     */
    @RequestMapping(value={"/getMenu"},method=RequestMethod.POST)
    List<PrivilegeMenu> getPrivilegeMenu(@RequestBody AccountUnique user);

}
