package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.Org;
import com.jfatty.zcloud.system.feign.OrgFeignClient;
import com.jfatty.zcloud.system.req.OrgReq;
import com.jfatty.zcloud.system.res.OrgRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/org"})
public class OrgController implements IBaseController<Org,OrgReq,OrgRes> {

    @Autowired
    private OrgFeignClient orgFeignClient ;


    @Override
    public RELResultUtils<OrgRes> table(Map<String, Object> params) {
        return orgFeignClient.table(params);
    }

    @Override
    public RELResultUtils<OrgRes> table(String v, Integer pageIndex, Integer pageSize) {
        return orgFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return orgFeignClient.list();
    }

    @Override
    public List<OrgRes> list(Long v) {
        return orgFeignClient.list(v);
    }

    @Override
    public Object save(OrgReq entity) {
        return orgFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return orgFeignClient.view(id);
    }

    @Override
    public Object edit(OrgReq entity) {
        return orgFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return orgFeignClient.delete(params);
    }
}
