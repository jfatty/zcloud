package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.SurveyAnswer;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 评估量表或者调查问卷 回答 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
public interface SurveyAnswerMapper extends IBaseMapper<SurveyAnswer> {

    SurveyAnswer getMidSurveyAnswer(@Param("surveyId") String surveyId,@Param("operator")  String operator,
                                    @Param("startTime") String startTime,@Param("endTime")  String endTime);


    SurveyAnswer getMoreSurveyAnswer(@Param("surveyId") String surveyId,@Param("operator")  String operator, @Param("endTime")  String endTime);


}
