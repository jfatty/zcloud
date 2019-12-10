package com.jfatty.zcloud.system.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.PermRelationship;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/4
 * @email jfatty@163.com
 */
public interface PermRelationshipMapper extends IBaseMapper<PermRelationship> {


    /**
     * 描述  对角色 授权
     * @author jfatty
     * 创建时间：2018年5月16日
     */
    void auth(Map<String, Object> map);

    /**
     * 描述 删除原有的权限
     * @author jfatty
     * 创建时间：2018年5月16日
     */
    void deleteOldPrivilege(String objId);

    /**
     * 描述 拿到权限列表
     * @author jfatty
     * 创建时间：2018年5月16日
     * @param map
     */
    List<SystemTree> getPrivilegeTreeList(Map<String,Object> map);
}
