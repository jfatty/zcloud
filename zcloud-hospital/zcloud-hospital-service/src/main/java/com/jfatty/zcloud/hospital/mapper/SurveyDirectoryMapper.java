package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.SurveyDirectory;
import com.jfatty.zcloud.hospital.vo.SurveyForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评估量表或者调查问卷 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
public interface SurveyDirectoryMapper extends IBaseMapper<SurveyDirectory> {

    SurveyForm getSurveyForm(@Param("surveyId") String surveyId);

    SurveyForm getSurveyFormWithAnswer(@Param("surveyId") String surveyId, @Param("answerId") String answerId);

    List<SurveyForm> getSurveyForms(@Param("menuId") String menuId, @Param("currentTime") String currentTime);

    List<SurveyForm> getSurFormsByTypes(List<String> list);
}
