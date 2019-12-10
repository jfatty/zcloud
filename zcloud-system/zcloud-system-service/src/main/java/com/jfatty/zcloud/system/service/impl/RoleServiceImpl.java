package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Role;
import com.jfatty.zcloud.system.mapper.RoleMapper;
import com.jfatty.zcloud.system.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class RoleServiceImpl extends BaseSystemServiceImpl<Role,RoleMapper> implements RoleService {


    private RoleMapper roleMapper ;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        super.setBaseMapper(roleMapper);
        this.roleMapper = roleMapper;
    }

    @Override
    public List<SystemTree> getRoleList(AccountUnique user, String userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        //supermanager
        Boolean sm = user.getUserName().equals("root");
        map.put("sm", sm ? 1 : 0);
        map.put("currentUserId", user.getId());
        map.put("userId", null);
        map.put("randomString", (int) (Math.random() * 10000));
        List<SystemTree> all = roleMapper.getRoleList(map);
        map = new HashMap<String, Object>();
        //
        map.put("sm", sm ? 1 : 0);
        map.put("currentUserId", user.getId());
        map.put("userId", userId);
        map.put("randomString", (int) (Math.random() * 10000));
        List<SystemTree> selectedList = roleMapper.getRoleList(map);
        for (SystemTree a : all) {
            for (SystemTree selected : selectedList) {
                if (selected.getValue().equals(a.getValue())) {
                    a.setChecked(true);
                }
            }
        }
        return all;
    }
}
