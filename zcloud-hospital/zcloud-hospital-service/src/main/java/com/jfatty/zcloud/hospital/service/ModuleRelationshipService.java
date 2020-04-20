package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.hospital.entity.ModuleRelationship;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jfatty
 * @since 2020-04-17
 */
public interface ModuleRelationshipService extends BaseHospitalService<ModuleRelationship> {

    List<SystemTree> getBindMenus(String moduleId);

    boolean bindMenus(String moduleId, List<String> menuIds);
}
