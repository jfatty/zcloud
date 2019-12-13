package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.system.entity.PageElement;
import com.jfatty.zcloud.system.interfaces.IPageElement;
import com.jfatty.zcloud.system.service.PageElementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 界面标签元素开发配置 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/pageElement"})
public class ApiPageElementController  extends ApiBaseSystemController<PageElement>  implements IPageElement {

    private PageElementService pageElementService ;

    @Autowired
    public void setPageElementService(PageElementService pageElementService) {
        super.setBaseService(pageElementService);
        this.pageElementService = pageElementService;
    }

}

