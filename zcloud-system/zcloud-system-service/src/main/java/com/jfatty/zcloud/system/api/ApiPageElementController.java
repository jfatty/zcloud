package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.PageElement;
import com.jfatty.zcloud.system.interfaces.IPageElement;
import com.jfatty.zcloud.system.req.PageElementReq;
import com.jfatty.zcloud.system.res.DictionarySimRes;
import com.jfatty.zcloud.system.res.PageElementMenuRes;
import com.jfatty.zcloud.system.res.PageElementRes;
import com.jfatty.zcloud.system.service.DictionaryService;
import com.jfatty.zcloud.system.service.PageElementService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 界面标签元素开发配置 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Api(tags = "界面标签元素开发配置API" ,value = "界面标签元素开发配置")
@Slf4j
@RestController
@RequestMapping(value={"/api/pageElement"})
public class ApiPageElementController  extends ApiBaseSystemController<PageElement,PageElementReq,PageElementRes>  implements IPageElement {

    private PageElementService pageElementService ;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    public void setPageElementService(PageElementService pageElementService) {
        super.setBaseService(pageElementService);
        this.pageElementService = pageElementService;
    }

    @ApiOperation(value="通过 页面标识ID 获取界面标签元素数组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageId", value = "页面标识ID",dataType = "String",required = true ,defaultValue = "402881906F150C8F016F150C8F7C0000")
    })
    @RequestMapping(value = {"/getPageElements"} ,method = RequestMethod.GET)
    public ResultUtils getPageElements(@RequestParam(value = "pageId" , required = true, defaultValue = "402881906F150C8F016F150C8F7C0000") String pageId){
        List<PageElement> elements = pageElementService.getElementsByPageId(pageId);
        if( CollectionUtils.isEmpty(elements) )
            return  ResultUtils.success(pageId + "尚未配置界面标签元素");
        Map<String,Object> map = new HashMap<String,Object>();
        for (PageElement elem : elements){
            PageElementMenuRes pageElementMenu = new PageElementMenuRes();
            BeanUtils.copyProperties(elem,pageElementMenu);
            List<DictionarySimRes> dicts = dictionaryService.getByDictionaryMenu(elem.getDictionaryMenu());
            pageElementMenu.setDicts(dicts);
            map.put(elem.getElemId(),pageElementMenu);
        }
        return ResultUtils.success(map);
    }

    @ApiOperation(value="通过 AppId 页面标识ID 获取界面标签元素数组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",required = true ,dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "pageId", value = "页面标识ID",dataType = "String",required = true ,defaultValue = "402881906F150C8F016F150C8F7C0000")
    })
    @RequestMapping(value = {"/getPageElementsByIds"} ,method = RequestMethod.GET)
    public ResultUtils getPageElementsByIds(@RequestParam(value = "appId" ,  required = true, defaultValue = "wxe3336a60d2685379" ) String appId  ,//
                                       @RequestParam(value = "pageId" , required = true, defaultValue = "402881906F150C8F016F150C8F7C0000") String pageId){
        List<PageElement> elements = pageElementService.getElementsByPageId(appId,pageId);
        if( CollectionUtils.isEmpty(elements) )
            return  ResultUtils.success(pageId + "尚未配置界面标签元素");
        Map<String,Object> map = new HashMap<String,Object>();
        for (PageElement elem : elements){
            PageElementMenuRes pageElementMenu = new PageElementMenuRes();
            BeanUtils.copyProperties(elem,pageElementMenu);
            List<DictionarySimRes> dicts = dictionaryService.getByDictionaryMenu(elem.getDictionaryMenu());
            pageElementMenu.setDicts(dicts);
            map.put(elem.getElemId(),pageElementMenu);
        }
        return ResultUtils.success(map);
    }


}

