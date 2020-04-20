package com.jfatty.zcloud.hospital.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.hospital.entity.ModuleRelationship;
import com.jfatty.zcloud.hospital.req.ModuleRelationshipReq;
import com.jfatty.zcloud.hospital.res.ModuleRelationshipRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2020/4/17
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-hospital-service" , path = "/api/moduleRelationship" )
public interface ModuleRelationshipFeignClient extends BInterface<ModuleRelationship,ModuleRelationshipReq,ModuleRelationshipRes> {

    @RequestMapping(value={"/bindMenus"},method=RequestMethod.GET)
    ResultUtils bindMenus(@RequestParam(value = "moduleId" , defaultValue = "52f1f164bd094b3eb0f58521dca85a1") String moduleId);


    @RequestMapping(value={"/bindMenus"},method=RequestMethod.POST)
    ResultUtils bind2Menus(@RequestBody Map<String,Object> params);

}
