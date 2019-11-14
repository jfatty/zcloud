package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.User;
import com.jfatty.zcloud.system.mapper.UserMapper;
import com.jfatty.zcloud.system.service.UserService;
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
public class UserServiceImpl extends BaseSystemServiceImpl<User,UserMapper> implements UserService {

    private  UserMapper userMapper ;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        super.setBaseMapper(userMapper);
        this.userMapper = userMapper;
    }

    @Override
    public User getUserInfoById(String id) {
        return userMapper.getUserInfoById(id);
    }
}
