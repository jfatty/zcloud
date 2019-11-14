package com.jfatty.zcloud.system.service;

import com.jfatty.zcloud.base.utils.PrivilegeMenu;
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

}
