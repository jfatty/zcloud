package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.TreatGuide;

import java.util.List;

/**
 * <p>
 * 就诊指南 服务类
 * </p>
 *
 * @author jfatty
 * @since 2020-04-28
 */
public interface TreatGuideService extends BaseHospitalService<TreatGuide> {

    List<TreatGuide> getTreatGuides(String appId, String version, String specification);
}
