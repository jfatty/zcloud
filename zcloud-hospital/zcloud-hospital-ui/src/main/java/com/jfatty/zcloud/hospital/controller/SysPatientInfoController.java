package com.jfatty.zcloud.hospital.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.SysPatientInfo;
import com.jfatty.zcloud.hospital.feign.SysPatientInfoFeignClient;
import com.jfatty.zcloud.hospital.req.SysPatientInfoReq;
import com.jfatty.zcloud.hospital.res.SysPatientInfoRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/12
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping("/sysPatientInfo")
public class SysPatientInfoController implements IBaseController<SysPatientInfo,SysPatientInfoReq,SysPatientInfoRes> {


    @Autowired
    private SysPatientInfoFeignClient sysPatientInfoFeignClient ;

    @Override
    public RELResultUtils<SysPatientInfoRes> table(Map<String, Object> params) {
        return sysPatientInfoFeignClient.table(params);
    }

    @Override
    public RELResultUtils<SysPatientInfoRes> table(String v, Integer pageIndex, Integer pageSize) {
        return sysPatientInfoFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return sysPatientInfoFeignClient.list();
    }

    @Override
    public List<SysPatientInfoRes> list(Long v) {
        return sysPatientInfoFeignClient.list(v);
    }

    @Override
    public Object save(SysPatientInfoReq entity) {
        return sysPatientInfoFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return sysPatientInfoFeignClient.view(id);
    }

    @Override
    public Object edit(SysPatientInfoReq entity) {
        return sysPatientInfoFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return sysPatientInfoFeignClient.delete(params);
    }
}
