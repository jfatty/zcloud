package com.jfatty.zcloud.system.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 描述
 *
 * @author jfatty on 2019/11/12
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-system-service" , path = "/api/user")
public interface UserFeignClient extends BInterface<User> {


    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    @RequestMapping(value={"/getUserInfo"},method=RequestMethod.GET)
    User  getUserInfoById(@RequestParam(value = "id" , defaultValue = "AQAQAQ")String id) ;

}
