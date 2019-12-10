package com.jfatty.zcloud.system.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Org;
import com.jfatty.zcloud.system.entity.PermRelationship;
import com.jfatty.zcloud.system.feign.PermRelationshipClient;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping(value={"/perm"})
public class PermRelationshipController implements IBaseController<PermRelationship> {

    @Autowired
    private PermRelationshipClient permRelationshipClient ;

    @Override
    public RELResultUtils<PermRelationship> table(Map<String, Object> params) {
        return permRelationshipClient.table(params);
    }

    @Override
    public RELResultUtils<PermRelationship> table(String v, Integer pageIndex, Integer pageSize) {
        return permRelationshipClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return permRelationshipClient.list();
    }

    @Override
    public List<PermRelationship> list(Long v) {
        return permRelationshipClient.list(v);
    }

    @Override
    public Object save(PermRelationship entity) {
        return permRelationshipClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return permRelationshipClient.view(id);
    }

    @Override
    public Object edit(PermRelationship entity) {
        return permRelationshipClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return permRelationshipClient.delete(params);
    }

    @RequestMapping(value={"/auth"},method=RequestMethod.GET)
    public Object auth(HttpServletRequest request, HttpSession session, String  authId) throws Exception {
        return permRelationshipClient.auth(authId) ;
    }

    @RequestMapping(value={"/auth"},method=RequestMethod.POST)
    public Object authPrivilege(HttpServletRequest request,HttpSession session,@RequestBody Map<String,Object> params) throws Exception {
        return permRelationshipClient.authPrivilege(params) ;
    }

}
