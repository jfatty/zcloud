package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.AnCheckbox;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  多选题 答案Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
public interface AnCheckboxMapper extends IBaseMapper<AnCheckbox> {

    String getOptionsFormsWithAnswer(@Param("surveyId") String surveyId, //
                                     @Param("answerId") String answerId, //
                                     @Param("quId") String quId,
                                     @Param("quItemId") String quItemId);

}
