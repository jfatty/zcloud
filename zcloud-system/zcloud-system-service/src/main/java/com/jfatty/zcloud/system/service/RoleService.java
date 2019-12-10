package com.jfatty.zcloud.system.service;


import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Role;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
public interface RoleService extends BaseSystemService<Role> {


    /**
     * 描述 获取已经绑定角色 树形列表
     *
     * @author jfatty
     * 创建时间：2018年6月14日
     */
    List<SystemTree> getRoleList(AccountUnique user, String userId);

}
