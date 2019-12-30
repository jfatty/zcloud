package com.jfatty.zcloud.system.api;

import com.jfatty.zcloud.system.entity.Org;
import com.jfatty.zcloud.system.interfaces.IOrg;
import com.jfatty.zcloud.system.req.OrgReq;
import com.jfatty.zcloud.system.res.OrgRes;
import com.jfatty.zcloud.system.service.OrgService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述 系统组织机构
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Api(tags = "系统组织机构API" ,value = "系统组织机构")
@Slf4j
@RestController
@RequestMapping(value={"/api/org"})
public class ApiOrgController extends ApiBaseSystemController<Org,OrgReq,OrgRes>  implements IOrg {

    private OrgService orgService ;

    @Autowired
    public void setOrgService(OrgService orgService) {
        super.setBaseService(orgService);
        this.orgService = orgService;
    }
}
