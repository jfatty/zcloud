package com.jfatty.zcloud.hospital.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.TreatGuide;
import com.jfatty.zcloud.hospital.feign.TreatGuideFeignClient;
import com.jfatty.zcloud.hospital.req.TreatGuideReq;
import com.jfatty.zcloud.hospital.res.TreatGuideRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述 就诊指南
 *
 * @author jfatty on 2020/4/28
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping("/treatGuide")
public class TreatGuideController implements IBaseController<TreatGuide,TreatGuideReq,TreatGuideRes> {


    @Autowired
    private TreatGuideFeignClient treatGuideFeignClient ;


    @Override
    public RELResultUtils<TreatGuideRes> table(Map<String, Object> params) {
        return treatGuideFeignClient.table(params);
    }

    @Override
    public RELResultUtils<TreatGuideRes> table(String v, Integer pageIndex, Integer pageSize) {
        return treatGuideFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return treatGuideFeignClient.list();
    }

    @Override
    public List<TreatGuideRes> list(Long v) {
        return treatGuideFeignClient.list(v);
    }

    @Override
    public Object save(TreatGuideReq entity) {
        return treatGuideFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return treatGuideFeignClient.view(id);
    }

    @Override
    public Object edit(TreatGuideReq entity) {
        return treatGuideFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return treatGuideFeignClient.delete(params);
    }
}
