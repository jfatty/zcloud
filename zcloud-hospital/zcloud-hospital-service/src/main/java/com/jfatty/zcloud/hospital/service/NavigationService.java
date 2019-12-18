package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.Navigation;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
public interface NavigationService extends BaseHospitalService<Navigation> {


    List<Navigation> getDiffNavigations(String appId, String version, String position, String scope);
}
