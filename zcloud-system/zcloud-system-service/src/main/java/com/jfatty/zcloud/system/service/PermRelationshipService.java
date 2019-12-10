package com.jfatty.zcloud.system.service;

import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.PermRelationship;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/4
 * @email jfatty@163.com
 */
public interface PermRelationshipService  extends BaseSystemService<PermRelationship> {

    /**
     * 描述 获取当前角色对应的 授权列表
     *
     * @author jfatty
     * 创建时间：2018年5月16日
     */
    List<SystemTree> getAuthList(AccountUnique user, String authId) throws Exception;

    /**
     * 描述  对角色 用户 用户组 部门 信息系统 授权
     *
     * @author jfatty
     * 创建时间：2018年5月16日
     */
    boolean auth(String authId, List<String> privilegeIds) throws Exception;

}
