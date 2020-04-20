package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.Module;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jfatty
 * @since 2020-04-11
 */
public interface ModuleService extends BaseHospitalService<Module> {

    List<Module> getModulesById(String appId, String version, String moduleId, String specification);
}
