package com.jfatty.zcloud.system.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.system.entity.User;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
public interface UserMapper extends IBaseMapper<User> {

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    User  getUserInfoById(String id);

}
