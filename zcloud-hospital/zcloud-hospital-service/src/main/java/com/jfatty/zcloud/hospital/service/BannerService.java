package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.Banner;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jfatty
 * @since 2020-04-11
 */
public interface BannerService extends BaseHospitalService<Banner> {

    List<Banner> getDiffBanners(String appId, String version, String specification);
}
