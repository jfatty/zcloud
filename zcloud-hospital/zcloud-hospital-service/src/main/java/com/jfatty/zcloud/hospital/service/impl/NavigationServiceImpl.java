package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.Navigation;
import com.jfatty.zcloud.hospital.mapper.NavigationMapper;
import com.jfatty.zcloud.hospital.service.NavigationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Slf4j
@Service
public class NavigationServiceImpl extends BaseHospitalServiceImpl<Navigation, NavigationMapper> implements NavigationService {

    private NavigationMapper navigationMapper ;

    @Autowired
    public void setNavigationMapper(NavigationMapper navigationMapper) {
        super.setBaseMapper(navigationMapper);
        this.navigationMapper = navigationMapper;
    }

    @Override
    public List<Navigation> getDiffNavigations(String appId, String version, String position, String scope) {
        return navigationMapper.getDiffNavigations(version,position,scope);
    }
}
