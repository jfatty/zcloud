package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.UserGroup;
import com.jfatty.zcloud.system.feign.UserGroupFeignClient;
import com.jfatty.zcloud.system.req.UserGroupReq;
import com.jfatty.zcloud.system.res.UserGroupRes;
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
@RequestMapping(value={"/userGroup"})
public class UserGroupController implements IBaseController<UserGroup,UserGroupReq,UserGroupRes> {

    @Autowired
    private UserGroupFeignClient userGroupFeignClient ;

    @Override
    public RELResultUtils<UserGroupRes> table(Map<String, Object> params) {
        return userGroupFeignClient.table(params);
    }

    @Override
    public RELResultUtils<UserGroupRes> table(String v, Integer pageIndex, Integer pageSize) {
        return userGroupFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return userGroupFeignClient.list();
    }

    @Override
    public List<UserGroupRes> list(Long v) {
        return userGroupFeignClient.list(v);
    }

    @Override
    public Object save(UserGroupReq entity) {
        return userGroupFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return userGroupFeignClient.view(id);
    }

    @Override
    public Object edit(UserGroupReq entity) {
        System.out.println("UserGroupController.edit====>" + entity);
        return userGroupFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return userGroupFeignClient.delete(params);
    }

    @RequestMapping(value={"/user"},method=RequestMethod.GET)
    public Object userGroups(HttpServletRequest request, HttpSession session, String userId) {
        return userGroupFeignClient.userGroups(userId);

    }
}
