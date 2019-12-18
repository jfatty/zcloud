package com.jfatty.zcloud.hospital.api;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.hospital.req.ElectronicDocDetailReq;
import com.jfatty.zcloud.hospital.req.ElectronicDocReq;
import com.jfatty.zcloud.hospital.res.ElectronicDocDetailExtRes;
import com.jfatty.zcloud.hospital.res.ElectronicDocDetailRes;
import com.jfatty.zcloud.hospital.res.ElectronicDocRes;
import com.jfatty.zcloud.hospital.service.ElectronicDocService;
import com.jfatty.zcloud.hospital.vo.ElectronicDoc;
import com.jfatty.zcloud.hospital.vo.ElectronicDocDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述 电子票据 我的服务单
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Api(tags = "我的服务单/电子票据API" ,value = "我的服务单/电子票据")
@Slf4j
@RestController
@RequestMapping("/api/electronicDoc")
public class ApiElectronicDocController {

    @Autowired
    private ElectronicDocService electronicDocService ;

    @ApiOperation(value="001*****分页查询门诊挂号服务单 以及挂号单")
    @RequestMapping(value = {"/getElectronicDocList"} ,method = RequestMethod.POST)
    public RELResultUtils<ElectronicDocRes> getElectronicDocList(@RequestBody ElectronicDocReq electronicDocReq){
        List<ElectronicDoc> list = electronicDocService.getElectronicDocList(electronicDocReq.getOpenId(),electronicDocReq.getOpenIdType(),electronicDocReq.getStartTime(),electronicDocReq.getEndTime());
        if(CollectionUtils.isNotEmpty(list)){
            if(!(list.get(0)).success())
                return RELResultUtils.success((list.get(0)).getMsg());
            List<ElectronicDocRes> result = new ArrayList<ElectronicDocRes>();
            list.forEach(
                 electronicDoc -> {
                     ElectronicDocRes electronicDocRes = new ElectronicDocRes();
                     BeanUtils.copyProperties(electronicDoc,electronicDocRes);
                     result.add(electronicDocRes);
                 }
            );
            return new RELResultUtils(result);
        }
        return RELResultUtils.success("没有查询到信息");
    }


    @ApiOperation(value="002*****查看门诊缴费详情")
    @RequestMapping(value = {"/getElectronicDocDetail"} ,method = RequestMethod.POST)
    public RETResultUtils<ElectronicDocDetailExtRes> getElectronicDocDetail(@RequestBody ElectronicDocDetailReq electronicDocDetailReq){
        List<ElectronicDocDetail> list = electronicDocService.getElectronicDocDetail(electronicDocDetailReq.getOpenId(),electronicDocDetailReq.getOpenIdType(),electronicDocDetailReq.getBrbh(),electronicDocDetailReq.getSfh());
        if(CollectionUtils.isNotEmpty(list)){
            System.out.println(list.get(0).success());
            if(!list.get(0).success())
                return RETResultUtils.success((list.get(0)).getMsg());
            ElectronicDocDetailExtRes electronicDocDetailExtRes = new ElectronicDocDetailExtRes();
            BeanUtils.copyProperties(list.get(0),electronicDocDetailExtRes);
            List<ElectronicDocDetailRes>  elecDocs = new ArrayList<ElectronicDocDetailRes>();
            list.forEach(
                    electd -> {
                        ElectronicDocDetailRes electronicDocDe = new ElectronicDocDetailRes();
                        BeanUtils.copyProperties(electd,electronicDocDe);
                        elecDocs.add(electronicDocDe);
                    }
            );
            electronicDocDetailExtRes.setElecDocs(elecDocs);
            return new RETResultUtils(electronicDocDetailExtRes );
        }
        return RETResultUtils.success("没有查询到信息");
    }

}
