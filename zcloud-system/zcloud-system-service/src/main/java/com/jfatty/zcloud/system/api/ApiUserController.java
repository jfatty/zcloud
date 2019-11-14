package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.system.entity.User;
import com.jfatty.zcloud.system.interfaces.IUser;
import com.jfatty.zcloud.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/user"})
public class ApiUserController extends ApiBaseSystemController<User>  implements IUser {


    private UserService userService ;

    @Autowired
    public void setUserService(UserService userService) {
        super.setBaseService(userService);
        this.userService = userService;
    }


    @RequestMapping(value={"/getUserInfo"},method=RequestMethod.GET)
    public User getUserInfo(String id) throws Exception {
        User user = userService.getUserInfoById(id);
        log.error("===================>"+user);
        return user  ;
    }

}
