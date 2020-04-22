package com.jfatty.zcloud.hospital.api;

import com.jfatty.zcloud.hospital.entity.ComplexPayOrder;
import com.jfatty.zcloud.hospital.interfaces.IComplexPayOrder;
import com.jfatty.zcloud.hospital.req.ComplexPayOrderReq;
import com.jfatty.zcloud.hospital.res.ComplexPayOrderRes;
import com.jfatty.zcloud.hospital.service.ComplexPayOrderService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述 智慧医疗交易订单
 *
 * @author jfatty on 2020/4/21
 * @email jfatty@163.com
 */
@Api(tags = "智慧医疗交易订单API" ,value = "智慧医疗交易订单")
@Slf4j
@RestController
@RequestMapping("/api/complexPayOrder")
public class ApiComplexPayOrderController extends ApiBaseHospitalController<ComplexPayOrder,ComplexPayOrderReq,ComplexPayOrderRes> implements IComplexPayOrder {

    private ComplexPayOrderService complexPayOrderService ;

    @Autowired
    public void setComplexPayOrderService(ComplexPayOrderService complexPayOrderService) {
        super.setBaseService(complexPayOrderService);
        this.complexPayOrderService = complexPayOrderService;
    }
}
