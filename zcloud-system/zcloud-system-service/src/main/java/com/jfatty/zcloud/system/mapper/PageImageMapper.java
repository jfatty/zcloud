package com.jfatty.zcloud.system.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.system.entity.PageImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 界面图片开发配置 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-12-31
 */
public interface PageImageMapper extends IBaseMapper<PageImage> {


    List<PageImage> getByAppId(@Param("appId") String appId, @Param("pageId")  String pageId);

}
