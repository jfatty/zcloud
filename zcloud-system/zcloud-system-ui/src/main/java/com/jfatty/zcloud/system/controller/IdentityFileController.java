package com.jfatty.zcloud.system.controller;


import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.IdentityFile;
import com.jfatty.zcloud.system.feign.IdentityFileFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Slf4j
@RestController
@RequestMapping("/identityFile")
public class IdentityFileController implements IBaseController<IdentityFile> {

    @Autowired
    private IdentityFileFeignClient identityFileFeignClient;

    @Override
    public RELResultUtils<IdentityFile> table(Map<String, Object> params) {
        return identityFileFeignClient.table(params);
    }

    @Override
    public RELResultUtils<IdentityFile> table(String v, Integer pageIndex, Integer pageSize) {
        return identityFileFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return identityFileFeignClient.list();
    }

    @Override
    public List<IdentityFile> list(Long v) {
        return identityFileFeignClient.list(v);
    }

    @Override
    public Object save(IdentityFile entity) {
        return identityFileFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return identityFileFeignClient.view(id);
    }

    @Override
    public Object edit(IdentityFile entity) {
        return identityFileFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return identityFileFeignClient.delete(params);
    }

}

