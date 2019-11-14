package com.jfatty.zcloud.system.service;

import com.jfatty.zcloud.system.entity.User;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
public interface UserService extends BaseSystemService<User> {

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    User  getUserInfoById(String id) ;

}
