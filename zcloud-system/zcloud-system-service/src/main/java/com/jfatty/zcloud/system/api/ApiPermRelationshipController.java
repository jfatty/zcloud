package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.PermRelationship;
import com.jfatty.zcloud.system.interfaces.IPermRelationship;
import com.jfatty.zcloud.system.service.AccountUniqueService;
import com.jfatty.zcloud.system.service.PermRelationshipService;
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
 * 描述
 *
 * @author jfatty on 2019/12/4
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/perm"})
public class ApiPermRelationshipController extends ApiBaseSystemController<PermRelationship>  implements IPermRelationship {

    @Autowired
    private PermRelationshipService permRelationshipService ;

    @Autowired
    private AccountUniqueService accountUniqueService ;

    @RequestMapping(value={"/auth"},method=RequestMethod.GET)
    public ResultUtils auth(HttpServletRequest request, HttpSession session, String  authId) throws Exception {
        //获取当前用户
        AccountUnique user = accountUniqueService.getById("4028819069B8658C0169B8658C700000");
        if(StringUtils.isNotEmpty(authId) && StringUtils.isNotBlank(authId)){
            List<SystemTree> list = permRelationshipService.getAuthList(user,authId);
            return ResultUtils.success(list);
        }
        return ResultUtils.failure(403,"授权对象ID为空!") ;
    }

    @RequestMapping(value={"/auth"},method=RequestMethod.POST)
    public ResultUtils authPrivilege(HttpServletRequest request,HttpSession session,@RequestBody Map<String,Object> params) throws Exception {
        //全选
        //52f1f164bd094b3eb0f58521dca85a19,0af815e6fecd4edba703aa59c99f0d40,f9f40978c1964025b01ce4dc90b1c878,60f686e22a734a74a8d0f96f2dc7ca95,858a5176581f4831ad34058a7ec7d15b,9633e9a71f3c46db806288cdec1518b6,6604c6866e0d4877849f7ad40745ef38,2228b318d869429c8c4094dd97acb509,7673fe44835b4ff28e2a26df5090ceb5,b42236be141f4d20b54b62df62723307
        String authId = (String) params.get("authId");
        List<String> privilegeIds = (List<String>) params.get("privilegeIds");
        if(permRelationshipService.auth(authId,privilegeIds)) {
            return ResultUtils.ok();
        }
        return ResultUtils.build(400, "本项操作失败");
    }

}
