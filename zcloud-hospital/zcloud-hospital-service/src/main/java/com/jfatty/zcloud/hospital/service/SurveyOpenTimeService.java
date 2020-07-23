package com.jfatty.zcloud.hospital.service;


import com.jfatty.zcloud.hospital.entity.SurveyOpenTime;

/**
 * <p>
 * 量表开放时间管理表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2020-06-03
 */
public interface SurveyOpenTimeService extends BaseHospitalService<SurveyOpenTime> {

    SurveyOpenTime selectOpenTime(String surveyId, String currentTime);
}
