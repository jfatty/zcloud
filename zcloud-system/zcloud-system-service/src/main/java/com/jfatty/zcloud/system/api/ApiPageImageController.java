package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.system.entity.PageImage;
import com.jfatty.zcloud.system.interfaces.IPageImage;
import com.jfatty.zcloud.system.req.PageImageReq;
import com.jfatty.zcloud.system.res.PageImageRes;
import com.jfatty.zcloud.system.service.PageImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 界面图片开发配置 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-31
 */
@Api(tags = "界面图片开发配置配置API" ,value = "界面图片开发配置")
@Slf4j
@RestController
@RequestMapping(value={"/api/pageImage"})
public class ApiPageImageController  extends ApiBaseSystemController<PageImage,PageImageReq,PageImageRes>  implements IPageImage {

    private PageImageService pageImageService ;

    @Autowired
    public void setPageImageService(PageImageService pageImageService) {
        super.setBaseService(pageImageService);
        this.pageImageService = pageImageService;
    }


    @ApiOperation(value="001****获取页面需使用的图片集合")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",required = true,defaultValue = "wx656a00824f784088"),
            @ApiImplicitParam(name = "pageId", value = "页面ID 每个应用的每个前端页面系统都会分配一个ID作为唯一标志",dataType = "String",required = true,defaultValue = "2C9580916F5F3CD5016F5F3DA6DD0001")
    })
    @RequestMapping(value={"/getPageImage"},method=RequestMethod.GET)
    public RETResultUtils<PageImageRes> getPageImage(@RequestParam(value = "appId" , defaultValue = "wx656a00824f784088" ) String appId  ,
                                              @RequestParam(value = "pageId" , defaultValue = "2C9580916F5F3CD5016F5F3DA6DD0001") String pageId ){
        PageImage pageImage = pageImageService.getByAppId(appId,pageId);
        if(pageImage == null)
            return RETResultUtils._506("未查询到对应页面图片配置信息") ;
        PageImageRes pageImageRes = new PageImageRes();
        BeanUtils.copyProperties(pageImage,pageImageRes);
        return new RETResultUtils(pageImageRes);
    }


}

