package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.system.entity.PageConfig;
import com.jfatty.zcloud.system.interfaces.IPageConfig;
import com.jfatty.zcloud.system.req.PageConfigReq;
import com.jfatty.zcloud.system.res.PageConfigRes;
import com.jfatty.zcloud.system.service.PageConfigService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 界面开发配置 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Api(tags = "界面开发配置API" ,value = "界面开发配置")
@Slf4j
@RestController
@RequestMapping(value={"/api/pageConfig"})
public class ApiPageConfigController  extends ApiBaseSystemController<PageConfig,PageConfigReq,PageConfigRes>  implements IPageConfig {

    private PageConfigService pageConfigService ;


    @Autowired
    public void setPageConfigService(PageConfigService pageConfigService) {
        super.setBaseService(pageConfigService);
        this.pageConfigService = pageConfigService;
    }
}

