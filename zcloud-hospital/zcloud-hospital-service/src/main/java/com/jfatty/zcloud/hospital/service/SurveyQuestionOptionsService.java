package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.SurveyAnswer;
import com.jfatty.zcloud.hospital.req.SurveyFormReq;
import com.jfatty.zcloud.hospital.res.SurveyFormRes;
import com.jfatty.zcloud.hospital.vo.SurveyForm;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/5/27
 * @email jfatty@163.com
 */
public interface SurveyQuestionOptionsService {


    SurveyFormRes getSurveyForm(String surveyId, String answerId, String operator);

    String edit(SurveyFormReq surveyFormReq) throws Exception;

    List<SurveyForm> getSurveyForms(String menuId);

    List<SurveyForm> getSurFormsByTypes(List<String> surveyTypes);

    SurveyAnswer getMidSurveyAnswer(String surveyId, String operator, String startTime, String endTime);

    SurveyAnswer getMoreSurveyAnswer(String surveyId, String operator, String endTime);
}
