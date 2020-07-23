package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.hospital.entity.SurveyOpenTime;
import com.jfatty.zcloud.hospital.interfaces.ISurveyOpenTime;
import com.jfatty.zcloud.hospital.req.SurveyOpenTimeReq;
import com.jfatty.zcloud.hospital.res.SurveyOpenTimeRes;
import com.jfatty.zcloud.hospital.service.SurveyOpenTimeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 量表开放时间管理表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2020-06-03
 */
@Api(tags = "量表开放时间管理 API" ,value = "量表开放时间管理 ")
@RestController
@RequestMapping("/api/surveyOpenTime")
public class ApiSurveyOpenTimeController extends ApiBaseHospitalController<SurveyOpenTime,SurveyOpenTimeReq,SurveyOpenTimeRes> implements ISurveyOpenTime {

    private SurveyOpenTimeService surveyOpenTimeService ;

    @Autowired
    public void setSurveyOpenTimeService(SurveyOpenTimeService surveyOpenTimeService) {
        super.setBaseService(surveyOpenTimeService);
        this.surveyOpenTimeService = surveyOpenTimeService;
    }
}

