package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.UserGroup;
import com.jfatty.zcloud.system.feign.UserGroupFeignClient;
import com.jfatty.zcloud.system.interfaces.IUserGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
public class UserGroupController implements IUserGroup {

    @Autowired
    private UserGroupFeignClient userGroupFeignClient ;

    @Override
    public RELResultUtils<UserGroup> table(Map<String, Object> params) {
        return userGroupFeignClient.table(params);
    }

    @Override
    public RELResultUtils<UserGroup> table(String v, Integer pageIndex, Integer pageSize) {
        return userGroupFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public List<UserGroup> list() {
        return userGroupFeignClient.list();
    }

    @Override
    public Object save(UserGroup entity) {
        return userGroupFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return userGroupFeignClient.view(id);
    }

    @Override
    public Object edit(UserGroup entity) {
        return userGroupFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return userGroupFeignClient.delete(params);
    }
}
