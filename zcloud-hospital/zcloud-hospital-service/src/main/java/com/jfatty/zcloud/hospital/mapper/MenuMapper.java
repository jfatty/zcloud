package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 智慧医疗首页菜单表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
public interface MenuMapper extends IBaseMapper<Menu> {


    List<Menu> getDiffMenus(@Param("version") String version,@Param("position")  String position,@Param("navId")  String navId,@Param("specification") String specification,@Param("kw") String kw);

    List<Menu> getMenusByModuleId(@Param("appId") String appId,@Param("version")  String version, @Param("moduleId")  String moduleId, @Param("specification")  String specification);
}
