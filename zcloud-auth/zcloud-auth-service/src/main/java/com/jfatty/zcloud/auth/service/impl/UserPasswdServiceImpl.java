package com.jfatty.zcloud.auth.service.impl;

import com.jfatty.zcloud.auth.entity.UserPasswd;
import com.jfatty.zcloud.auth.mapper.UserPasswdMapper;
import com.jfatty.zcloud.auth.service.UserPasswdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    @Override
    public UserPasswd getUserByPhone(String phone) {
        return userPasswdMapper.getUserByPhone(phone);
    }

    @Override
    public boolean saveUser(UserPasswd userPasswd) {
        int res = userPasswdMapper.saveUser(userPasswd);
        return res > 0;
    }

    @Override
    public Set<String> getRoles(String uid, Boolean sm) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", sm ? null : uid);
        return userPasswdMapper.getRoles(map);
    }

    @Override
    public Set<String> getPermissions(String uid, Boolean sm) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", sm ? null : uid);
        return userPasswdMapper.getPermissions(map);
    }

    @Override
    public Set<String> getUris(String uid, Boolean sm) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", sm ? null : uid);
        return userPasswdMapper.getUris(map);
    }
}
