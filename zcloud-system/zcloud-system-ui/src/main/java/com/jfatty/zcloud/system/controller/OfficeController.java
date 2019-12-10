package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Office;
import com.jfatty.zcloud.system.feign.OfficeFeignClient;
import com.jfatty.zcloud.system.interfaces.IOffice;
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
@RequestMapping(value={"/office"})
public class OfficeController implements IBaseController<Office> {

    @Autowired
    private OfficeFeignClient officeFeignClient ;

    @Override
    public RELResultUtils<Office> table(Map<String, Object> params) {
        return officeFeignClient.table(params);
    }

    @Override
    public RELResultUtils<Office> table(String v, Integer pageIndex, Integer pageSize) {
        return officeFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return officeFeignClient.list();
    }

    @Override
    public List<Office> list(Long v) {
        return officeFeignClient.list(v);
    }

    @Override
    public Object save(Office entity) {
        return officeFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return officeFeignClient.view(id);
    }

    @Override
    public Object edit(Office entity) {
        return officeFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return officeFeignClient.delete(params);
    }
}
