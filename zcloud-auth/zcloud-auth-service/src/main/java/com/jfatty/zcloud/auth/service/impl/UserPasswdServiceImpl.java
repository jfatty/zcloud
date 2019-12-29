package com.jfatty.zcloud.auth.service.impl;

import com.jfatty.zcloud.auth.entity.UserPasswd;
import com.jfatty.zcloud.auth.mapper.UserPasswdMapper;
import com.jfatty.zcloud.auth.service.UserPasswdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述
 *
 * @author jfatty on 2019/12/8
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class UserPasswdServiceImpl extends BaseAuthServiceImpl<UserPasswd,UserPasswdMapper> implements UserPasswdService {

    private UserPasswdMapper userPasswdMapper ;

    @Autowired
    public void setUserPasswdMapper(UserPasswdMapper userPasswdMapper) {
       super.setBaseMapper(userPasswdMapper);
        this.userPasswdMapper = userPasswdMapper;
    }

    @Override
    public UserPasswd getUserPasswd(String account) {
        return userPasswdMapper.getUserPasswd(account);
    }
}
