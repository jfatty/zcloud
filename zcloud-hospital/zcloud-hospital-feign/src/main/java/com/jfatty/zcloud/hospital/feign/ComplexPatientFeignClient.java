package com.jfatty.zcloud.hospital.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.ComplexPatient;
import com.jfatty.zcloud.hospital.req.ComplexPatientReq;
import com.jfatty.zcloud.hospital.res.WebRegPatientRes;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 描述
 *
 * @author jfatty on 2019/12/29
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-hospital-service" , path = "/api/complexPatient" )
public interface ComplexPatientFeignClient extends BInterface<ComplexPatient,ComplexPatientReq,WebRegPatientRes> {



    @ApiOperation(value=" 001**** POST 参数 查询微信/支付宝 ... 用户绑定的就诊人列表信息")
    @RequestMapping(value="/getComplexPatients", method=RequestMethod.POST)
    RELResultUtils<WebRegPatientRes> getComplexPatients(@RequestBody ComplexPatientReq complexPatientReq);



}
