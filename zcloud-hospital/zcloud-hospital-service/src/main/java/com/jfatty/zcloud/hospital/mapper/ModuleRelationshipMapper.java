package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.hospital.entity.ModuleRelationship;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-17
 */
public interface ModuleRelationshipMapper extends IBaseMapper<ModuleRelationship> {

    List<SystemTree> getBindMenus(@Param("moduleId") String moduleId);

    List<SystemTree> getAllMenus(@Param("moduleId") String moduleId);

    void deleteOldRels(@Param("moduleId") String moduleId);

    void bindMenus(Map<String,Object> map);
}
