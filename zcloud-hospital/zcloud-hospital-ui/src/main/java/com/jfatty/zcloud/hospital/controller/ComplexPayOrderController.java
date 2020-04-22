package com.jfatty.zcloud.hospital.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.ComplexPayOrder;
import com.jfatty.zcloud.hospital.feign.ComplexPayOrderFeignClient;
import com.jfatty.zcloud.hospital.req.ComplexPayOrderReq;
import com.jfatty.zcloud.hospital.res.ComplexPayOrderRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述 智慧医疗交易订单
 *
 * @author jfatty on 2020/4/21
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping("/complexPayOrder")
public class ComplexPayOrderController implements IBaseController<ComplexPayOrder,ComplexPayOrderReq,ComplexPayOrderRes> {

    @Autowired
    private ComplexPayOrderFeignClient complexPayOrderFeignClient ;

    @Override
    public RELResultUtils<ComplexPayOrderRes> table(Map<String, Object> params) {
        return complexPayOrderFeignClient.table(params);
    }

    @Override
    public RELResultUtils<ComplexPayOrderRes> table(String v, Integer pageIndex, Integer pageSize) {
        return complexPayOrderFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return complexPayOrderFeignClient.list();
    }

    @Override
    public List<ComplexPayOrderRes> list(Long v) {
        return complexPayOrderFeignClient.list(v);
    }

    @Override
    public Object save(ComplexPayOrderReq entity) {
        return complexPayOrderFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return complexPayOrderFeignClient.view(id);
    }

    @Override
    public Object edit(ComplexPayOrderReq entity) {
        return complexPayOrderFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return complexPayOrderFeignClient.delete(params);
    }
}
