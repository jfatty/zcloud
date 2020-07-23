package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.AssObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 量表关联对象表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-06-03
 */
public interface AssObjectMapper extends IBaseMapper<AssObject> {

    List<AssObject> getAssObjects(@Param("surveyId") String surveyId);
}
