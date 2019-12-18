package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.Navigation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
public interface NavigationMapper extends IBaseMapper<Navigation> {

    List<Navigation> getDiffNavigations(@Param("version") String version,@Param("position")  String position,@Param("scope")  String scope);
}
