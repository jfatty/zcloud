package com.jfatty.zcloud.system.service;


import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.UserGroup;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
public interface UserGroupService extends BaseSystemService<UserGroup> {

    /**
     * @return 返回树型列表
     * @description:分配/编辑用户时 获取用户组列表
     * @author jfatty
     * @date 2018年7月18日
     * @version 1.0.0
     */
    List<SystemTree> getUserGroupList(AccountUnique user, String userId) ;

}
