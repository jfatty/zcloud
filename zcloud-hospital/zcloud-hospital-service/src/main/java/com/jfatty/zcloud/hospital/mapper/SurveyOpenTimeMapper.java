package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.SurveyOpenTime;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 量表开放时间管理表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-06-03
 */
public interface SurveyOpenTimeMapper extends IBaseMapper<SurveyOpenTime> {

    SurveyOpenTime selectOpenTime(@Param("surveyId") String surveyId,@Param("currentTime")  String currentTime);
}
