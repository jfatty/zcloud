package com.jfatty.zcloud.system.service;

import com.jfatty.zcloud.system.entity.PageHref;

import java.util.List;

/**
 * <p>
 * 界面链接跳转开发配置 服务类
 * </p>
 *
 * @author jfatty
 * @since 2020-01-01
 */
public interface PageHrefService extends BaseSystemService<PageHref> {

    List<PageHref> getPageHrefsByIds(String appId, String pageId);

    List<PageHref> getPageHrefsOpts(String appId, String hospitalId, String verifyName, String verifyRule);
}
