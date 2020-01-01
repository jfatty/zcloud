package com.jfatty.zcloud.system.service;

import com.jfatty.zcloud.system.entity.PageImage;

/**
 * <p>
 * 界面图片开发配置 服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-31
 */
public interface PageImageService extends BaseSystemService<PageImage> {


    PageImage getByAppId( String appId, String pageId);

}
