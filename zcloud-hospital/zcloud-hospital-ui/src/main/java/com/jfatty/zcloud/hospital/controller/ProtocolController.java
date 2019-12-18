package com.jfatty.zcloud.hospital.controller;


import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.Protocol;
import com.jfatty.zcloud.hospital.feign.ProtocolFeignClient;
import com.jfatty.zcloud.hospital.req.ProtocolReq;
import com.jfatty.zcloud.hospital.res.ProtocolRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 协议或用户需知表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Slf4j
@RestController
@RequestMapping("/protocol")
public class ProtocolController implements IBaseController<Protocol,ProtocolReq,ProtocolRes> {

    @Autowired
    private ProtocolFeignClient protocolFeignClient ;

    @Override
    public RELResultUtils<ProtocolRes> table(Map<String, Object> params) {
        return protocolFeignClient.table(params);
    }

    @Override
    public RELResultUtils<ProtocolRes> table(String v, Integer pageIndex, Integer pageSize) {
        return protocolFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return protocolFeignClient.list();
    }

    @Override
    public List<ProtocolRes> list(Long v) {
        return protocolFeignClient.list(v);
    }

    @Override
    public Object save(ProtocolReq entity) {
        return protocolFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return protocolFeignClient.view(id);
    }

    @Override
    public Object edit(ProtocolReq entity) {
        return protocolFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return protocolFeignClient.delete(params);
    }

}

