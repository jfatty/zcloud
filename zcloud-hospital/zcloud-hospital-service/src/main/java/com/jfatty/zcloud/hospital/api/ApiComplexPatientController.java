package com.jfatty.zcloud.hospital.api;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.hospital.req.ComplexPatientReq;
import com.jfatty.zcloud.hospital.req.NumoPatientDeatilReq;
import com.jfatty.zcloud.hospital.req.NumoPatientInfoReq;
import com.jfatty.zcloud.hospital.res.NumoPatientDeatilRes;
import com.jfatty.zcloud.hospital.res.WebRegPatientRes;
import com.jfatty.zcloud.hospital.service.ComplexPatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述  就诊人综合管理
 * 包含 就诊人管理 电子就诊卡
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Api(tags = "就诊人综合管理API" ,value = "包含 就诊人管理 电子就诊卡")
@Slf4j
@RestController
@RequestMapping("/api/complexPatient")
public class ApiComplexPatientController {

    @Autowired
    private ComplexPatientService complexPatientService ;

    @ApiOperation(value=" 001**** POST 参数 查询微信/支付宝 ... 用户绑定的就诊人的信息")
    @RequestMapping(value="/getComplexPatients", method=RequestMethod.POST)
    public ResultUtils getComplexPatients(@RequestBody ComplexPatientReq complexPatientReq){
        List<WebRegPatientRes> list = complexPatientService.getWebRegList(complexPatientReq.getOpenId(), complexPatientReq.getOpenIdType(),complexPatientReq.getPageIndex(),complexPatientReq.getPageSize());
        if(CollectionUtils.isNotEmpty(list))
            return ResultUtils.success(list) ;
        return ResultUtils.success("请先绑定就诊人!") ;
    }


    @ApiOperation(value=" 002**** 添加/绑定 就诊人")
    @RequestMapping(value="/addComplexPatient", method=RequestMethod.POST)
    public ResultUtils AddComplexPatient(@RequestBody NumoPatientInfoReq numoPatientInfoReq){
        boolean res = false;
        try {
            res = complexPatientService.saveComplexPatient(numoPatientInfoReq.getOpenId(),numoPatientInfoReq.getOpenIdType(),numoPatientInfoReq.getName(),//
                    numoPatientInfoReq.getIdCard(),numoPatientInfoReq.getTel(),//
                    numoPatientInfoReq.getAddress(),numoPatientInfoReq.getNation(),//
                    numoPatientInfoReq.getHisCardNo(),numoPatientInfoReq.getHisCardType());
            if(res)
                return ResultUtils.success("绑定成功");
        } catch (Exception e) {
            log.error("程序绑定就诊人信息时出现异常 请核查:[{}]",e.getMessage());
            return ResultUtils.success(e.getMessage());
        }
        return ResultUtils.failure(500,"网络延时,请稍后重试");
    }

    @ApiOperation(value=" 003****查询单个就诊人详情")
    @RequestMapping(value="/getNumoPatientInfo", method=RequestMethod.POST)
    public ResultUtils getNumoPatientInfo(@RequestBody NumoPatientDeatilReq numoPatientDeatilReq){
        NumoPatientDeatilRes numoPatientDeatilRes = complexPatientService.getNumoPatientInfo(numoPatientDeatilReq.getBrid());
        return ResultUtils.success(numoPatientDeatilRes);
    }

    @ApiOperation(value=" 004****删除就诊人，即将就诊人与用户解绑")
    @RequestMapping(value="/delComplexPatient", method=RequestMethod.POST)
    public ResultUtils deleteComplexPatient(@RequestBody NumoPatientDeatilReq numoPatientDeatilReq){
        NumoPatientDeatilRes numoPatientDeatilRes = complexPatientService.getNumoPatientInfo(numoPatientDeatilReq.getBrid());
        try {
            if( complexPatientService.deleteComplexPatient(numoPatientDeatilRes.getId(),numoPatientDeatilRes.getIdCard(),numoPatientDeatilRes.getName(),numoPatientDeatilReq.getOpenId(),numoPatientDeatilReq.getOpenIdType()) )
                return ResultUtils.success("就诊人解绑成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtils.failure(500,"his注销绑定失败!请稍后重试!");
    }




}
