package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.system.entity.PageHref;
import com.jfatty.zcloud.system.interfaces.IPageHref;
import com.jfatty.zcloud.system.req.PageHrefReq;
import com.jfatty.zcloud.system.res.PageHrefRes;
import com.jfatty.zcloud.system.service.PageHrefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @ApiOperation(value="通过 页面标识ID 获取界面链接跳转开发配置数组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",required = true ,dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "pageId", value = "页面标识ID",dataType = "String",required = true ,defaultValue = "2C9580916F63C65D016F63CC78410001")
    })
    @RequestMapping(value = {"/getPageHrefsByIds"} ,method = RequestMethod.GET)
    public RELResultUtils<PageHrefRes> getPageHrefsByIds(@RequestParam(value = "appId" , required = true ,defaultValue = "wxe3336a60d2685379" ) String appId  ,//
                                                          @RequestParam(value = "pageId" , required = true, defaultValue = "2C9580916F63C65D016F63CC78410001") String pageId){
        List<PageHref> herfs = pageHrefService.getPageHrefsByIds(appId,pageId);
        if( CollectionUtils.isEmpty(herfs) )
            return  RELResultUtils.success(pageId + "尚未配置界面链接");
        List<PageHrefRes> pageHrefReses = new ArrayList<PageHrefRes>();
        for (PageHref href : herfs){
            PageHrefRes pageHrefRes = new PageHrefRes();
            BeanUtils.copyProperties(href,pageHrefRes);
            pageHrefReses.add(pageHrefRes);
        }
        return new RELResultUtils(pageHrefReses);
    }


    @ApiOperation(value="通过 条件 获取界面链接跳转开发配置数组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "pageId", value = "页面标识ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "verifyName", value = "校验名称",dataType = "String",defaultValue = ""),
            @ApiImplicitParam(name = "verifyRule", value = "校验规则",dataType = "String",defaultValue = "")
    })
    @RequestMapping(value = {"/getPageHrefsOpts"} ,method = RequestMethod.GET)
    public RELResultUtils<PageHrefRes> getPageHrefsOpts(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId  ,//
                                                        @RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId  ,//
                                                        @RequestParam(value = "verifyName" , defaultValue = "" ) String verifyName  ,
                                                         @RequestParam(value = "verifyRule" ,  defaultValue = "") String verifyRule){
        if (StringUtils.isEmptyOrBlank(appId))
            appId = null ;
        if (StringUtils.isEmptyOrBlank(hospitalId))
            hospitalId = null ;
        if (StringUtils.isEmptyOrBlank(verifyName))
            verifyName = null ;
        if (StringUtils.isEmptyOrBlank(verifyRule))
            verifyRule = null ;
        List<PageHref> hrefs = pageHrefService.getPageHrefsOpts(appId,hospitalId,verifyName,verifyRule);
        if( CollectionUtils.isEmpty(hrefs) )
            return  RELResultUtils.success("尚未配置界面链接");
        List<PageHrefRes> pageHrefReses = new ArrayList<PageHrefRes>();
        for (PageHref href : hrefs){
            PageHrefRes pageHrefRes = new PageHrefRes();
            BeanUtils.copyProperties(href,pageHrefRes);
            pageHrefReses.add(pageHrefRes);
        }
        return new RELResultUtils(pageHrefReses);
    }


}

