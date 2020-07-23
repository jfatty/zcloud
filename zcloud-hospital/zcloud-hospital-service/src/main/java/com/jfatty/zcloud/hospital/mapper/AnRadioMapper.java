package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.AnRadio;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  单选答案 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
public interface AnRadioMapper extends IBaseMapper<AnRadio> {

    String getOptionsFormsWithAnswer(@Param("surveyId") String surveyId, //
                                     @Param("answerId") String answerId, //
                                     @Param("quId") String quId,
                                     @Param("quItemId") String quItemId);

}
