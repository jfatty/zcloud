package com.jfatty.zcloud.system.service;



import com.jfatty.zcloud.base.service.BaseService;
import com.jfatty.zcloud.system.entity.AccountUnique;

import java.util.Set;

/**
 * <p>
 * 系统账号信息表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-03-25
 */
public interface AccountUniqueService extends BaseService<AccountUnique> {


    /**
     * @param user 当前在线用户
     * @param sm   supermanager 超级管理员
     * @return 返回角色名称集合
     * @description: 获取角色名称列表
     * @author jfatty
     * @date 2018年7月12日
     * @version 1.0.0
     */
    Set<String> getRoles(AccountUnique user, Boolean sm);

    /**
     * @param user 当前在线用户
     * @param sm   supermanager 超级管理员
     * @return 返回权限路径集合
     * @description:获取当前用户对应权限路径集合
     * @author jfatty
     * @date 2018年7月12日
     * @version 1.0.0
     */
    Set<String> getPermissions(AccountUnique user, Boolean sm);

}
