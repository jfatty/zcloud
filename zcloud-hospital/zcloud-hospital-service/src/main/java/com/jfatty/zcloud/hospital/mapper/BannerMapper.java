package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.Banner;
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
public interface BannerMapper extends IBaseMapper<Banner> {

    List<Banner> getDiffBanners( @Param("appId") String appId,@Param("version") String version,@Param("specification") String specification);

}
