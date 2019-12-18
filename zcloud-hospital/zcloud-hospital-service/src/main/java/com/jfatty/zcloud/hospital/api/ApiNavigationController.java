package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.Navigation;
import com.jfatty.zcloud.hospital.interfaces.INavigation;
import com.jfatty.zcloud.hospital.req.NavigationReq;
import com.jfatty.zcloud.hospital.res.NavigationRes;
import com.jfatty.zcloud.hospital.service.NavigationService;
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
 *  前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Api(tags = "底部导航API" ,value = "底部导航")
@Slf4j
@RestController
@RequestMapping("/api/navigation")
public class ApiNavigationController extends ApiBaseHospitalController<Navigation,NavigationReq,NavigationRes>  implements INavigation {

    private NavigationService navigationService ;

    @Autowired
    public void setNavigationService(NavigationService navigationService) {
        super.setBaseService(navigationService);
        this.navigationService = navigationService;
    }

    @ApiOperation(value="根据范围获取底部导航栏列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "version", value = "版本号",dataType = "String",defaultValue = "1.0.0"),
            @ApiImplicitParam(name = "scope", value = "范围 ALL PART",dataType = "String",defaultValue = "ALL")
    })
    @RequestMapping(value={"/index"},method=RequestMethod.GET)
    public RELResultUtils<NavigationRes> index(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId  ,
                                               @RequestParam(value = "version" , defaultValue = "1.0.0") String version ,
                                               @RequestParam(value = "scope" , defaultValue = "ALL" ) String scope ){
        List<Navigation> navigations = navigationService.getDiffNavigations(appId,version,null,scope);
        if(CollectionUtils.isEmpty(navigations))
            return RELResultUtils.success("未查询到对应导航栏") ;
        List<NavigationRes> navigationReses = new ArrayList<NavigationRes>();
        navigations.forEach(
                navigation -> {
                    NavigationRes navigationRes = new NavigationRes();
                    BeanUtils.copyProperties(navigation,navigationRes);
                    navigationReses.add(navigationRes);
                }
        );
        return new RELResultUtils(navigationReses);
    }

    @ApiOperation(value="根据定位获取底部导航栏列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "version", value = "版本号",dataType = "String",defaultValue = "1.0.0"),
            @ApiImplicitParam(name = "position", value = "定位 left middle right",dataType = "String",defaultValue = "middle")
    })
    @RequestMapping(value={"/indexPos"},method=RequestMethod.GET)
    public RELResultUtils<NavigationRes> indexPos(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId  ,
                                         @RequestParam(value = "version" , defaultValue = "1.0.0") String version ,
                                         @RequestParam(value = "position" , defaultValue = "middle" ) String position ){
        List<Navigation> navigations = navigationService.getDiffNavigations(appId,version,position,null);
        if(CollectionUtils.isEmpty(navigations))
            return RELResultUtils.success("未查询到对应导航栏") ;
        List<NavigationRes> navigationReses = new ArrayList<NavigationRes>();
        navigations.forEach(
                navigation -> {
                    NavigationRes navigationRes = new NavigationRes();
                    BeanUtils.copyProperties(navigation,navigationRes);
                    navigationReses.add(navigationRes);
                }
        );
        return new RELResultUtils(navigationReses);
    }

}

