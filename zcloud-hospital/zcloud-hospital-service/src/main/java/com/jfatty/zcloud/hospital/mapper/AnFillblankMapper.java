package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.AnFillblank;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  填空题答案 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
public interface AnFillblankMapper extends IBaseMapper<AnFillblank> {

    AnFillblank getOptionsFormsWithAnswer(@Param("surveyId") String surveyId, @Param("answerId") String answerId, @Param("quId") String quId);
}
