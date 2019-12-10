package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.PermRelationship;
import com.jfatty.zcloud.system.mapper.PermRelationshipMapper;
import com.jfatty.zcloud.system.mapper.PrivilegeMapper;
import com.jfatty.zcloud.system.service.PermRelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/4
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class PermRelationshipServiceImpl extends BaseSystemServiceImpl<PermRelationship,PermRelationshipMapper> implements PermRelationshipService {


    private PermRelationshipMapper permRelationshipMapper ;

    @Autowired
    public void setPermRelationshipMapper(PermRelationshipMapper permRelationshipMapper) {
        super.setBaseMapper(permRelationshipMapper);
        this.permRelationshipMapper = permRelationshipMapper;
    }

    @Override
    public List<SystemTree> getAuthList(AccountUnique user, String authId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        //supermanager
        Boolean sm = user.getUserName().equals("root");
        //判断是或否为超级管理员
        map.put("sm", sm ? 1 : 0);
        //当前用户ID  如果当前用户不是超级管理员 那么就需要先获取 当前用户所拥有的所有顶级权限
        map.put("userId", user.getId());
        List<SystemTree> rootList = permRelationshipMapper.getPrivilegeTreeList(map);
        // authId 可能是用户ID 用户组ID  部门ID 角色ID
        map.put("authId", authId);
        //当前用有的权限
        List<SystemTree> hasList = permRelationshipMapper.getPrivilegeTreeList(map);
        for (SystemTree root : rootList) {
            root = getChildren(user,root, hasList);
        }
        return rootList;
    }

    @Override
    public boolean auth(String authId, List<String> privilegeIds) throws Exception {
        if(CollectionUtils.isEmpty(privilegeIds))
            return false ;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("authId", authId);
        map.put("index", privilegeIds);
        permRelationshipMapper.deleteOldPrivilege(authId);
        permRelationshipMapper.auth(map);
        return true;
    }


    //循环查询子权限
    private SystemTree getChildren(AccountUnique user,SystemTree privilegeTree, List<SystemTree> hasList) {
        if (hasList != null && hasList.size() > 0) {
            Boolean checked = false;
            for (SystemTree hasp : hasList) {
                if (hasp.getValue().equals(privilegeTree.getValue())) {
                    checked = true;
                }
            }
            privilegeTree.setChecked(checked);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        //supermanager
        Boolean sm = user.getUserName().equals("root");
        //判断是或否为超级管理员
        map.put("sm", sm ? 1 : 0);
        //当前用户ID  如果当前用户不是超级管理员 那么就需要先获取 当前用户所拥有的所有顶级权限
        map.put("userId", user.getId());
        //二级及以下菜单
        map.put("privilegeId", privilegeTree.getValue());
        List<SystemTree> childrenList = permRelationshipMapper.getPrivilegeTreeList(map);
        if (childrenList != null && childrenList.size() > 0) {
            for (SystemTree pt : childrenList) {
                pt = getChildren(user,pt, hasList);
            }
            privilegeTree.setData(childrenList);
        }
        return privilegeTree;
    }
}
