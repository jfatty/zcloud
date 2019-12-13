package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.PageElement;
import com.jfatty.zcloud.system.mapper.PageElementMapper;
import com.jfatty.zcloud.system.service.PageElementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 界面标签元素开发配置 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Slf4j
@Service
public class PageElementServiceImpl extends BaseSystemServiceImpl<PageElement, PageElementMapper> implements PageElementService {

    private PageElementMapper pageElementMapper ;

    @Autowired
    public void setPageElementMapper(PageElementMapper pageElementMapper) {
        super.setBaseMapper(pageElementMapper);
        this.pageElementMapper = pageElementMapper;
    }
}
