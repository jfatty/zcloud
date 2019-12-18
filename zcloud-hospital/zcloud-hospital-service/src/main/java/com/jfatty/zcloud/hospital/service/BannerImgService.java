package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.BannerImg;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
public interface BannerImgService extends BaseHospitalService<BannerImg> {


    List<BannerImg> getDiffBannerImgs(String appId, String version, String position, String module);
}
