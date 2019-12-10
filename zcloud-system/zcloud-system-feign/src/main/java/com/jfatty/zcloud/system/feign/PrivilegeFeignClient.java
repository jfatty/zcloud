package com.jfatty.zcloud.system.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.utils.PrivilegeMenu;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Org;
import com.jfatty.zcloud.system.entity.Privilege;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


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


    @RequestMapping(value={"/table/list"},method = RequestMethod.POST)
    RELResultUtils<Privilege> table(@RequestBody Map<String,Object> params) ;


    @RequestMapping(value={"/table/list"},method = RequestMethod.GET )
    RELResultUtils<Privilege> table(@RequestParam(value = "v" , defaultValue = "20191101") String v ,
                            @RequestParam(value = "pageIndex" , defaultValue = "1" ) Integer pageIndex ,
                            @RequestParam(value = "pageSize" , defaultValue = "10") Integer pageSize) ;

    @RequestMapping(value={"/list"},method=RequestMethod.GET)
    ResultUtils  list() ;

    @RequestMapping(value={"/list"},method=RequestMethod.POST)
    List<Privilege> list(@RequestParam(value = "v" , defaultValue = "20191101") Long v);

    @RequestMapping(value={"/save"},method=RequestMethod.POST)
    ResultUtils save(@RequestBody Privilege entity) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.GET)
    ResultUtils view(@RequestParam(value = "id" , defaultValue = "AQAQAQ") String id ) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.POST)
    ResultUtils edit(@RequestBody Privilege entity) ;

    @RequestMapping(value={"/delete"},method=RequestMethod.POST)
    ResultUtils delete(@RequestBody Map<String,Object> params) ;

    @RequestMapping(value={"/role"},method=RequestMethod.GET)
    ResultUtils getRoleList(@RequestParam(value = "privilegeId" , defaultValue = "AQAQAQ") String privilegeId);

    @RequestMapping(value={"/copy"},method=RequestMethod.POST)
    ResultUtils copy(@RequestBody Privilege privilege);
}
