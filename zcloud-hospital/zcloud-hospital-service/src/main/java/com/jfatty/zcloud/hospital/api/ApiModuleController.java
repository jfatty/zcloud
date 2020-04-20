package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.Menu;
import com.jfatty.zcloud.hospital.entity.Module;
import com.jfatty.zcloud.hospital.interfaces.IModule;
import com.jfatty.zcloud.hospital.req.ModuleReq;
import com.jfatty.zcloud.hospital.res.MenuRes;
import com.jfatty.zcloud.hospital.res.ModuleRes;
import com.jfatty.zcloud.hospital.res.ModuleTreeRes;
import com.jfatty.zcloud.hospital.service.MenuService;
import com.jfatty.zcloud.hospital.service.ModuleService;
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
 * @since 2020-04-11
 */
@Api(tags = "系统模块API" ,value = "系统模块")
@Slf4j
@RestController
@RequestMapping("/api/module")
public class ApiModuleController extends ApiBaseHospitalController<Module,ModuleReq,ModuleRes>  implements IModule {

    private ModuleService moduleService ;

    @Autowired
    private MenuService menuService ;

    @Autowired
    public void setModuleService(ModuleService moduleService) {
        super.setBaseService(moduleService);
        this.moduleService = moduleService;
    }


    @ApiOperation(value="获取对应模块下的菜单集合")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "version", value = "版本号",dataType = "String",defaultValue = "1.0.0"),
            @ApiImplicitParam(name = "moduleId", value = "模块ID",dataType = "String",defaultValue = "in6a60d2685379dex"),
            @ApiImplicitParam(name = "specification", value = "规格,格式  PC MOBILE PAD APP",dataType = "String",defaultValue = "MOBILE")
    })
    @RequestMapping(value={"/getModuleMenus"},method=RequestMethod.GET)
    public RELResultUtils<ModuleTreeRes> getModuleMenus(@RequestParam(value = "appId" , required = true, defaultValue = "wxe3336a60d2685379" ) String appId  ,
                                               @RequestParam(value = "version" ,required = true, defaultValue = "1.0.0") String version ,
                                               @RequestParam(value = "moduleId" ,required = true, defaultValue = "index" ) String moduleId ,
                                               @RequestParam(value = "specification" ,required = true, defaultValue = "MOBILE" ) String specification ){
        List<Module> modules = moduleService.getModulesById(appId,version,moduleId,specification);
        if(CollectionUtils.isEmpty(modules))
            return RELResultUtils.success("未查询到对应模块下菜单集合");
        List<ModuleTreeRes> moduleTrees = new ArrayList<ModuleTreeRes>();
        for (Module module : modules ) {
            ModuleTreeRes moduleTree = new ModuleTreeRes();
            BeanUtils.copyProperties(module,moduleTree);
            List<Menu> menus = menuService.getMenusByModuleId( appId,version, module.getId() ,specification  );
            if( !CollectionUtils.isEmpty(menus) ){
                List<MenuRes> menuReses = new ArrayList<MenuRes>();
                for ( Menu menu : menus ) {
                    MenuRes menuRes = new MenuRes();
                    BeanUtils.copyProperties(menu,menuRes);
                    menuReses.add(menuRes);
                }
                moduleTree.setMenus(new ArrayList<MenuRes>(menuReses));
                moduleTrees.add(moduleTree);
            }
        }
        if(CollectionUtils.isEmpty(moduleTrees))
            return RELResultUtils.success("未查询到对应模块下菜单集合");
        return new RELResultUtils(moduleTrees);
    }

}

