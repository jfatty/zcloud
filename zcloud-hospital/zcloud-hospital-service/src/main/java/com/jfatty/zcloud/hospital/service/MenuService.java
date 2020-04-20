package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.Menu;

import java.util.List;

/**
 * <p>
 * 智慧医疗首页菜单表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
public interface MenuService extends BaseHospitalService<Menu> {

    List<Menu> getDiffMenus(String appId, String version, String position, String navId,String specification,String kw);

    List<Menu> getMenusByModuleId(String appId, String version, String moduleId, String specification);
}
