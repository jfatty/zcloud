package com.jfatty.zcloud.system.service;

import com.jfatty.zcloud.base.utils.PrivilegeMenu;
import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Privilege;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
public interface PrivilegeService extends BaseSystemService<Privilege> {

    /**
     * 获取权限列表菜单
     * @param user
     * @return
     */
    List<PrivilegeMenu> getPrivilegeMenu(AccountUnique user);

    /**
     * @param privilegeId 角色Id
     * @return 返回属性列表
     * @description:编辑权限时 获取角色列表
     * @author jfatty
     * @date 2018年7月18日
     * @version 1.0.0
     */
    List<SystemTree> getRoleList(String privilegeId);

    /**
     *
     * @param entity 新增权限对象
     * @param user  当前登录用户
     * @return
     * @throws Exception
     */
    boolean save(Privilege entity, AccountUnique user) throws Exception ;
}
