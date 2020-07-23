package com.jfatty.zcloud.hospital.mapper;


import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.QuestionAnswer;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  问题答案 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
public interface QuestionAnswerMapper extends IBaseMapper<QuestionAnswer> {

    String getQuestionAnswer(@Param("surveyId") String surveyId,@Param("answerId")  String answerId, @Param("quId")  String quId);
}
