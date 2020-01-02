package com.jfatty.zcloud.system.service;

import com.jfatty.zcloud.system.entity.PageElement;

import java.util.List;

/**
 * <p>
 * 界面标签元素开发配置 服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
public interface PageElementService extends BaseSystemService<PageElement> {

    List<PageElement> getElementsByPageId(String pageId);

    List<PageElement> getElementsByPageId(String appId,String pageId);
}
