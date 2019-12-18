package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.BannerImg;
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
public interface BannerImgMapper extends IBaseMapper<BannerImg> {


    List<BannerImg> getDiffBannerImgs(@Param("version") String version,@Param("position")  String position,@Param("module")  String module);

}
