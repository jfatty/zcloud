package com.jfatty.zcloud.hospital.api;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.hospital.req.*;
import com.jfatty.zcloud.hospital.res.*;
import com.jfatty.zcloud.hospital.service.ComplexPatientService;
import com.jfatty.zcloud.hospital.service.ComplexPayService;
import com.jfatty.zcloud.hospital.utils.IdCardUtil;
import com.jfatty.zcloud.hospital.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 综合缴费管理
 * 描述 门诊缴费 住院预缴
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Api(tags = "综合缴费管理API" ,value = "包含 门诊缴费 住院预缴")
@Slf4j
@RestController
@RequestMapping("/api/complexPay")
public class ApiComplexPayController {


    @Autowired
    private ComplexPayService complexPayService ;

    @Autowired
    private ComplexPatientService complexPatientService ;

    /**
     * 描述 查询微信用户绑定的有门诊缴费信息的病人以及待缴费信息
     * @author jfatty
     * 创建时间：2018年3月26日
     */
    @ApiOperation(value="001*******查询微信用户绑定的 有门诊/住院 缴费信息的病人以及待缴费信息")
    @RequestMapping(value="/getPendingPayList", method=RequestMethod.POST)
    public RELResultUtils<WebMissionRes> getPendingPayList(@RequestBody WebMissionReq webMissionReq){
        List<WebMission> list = complexPayService.getWebMissionList(webMissionReq.getOpenId(), webMissionReq.getOpenIdType());
        if ( !CollectionUtils.isEmpty(list) ){
            if ( !(list.get(0).success()) )
                return RELResultUtils._506(list.get(0).getMsg());
            Integer feeType = webMissionReq.getFeeType() ;
            List<WebMissionRes> webMissionReses = new ArrayList<WebMissionRes>();
            for (WebMission webMission : list) {
                // 门诊
                if (feeType == ComplexPay.FEE_TYPE_MZ && "门诊缴费".equals(webMission.getRwlx())) {
                    WebMissionRes webMissionRes = new WebMissionRes();
                    BeanUtils.copyProperties(webMission,webMissionRes);
                    webMissionReses.add(webMissionRes);
                }
                // 住院
                if (feeType == ComplexPay.FEE_TYPE_ZY && "住院预缴".equals(webMission.getRwlx())) {
                    WebMissionRes webMissionRes = new WebMissionRes();
                    BeanUtils.copyProperties(webMission,webMissionRes);
                    webMissionReses.add(webMissionRes);
                }
            }
            return  new RELResultUtils(webMissionReses);
        }
        return RELResultUtils._506("医院系统中没有查询到数据");
    }

    @ApiOperation(value="002*******查询就诊人待缴费单信息")
    @RequestMapping(value="/getUnPayOutpatients", method=RequestMethod.POST)
    public RETResultUtils<WebmzListRes> getUnPayOutpatients(@RequestBody UnPayOutpatientReq unPayOutpatientReq){
        List<WebmzList> list = complexPayService.getWebmzList(unPayOutpatientReq.getOpenId(), unPayOutpatientReq.getOpenIdType(),unPayOutpatientReq.getDjh());
        if( !CollectionUtils.isEmpty(list) ){
            if( !(list.get(0)).success() )
                return RETResultUtils._506((list.get(0)).getMsg());
            List<UnPayOutpatientRes> unPayOutpatientReses = new ArrayList<UnPayOutpatientRes>();
            list.forEach(
                    webmzList -> {
                        UnPayOutpatientRes unPayOutpatientRes = new UnPayOutpatientRes();
                        BeanUtils.copyProperties(webmzList,unPayOutpatientRes);
                        unPayOutpatientReses.add(unPayOutpatientRes);
                    }
            );
            NumoPatientDeatilRes numoPatientDeatilRes = complexPatientService.getNumoPatientInfo(unPayOutpatientReq.getBrid());
            WebmzListRes webmzListRes = new WebmzListRes()//
                    .setName(numoPatientDeatilRes.getName())//
                    .setIdCard(numoPatientDeatilRes.getIdCard())//
                    .setUnPays(unPayOutpatientReses);
            return new RETResultUtils(webmzListRes);
        }
        return RETResultUtils._506("医院系统中没有查询到数据");
    }

    @ApiOperation(value="003******通过费用单号查询单笔门诊缴费详情")
    @RequestMapping(value="/getOutpatientDetail", method=RequestMethod.POST)
    public RETResultUtils<OutpatientDetailRes> getOutpatientDetail(@RequestBody OutpatientDetailReq outpatientDetailReq ){
        OutpatientDetail outpatientDetail = complexPayService.getWebmzDetail(outpatientDetailReq.getOpenId(),outpatientDetailReq.getOpenIdType(),outpatientDetailReq.getFydh());
        if(outpatientDetail == null )
            return RETResultUtils._506("系统未查询到门诊缴费详情");
        if(outpatientDetail != null && !outpatientDetail.success())
            return RETResultUtils._506(outpatientDetail.getMsg());
        OutpatientDetailRes outpatientDetailRes = new OutpatientDetailRes();
        BeanUtils.copyProperties(outpatientDetail,outpatientDetailRes);
        return new RETResultUtils(outpatientDetailRes);
    }

