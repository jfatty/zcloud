package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.system.entity.UserGroup;
import com.jfatty.zcloud.system.interfaces.IUserGroup;
import com.jfatty.zcloud.system.service.UserGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/userGroup"})
public class ApiUserGroupController extends ApiBaseSystemController<UserGroup>  implements IUserGroup {


    private UserGroupService userGroupService ;

    @Autowired
    public void setUserGroupService(UserGroupService userGroupService) {
        super.setBaseService(userGroupService);
        this.userGroupService = userGroupService;
    }

}
