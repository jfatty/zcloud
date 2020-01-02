package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.PageImage;
import com.jfatty.zcloud.system.mapper.PageImageMapper;
import com.jfatty.zcloud.system.service.PageImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 界面图片开发配置 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-31
 */
@Slf4j
@Service
public class PageImageServiceImpl extends BaseSystemServiceImpl<PageImage,PageImageMapper> implements PageImageService {


    private PageImageMapper pageImageMapper ;

    @Autowired
    public void setPageImageMapper(PageImageMapper pageImageMapper) {
        super.setBaseMapper(pageImageMapper);
        this.pageImageMapper = pageImageMapper;
    }


    @Override
    public List<PageImage> getByAppId(String appId, String pageId) {
        return pageImageMapper.getByAppId(appId,pageId);
    }
}
