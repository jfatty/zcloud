package com.jfatty.zcloud.system.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.system.entity.AreaCn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 中国行政地区表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-12-27
 */
public interface AreaCnMapper extends IBaseMapper<AreaCn> {

    List<AreaCn> getLevelList(@Param("parentId") String parentId,@Param("level")  Integer level,@Param("name")  String name,@Param("shortName")  String shortName,@Param("realm")  String realm);
}
