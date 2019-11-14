package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.UserGroup;
import com.jfatty.zcloud.system.mapper.UserGroupMapper;
import com.jfatty.zcloud.system.service.UserGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class UserGroupServiceImpl extends BaseSystemServiceImpl<UserGroup,UserGroupMapper> implements UserGroupService {

    private UserGroupMapper userGroupMapper ;

    @Autowired
    public void setUserGroupMapper(UserGroupMapper userGroupMapper) {
        super.setBaseMapper(userGroupMapper);
        this.userGroupMapper = userGroupMapper;
    }
}
