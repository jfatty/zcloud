package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.hospital.entity.Menu;
import com.jfatty.zcloud.hospital.interfaces.IMenu;
import com.jfatty.zcloud.hospital.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 智慧医疗首页菜单表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Slf4j
@RestController
@RequestMapping("/api/menu")
public class ApiMenuController extends ApiBaseHospitalController<Menu>  implements IMenu {

    private MenuService menuService ;

    @Autowired
    public void setMenuService(MenuService menuService) {
        super.setBaseService(menuService);
        this.menuService = menuService;
    }
}

