package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.UserGroup;
import com.jfatty.zcloud.system.interfaces.IUserGroup;
import com.jfatty.zcloud.system.service.UserGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value={"/api/userGroup"})
public class ApiUserGroupController extends ApiBaseSystemController<UserGroup>  implements IUserGroup {


    private UserGroupService userGroupService ;

    @Autowired
    public void setUserGroupService(UserGroupService userGroupService) {
        super.setBaseService(userGroupService);
        this.userGroupService = userGroupService;
    }


    @RequestMapping(value={"/user"},method=RequestMethod.GET)
    public ResultUtils userGroups(HttpServletRequest request, HttpSession session, String userId) {
        //获取当前用户
        AccountUnique user =  new AccountUnique() ;//(AccountUnique)ShiroKit.getUser();
        user.setUserName("root");
        if(user !=null){
            List<SystemTree> list = userGroupService.getUserGroupList(user,userId);
            return ResultUtils.success(list);
        }
        return ResultUtils.failure(401,"用户未登录或登录超时");

    }

}
