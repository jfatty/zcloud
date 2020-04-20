package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.Module;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-11
 */
public interface ModuleMapper extends IBaseMapper<Module> {

    List<Module> getModulesById(@Param("appId") String appId,@Param("version")  String version,@Param("moduleId") String moduleId,@Param("specification")  String specification);
}
