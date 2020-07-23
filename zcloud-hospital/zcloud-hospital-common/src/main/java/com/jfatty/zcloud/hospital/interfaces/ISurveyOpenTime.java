package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.SurveyOpenTime;
import com.jfatty.zcloud.hospital.req.SurveyOpenTimeReq;
import com.jfatty.zcloud.hospital.res.SurveyOpenTimeRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 量表开放时间管理
 *
 * @author jfatty on 2020/6/10
 * @email jfatty@163.com
 */
@RequestMapping(value={"/surveyOpenTime"})
public interface ISurveyOpenTime extends BInterface<SurveyOpenTime,SurveyOpenTimeReq,SurveyOpenTimeRes> {

}
