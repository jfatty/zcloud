package com.jfatty.zcloud.system.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.UserGroup;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
public interface UserGroupMapper extends IBaseMapper<UserGroup> {

    /**
     * @description:分配/编辑用户时 获取用户组列表
     * @author jfatty
     * @date 2018年7月21日
     * @version 1.0.0
     * @param map 封装参数 用户id
     * @return 返回树形集合
     */
    List<SystemTree> getUserGroupList(Map<String, Object> map);

}
