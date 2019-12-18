package com.jfatty.zcloud.system.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.PermRelationship;
import com.jfatty.zcloud.system.req.PermRelationshipReq;
import com.jfatty.zcloud.system.res.PermRelationshipRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/4
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-system-service" , path = "/api/perm")
public interface PermRelationshipClient extends BInterface<PermRelationship,PermRelationshipReq,PermRelationshipRes> {


    @RequestMapping(value={"/auth"},method=RequestMethod.GET)
    ResultUtils auth(@RequestParam(value = "authId" , defaultValue = "52f1f164bd094b3eb0f58521dca85a1") String authId);


    @RequestMapping(value={"/auth"},method=RequestMethod.POST)
    ResultUtils authPrivilege(@RequestBody Map<String,Object> params);
}
