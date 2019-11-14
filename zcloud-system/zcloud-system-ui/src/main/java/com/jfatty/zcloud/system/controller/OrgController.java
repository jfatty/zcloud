package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.Org;
import com.jfatty.zcloud.system.feign.OrgFeignClient;
import com.jfatty.zcloud.system.interfaces.IOrg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class OrgController implements IOrg {

    @Autowired
    private OrgFeignClient orgFeignClient ;


    @Override
    public RELResultUtils<Org> table(Map<String, Object> params) {
        return orgFeignClient.table(params);
    }

    @Override
    public RELResultUtils<Org> table(String v, Integer pageIndex, Integer pageSize) {
        return orgFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public List<Org> list() {
        return orgFeignClient.list();
    }

    @Override
    public Object save(Org entity) {
        return orgFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return orgFeignClient.view(id);
    }

    @Override
    public Object edit(Org entity) {
        return orgFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return orgFeignClient.delete(params);
    }
}
