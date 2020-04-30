package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.TreatGuide;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 就诊指南 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-28
 */
public interface TreatGuideMapper extends IBaseMapper<TreatGuide> {

    List<TreatGuide> getTreatGuides(@Param("appId") String appId, @Param("version")  String version, @Param("specification")  String specification);
}
