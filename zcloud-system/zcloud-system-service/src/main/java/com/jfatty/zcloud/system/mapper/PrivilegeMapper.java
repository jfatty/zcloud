package com.jfatty.zcloud.system.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.Privilege;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
public interface PrivilegeMapper  extends IBaseMapper<Privilege> {

    /**
     * 描述 获取当前用户权限集合
     * @author jfatty
     * 创建时间：2018年6月19日
     */
    List<Privilege> getPrivilegeMenu(Map<String, Object> map);

    /**
     * 描述 获取已经绑定的角色列表
     * @author jfatty
     * 创建时间：2018年6月14日
     */
    List<SystemTree> getRoleList(Map<String, Object> map);
}
