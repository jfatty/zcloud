package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.system.entity.PageHref;
import com.jfatty.zcloud.system.interfaces.IPageHref;
import com.jfatty.zcloud.system.req.PageHrefReq;
import com.jfatty.zcloud.system.res.PageHrefRes;
import com.jfatty.zcloud.system.service.PageHrefService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 界面链接跳转开发配置 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2020-01-01
 */
@Api(tags = "界面链接跳转开发配置API" ,value = "界面链接跳转开发配置")
@Slf4j
@RestController
@RequestMapping(value={"/api/pageHref"})
public class ApiPageHrefController  extends ApiBaseSystemController<PageHref,PageHrefReq,PageHrefRes>  implements IPageHref {

    private PageHrefService pageHrefService ;

    @Autowired
    public void setPageHrefService(PageHrefService pageHrefService) {
        super.setBaseService(pageHrefService);
        this.pageHrefService = pageHrefService;
    }

}

