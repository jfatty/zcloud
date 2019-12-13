package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.hospital.entity.Navigation;
import com.jfatty.zcloud.hospital.interfaces.INavigation;
import com.jfatty.zcloud.hospital.service.MenuService;
import com.jfatty.zcloud.hospital.service.NavigationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Slf4j
@RestController
@RequestMapping("/api/navigation")
public class ApiNavigationController extends ApiBaseHospitalController<Navigation>  implements INavigation {

    private NavigationService navigationService ;

    @Autowired
    public void setNavigationService(NavigationService navigationService) {
        super.setBaseService(navigationService);
        this.navigationService = navigationService;
    }
}

