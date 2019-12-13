package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.Menu;
import com.jfatty.zcloud.hospital.mapper.MenuMapper;
import com.jfatty.zcloud.hospital.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
