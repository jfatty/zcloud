package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.PageConfig;
import com.jfatty.zcloud.system.mapper.PageConfigMapper;
import com.jfatty.zcloud.system.service.PageConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 界面开发配置 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Slf4j
@Service
public class PageConfigServiceImpl extends BaseSystemServiceImpl<PageConfig, PageConfigMapper> implements PageConfigService {

    private PageConfigMapper pageConfigMapper ;

    @Autowired
    public void setPageConfigMapper(PageConfigMapper pageConfigMapper) {
        super.setBaseMapper(pageConfigMapper);
        this.pageConfigMapper = pageConfigMapper;
    }
}
