package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.SurveyOpenTime;
import com.jfatty.zcloud.hospital.mapper.SurveyOpenTimeMapper;
import com.jfatty.zcloud.hospital.service.SurveyOpenTimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 量表开放时间管理表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2020-06-03
 */
@Slf4j
@Service
public class SurveyOpenTimeServiceImpl extends BaseHospitalServiceImpl<SurveyOpenTime, SurveyOpenTimeMapper> implements SurveyOpenTimeService {

    private SurveyOpenTimeMapper surveyOpenTimeMapper ;

    @Autowired
    public void setSurveyOpenTimeMapper(SurveyOpenTimeMapper surveyOpenTimeMapper) {
        super.setBaseMapper(surveyOpenTimeMapper);
        this.surveyOpenTimeMapper = surveyOpenTimeMapper;
    }

    @Override
    public SurveyOpenTime selectOpenTime(String surveyId, String currentTime) {
        return surveyOpenTimeMapper.selectOpenTime(surveyId,currentTime);
    }
}
