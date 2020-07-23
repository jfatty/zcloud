package com.jfatty.zcloud.hospital.mapper;


import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.Question;
import com.jfatty.zcloud.hospital.vo.QuestionForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  题目 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
public interface QuestionMapper extends IBaseMapper<Question> {

    List<QuestionForm> getQuestionForms(@Param("surveyId") String surveyId);

    List<QuestionForm> getAnswerQuestionForms(@Param("surveyId") String surveyId,@Param("answerId")  String answerId);
}
