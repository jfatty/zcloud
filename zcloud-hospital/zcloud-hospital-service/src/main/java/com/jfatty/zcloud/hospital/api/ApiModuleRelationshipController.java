package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.hospital.entity.ModuleRelationship;
import com.jfatty.zcloud.hospital.interfaces.IModuleRelationship;
import com.jfatty.zcloud.hospital.req.ModuleRelationshipReq;
import com.jfatty.zcloud.hospital.res.ModuleRelationshipRes;
import com.jfatty.zcloud.hospital.service.ModuleRelationshipService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2020-04-17
 */
@Api(tags = "系统模块与菜单对应关系API" ,value = "系统模块与菜单对应关系")
@Slf4j
@RestController
@RequestMapping("/api/moduleRelationship")
public class ApiModuleRelationshipController extends ApiBaseHospitalController<ModuleRelationship,ModuleRelationshipReq,ModuleRelationshipRes>  implements IModuleRelationship {

    private ModuleRelationshipService moduleRelationshipService ;

    @Autowired
    public void setModuleRelationshipService(ModuleRelationshipService moduleRelationshipService) {
        super.setBaseService(moduleRelationshipService);
        this.moduleRelationshipService = moduleRelationshipService;
    }


    @RequestMapping(value={"/bindMenus"},method=RequestMethod.GET)
    public ResultUtils bindMenus(HttpServletRequest request, HttpSession session, String  moduleId) throws Exception {
        if(StringUtils.isNotEmpty(moduleId) && StringUtils.isNotBlank(moduleId)){
            List<SystemTree> list = moduleRelationshipService.getBindMenus(moduleId);
            return ResultUtils.success(list);
        }
        return ResultUtils.failure(403,"授权模块ID为空!") ;
    }

    @RequestMapping(value={"/bindMenus"},method=RequestMethod.POST)
    public ResultUtils bind2Menus(HttpServletRequest request,HttpSession session,@RequestBody Map<String,Object> params) throws Exception {
        //全选
        //52f1f164bd094b3eb0f58521dca85a19,0af815e6fecd4edba703aa59c99f0d40,f9f40978c1964025b01ce4dc90b1c878,60f686e22a734a74a8d0f96f2dc7ca95,858a5176581f4831ad34058a7ec7d15b,9633e9a71f3c46db806288cdec1518b6,6604c6866e0d4877849f7ad40745ef38,2228b318d869429c8c4094dd97acb509,7673fe44835b4ff28e2a26df5090ceb5,b42236be141f4d20b54b62df62723307
        String moduleId = (String) params.get("moduleId");
        List<String> menuIds = (List<String>) params.get("menuIds");
        if(moduleRelationshipService.bindMenus(moduleId,menuIds)) {
            return ResultUtils.ok();
        }
        return ResultUtils.build(400, "本项操作失败");
    }

}