    @ApiOperation(value="004****获取门诊缴费合计订单详情")
    @RequestMapping(value="/getTotalUnPayOutpatient", method=RequestMethod.POST)
    public RETResultUtils<TotalUnPayOutpatientRes> getTotalUnPayOutpatient(@RequestBody TotalUnPayOutpatientReq totalUnPayOutpatientReq ){
        TotalUnPayOutpatient totalUnPayOutpatient = complexPayService.getMZPay(totalUnPayOutpatientReq.getOpenId(), totalUnPayOutpatientReq.getOpenIdType(),totalUnPayOutpatientReq.getDjh(),totalUnPayOutpatientReq.getBrid());
        if(totalUnPayOutpatient == null )
            return RETResultUtils._506("没有查询到缴费单详情数据!");
        //身份证加星号操作
        NumoPatientDeatilRes numoPatientDeatilRes = complexPatientService.getNumoPatientInfo(totalUnPayOutpatientReq.getBrid());
        TotalUnPayOutpatientRes totalUnPayOutpatientRes = new TotalUnPayOutpatientRes();
        BeanUtils.copyProperties(totalUnPayOutpatient,totalUnPayOutpatientRes);
        totalUnPayOutpatientRes.setXm(numoPatientDeatilRes.getName());
        totalUnPayOutpatientRes.setSfzh(IdCardUtil.coverStarts(numoPatientDeatilRes .getIdCard(),6,14));
        totalUnPayOutpatientRes.setDqrq(LocalDateTime.now().toString());
        totalUnPayOutpatientRes.setJzh(totalUnPayOutpatientReq.getDjh());
        return new RETResultUtils(totalUnPayOutpatientRes);
    }

    /**
     * 查询就诊人当前 住院详情  jfatty 2017-11-29
     * @return
     */
    @ApiOperation(value="005****获取就诊人当前住院详情")
    @RequestMapping(value="/findPatientInHospitalInfoNow", method=RequestMethod.POST)
    public RETResultUtils<InHospitalInfoRes> findPatientInHospitalInfoNow(@RequestBody InHospitalInfoReq inHospitalInfoReq){
        String djh = inHospitalInfoReq.getDjh() ;
        InHospitalInfo inHospitalInfo = complexPayService.getZYPre(inHospitalInfoReq.getOpenId(),inHospitalInfoReq.getOpenIdType(),djh);
        if(inHospitalInfo == null)
            return RETResultUtils._506("系统未查询到就诊人当前住院详情");
        if(inHospitalInfo != null && !inHospitalInfo.success())
            return RETResultUtils._506(inHospitalInfo.getMsg());
        InHospitalInfoRes inHospitalInfoRes = new InHospitalInfoRes();
        BeanUtils.copyProperties(inHospitalInfo,inHospitalInfoRes);
        inHospitalInfoRes.setDjh(djh);
        inHospitalInfoRes.setJzh(djh);
        return new RETResultUtils(inHospitalInfoRes);
    }


    @ApiOperation(value="006*** URL拼接参数 通过交易订单号查询支付信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "outTradeNo", value = "交易订单号",dataType = "String",defaultValue = "WC201909261150360002")
    })
    @RequestMapping(value="/getPaySucessRecordInfoByOutTradeNo", method=RequestMethod.GET)
    public RETResultUtils<OutTradeNoOrderRes> getPaySucessRecordInfoByOutTradeNo(@RequestParam(value = "outTradeNo" , defaultValue = "WC201909216150360002") String outTradeNo ){
        if(StringUtils.isEmptyOrBlank(outTradeNo))
            return RETResultUtils._509("交易订单号不能为空!");
        ComplexPay pay = complexPayService.getPayRecordByOutTradeNo(outTradeNo);
        if (pay != null){
            NumoPatientDeatilRes patient = complexPatientService.getNumoPatientInfo(String.valueOf(pay.getPatientId()));
            OutTradeNoOrderRes outTradeNoOrderRes = new OutTradeNoOrderRes();
            BeanUtils.copyProperties(pay,outTradeNoOrderRes);
            outTradeNoOrderRes.setName(patient.getName());
            outTradeNoOrderRes.setIdCard(IdCardUtil.coverStarts(patient.getIdCard(),6,14));
            return new RETResultUtils(outTradeNoOrderRes);
        }
        return RETResultUtils._506("系统中不存在该笔交易!");
    }



}
