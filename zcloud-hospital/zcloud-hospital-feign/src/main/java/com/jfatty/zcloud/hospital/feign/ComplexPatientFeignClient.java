package com.jfatty.zcloud.hospital.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.hospital.entity.ComplexPatient;
import com.jfatty.zcloud.hospital.req.ComplexPatientReq;
import com.jfatty.zcloud.hospital.req.NumoPatientDeatilReq;
import com.jfatty.zcloud.hospital.req.NumoPatientInfoReq;
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

    @ApiOperation(value=" 002**** 添加/绑定 就诊人")
    @RequestMapping(value="/addComplexPatient", method=RequestMethod.POST)
    RETResultUtils<String> addComplexPatient(@RequestBody NumoPatientInfoReq numoPatientInfoReq);


    @ApiOperation(value=" 005****删除就诊人，即将就诊人与用户解绑")
    @RequestMapping(value="/delComplexPatient", method=RequestMethod.POST)
    RETResultUtils<String> deleteComplexPatient(@RequestBody NumoPatientDeatilReq numoPatientDeatilReq);



}
