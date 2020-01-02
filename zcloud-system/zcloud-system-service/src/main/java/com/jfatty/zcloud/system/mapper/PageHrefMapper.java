package com.jfatty.zcloud.system.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.system.entity.PageHref;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 界面链接跳转开发配置 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-01-01
 */
public interface PageHrefMapper extends IBaseMapper<PageHref> {

    List<PageHref> getPageHrefsByIds(@Param("appId") String appId,@Param("pageId")  String pageId);

}
