package com.jfatty.zcloud.system.controller;


import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.Address;
import com.jfatty.zcloud.system.feign.AddressFeignClient;
import com.jfatty.zcloud.system.req.AddressReq;
import com.jfatty.zcloud.system.res.AddressRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 公用地址表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Slf4j
@RestController
@RequestMapping(value={"/address"})
public class AddressController implements IBaseController<Address,AddressReq,AddressRes> {

    @Autowired
    private AddressFeignClient addressFeignClient ;

    @Override
    public RELResultUtils<AddressRes> table(Map<String, Object> params) {
        return addressFeignClient.table(params);
    }

    @Override
    public RELResultUtils<AddressRes> table(String v, Integer pageIndex, Integer pageSize) {
        return addressFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return addressFeignClient.list();
    }

    @Override
    public List<AddressRes> list(Long v) {
        return addressFeignClient.list(v);
    }

    @Override
    public Object save(AddressReq entity) {
        return addressFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return addressFeignClient.view(id);
    }

    @Override
    public Object edit(AddressReq entity) {
        return addressFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return addressFeignClient.delete(params);
    }
}

