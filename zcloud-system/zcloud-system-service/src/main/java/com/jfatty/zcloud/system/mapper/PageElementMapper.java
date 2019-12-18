package com.jfatty.zcloud.system.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.system.entity.PageElement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 界面标签元素开发配置 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
public interface PageElementMapper extends IBaseMapper<PageElement> {

    List<PageElement> getElementsByPageId(@Param("pageId") String pageId);
}
