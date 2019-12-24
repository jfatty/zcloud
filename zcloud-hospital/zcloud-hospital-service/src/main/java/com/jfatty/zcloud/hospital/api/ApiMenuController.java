package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.Menu;
import com.jfatty.zcloud.hospital.interfaces.IMenu;
import com.jfatty.zcloud.hospital.req.MenuReq;
import com.jfatty.zcloud.hospital.res.MenuRes;
import com.jfatty.zcloud.hospital.service.MenuService;
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
 * 智慧医疗首页菜单表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Api(tags = "慧医疗首页菜单API" ,value = "慧医疗首页菜单")
@Slf4j
@RestController
@RequestMapping("/api/menu")
public class ApiMenuController extends ApiBaseHospitalController<Menu,MenuReq,MenuRes>  implements IMenu {

    private MenuService menuService ;

    @Autowired
    public void setMenuService(MenuService menuService) {
        super.setBaseService(menuService);
        this.menuService = menuService;
    }


    @ApiOperation(value="001****菜单首页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "version", value = "版本号",dataType = "String",defaultValue = "1.0.0"),
            @ApiImplicitParam(name = "position", value = "定位",dataType = "String",defaultValue = "index")
    })
    @RequestMapping(value={"/index"},method=RequestMethod.GET)
    public RELResultUtils<MenuRes> index(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId  ,
                             @RequestParam(value = "version" , defaultValue = "1.0.0") String version ,
                             @RequestParam(value = "position" , defaultValue = "index" ) String position ){
        List<Menu> menus = menuService.getDiffMenus(appId,version,position,null);
        if(CollectionUtils.isEmpty(menus))
            return RELResultUtils.success("未查询到对应菜单") ;
        List<MenuRes> menuReses = new ArrayList<MenuRes>();
        menus.forEach(
                menu -> {
                    MenuRes menuRes = new MenuRes();
                    BeanUtils.copyProperties(menu,menuRes);
                    menuReses.add(menuRes);
                }
        );
        return new RELResultUtils(menuReses);
    }


    @ApiOperation(value="002****根据底部导航ID获取对应菜单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "version", value = "版本号",dataType = "String",defaultValue = "1.0.0"),
            @ApiImplicitParam(name = "navId", value = "底部导航ID",dataType = "String",defaultValue = "402881906F12FFF9016F12FFF9D50000")
    })
    @RequestMapping(value={"/indexNav"},method=RequestMethod.GET)
    public RELResultUtils<MenuRes> indexNav(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId  ,
                                     @RequestParam(value = "version" , defaultValue = "1.0.0") String version ,
                                     @RequestParam(value = "navId" , defaultValue = "402881906F12FFF9016F12FFF9D50000" ) String navId ){
        List<Menu> menus = menuService.getDiffMenus(appId,version,null,navId);
        if(CollectionUtils.isEmpty(menus))
            return RELResultUtils.success("未查询到对应菜单") ;
        List<MenuRes> menuReses = new ArrayList<MenuRes>();
        menus.forEach(
                menu -> {
                    MenuRes menuRes = new MenuRes();
                    BeanUtils.copyProperties(menu,menuRes);
                    menuReses.add(menuRes);
                }
        );
        return new RELResultUtils(menuReses);
    }


    @ApiOperation(value="003****V4.0.0版本菜单首页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "version", value = "版本号",dataType = "String",defaultValue = "4.0.0"),
            @ApiImplicitParam(name = "position", value = "定位",dataType = "String",defaultValue = "top_one",allowableValues ="top_one,top_two,middle,bottom" )
    })
    @RequestMapping(value={"/indexFour"},method=RequestMethod.GET)
    public RELResultUtils<MenuRes> indexFour(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId  ,
                                             @RequestParam(value = "version" , defaultValue = "4.0.0") String version ,
                                             @RequestParam(value = "position" , defaultValue = "top_one" ) String position  ){
        List<Menu> menus = menuService.getDiffMenus(appId,version,position,null);
        if(CollectionUtils.isEmpty(menus))
            return RELResultUtils.success("未查询到对应菜单") ;
        List<MenuRes> menuReses = new ArrayList<MenuRes>();
        menus.forEach(
                menu -> {
                    MenuRes menuRes = new MenuRes();
                    BeanUtils.copyProperties(menu,menuRes);
                    menuReses.add(menuRes);
                }
        );
        return new RELResultUtils(menuReses);
    }


}

