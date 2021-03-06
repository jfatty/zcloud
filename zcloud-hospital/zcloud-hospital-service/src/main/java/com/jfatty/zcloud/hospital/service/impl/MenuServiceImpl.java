package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.Menu;
import com.jfatty.zcloud.hospital.mapper.MenuMapper;
import com.jfatty.zcloud.hospital.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 智慧医疗首页菜单表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Slf4j
@Service
public class MenuServiceImpl extends BaseHospitalServiceImpl<Menu, MenuMapper> implements MenuService {

    private MenuMapper menuMapper ;

    @Autowired
    public void setMenuMapper(MenuMapper menuMapper) {
        super.setBaseMapper(menuMapper);
        this.menuMapper = menuMapper;
    }

    @Override
    public List<Menu> getDiffMenus(String appId, String version, String position, String navId,String specification,String kw) {
        return menuMapper.getDiffMenus(version,position,navId,specification,kw) ;
    }

    @Override
    public List<Menu> getMenusByModuleId(String appId, String version, String moduleId, String specification) {
        return menuMapper.getMenusByModuleId(appId,version,moduleId,specification);
    }
}
