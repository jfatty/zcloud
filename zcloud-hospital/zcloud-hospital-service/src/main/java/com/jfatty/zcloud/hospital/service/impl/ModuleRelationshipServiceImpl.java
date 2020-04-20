package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.hospital.entity.ModuleRelationship;
import com.jfatty.zcloud.hospital.mapper.ModuleRelationshipMapper;
import com.jfatty.zcloud.hospital.service.ModuleRelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2020-04-17
 */
@Slf4j
@Service
public class ModuleRelationshipServiceImpl extends BaseHospitalServiceImpl<ModuleRelationship , ModuleRelationshipMapper> implements ModuleRelationshipService {

    private ModuleRelationshipMapper moduleRelationshipMapper ;

    @Autowired
    public void setModuleRelationshipMapper(ModuleRelationshipMapper moduleRelationshipMapper) {
        super.setBaseMapper(moduleRelationshipMapper);
        this.moduleRelationshipMapper = moduleRelationshipMapper;
    }

    @Override
    public List<SystemTree> getBindMenus(String moduleId) {
        List<SystemTree> allMenuIds =  moduleRelationshipMapper.getAllMenus(moduleId);
        List<SystemTree> bindMenus = moduleRelationshipMapper.getBindMenus(moduleId);
        for ( SystemTree allMenuId : allMenuIds ) {
            Boolean checked = false;
            for ( SystemTree bindMenuId : bindMenus ) {
                if (allMenuId.getValue().equals(bindMenuId.getValue()))
                    checked = true ;
            }
            allMenuId.setChecked(checked);
        }
        return allMenuIds;
    }

    @Override
    public boolean bindMenus(String moduleId, List<String> menuIds) {
        if(CollectionUtils.isEmpty(menuIds)){
            moduleRelationshipMapper.deleteOldRels(moduleId);
            return true ;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("moduleId", moduleId);
        map.put("index", menuIds);
        moduleRelationshipMapper.deleteOldRels(moduleId);
        moduleRelationshipMapper.bindMenus(map);
        return true;
    }
}
