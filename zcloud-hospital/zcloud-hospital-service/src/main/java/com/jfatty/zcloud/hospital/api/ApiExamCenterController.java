package com.jfatty.zcloud.hospital.api;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.hospital.req.*;
import com.jfatty.zcloud.hospital.res.*;
import com.jfatty.zcloud.hospital.service.ComplexPatientService;
import com.jfatty.zcloud.hospital.service.ExamCenterService;
import com.jfatty.zcloud.hospital.vo.ExamReserve;
import com.jfatty.zcloud.hospital.vo.ReserveRecord;
import com.jfatty.zcloud.hospital.vo.WebExamDetail;
import com.jfatty.zcloud.hospital.vo.WebExamPackage;
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
 * 描述
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */
@Api(tags ="API体检中心接口", value = "体检中心接口", description = "体检中心接口服务")
@Slf4j
@RestController
@RequestMapping("/api/examCenter")
public class ApiExamCenterController {


    @Autowired
    private ExamCenterService examCenterService ;

    @Autowired
    private ComplexPatientService complexPatientService ;

    @ApiOperation(value=" 001**** POST 参数 获取套餐列表")
    @RequestMapping(value="/getWebExamPackages", method=RequestMethod.POST)
    public RELResultUtils<WebExamPackageRes> getWebExamPackages(@RequestBody WebExamPackageReq webExamPackageReq){
        String openId = webExamPackageReq.getOpenId() ;
        Integer openIdType = webExamPackageReq.getOpenIdType() ;
        List<WebExamPackage> webExamPackages = examCenterService.getWebExamPackages(openId,openIdType);
        if(CollectionUtils.isNotEmpty(webExamPackages)){
            List<WebExamPackageRes> webExamPackageList = new ArrayList<WebExamPackageRes>();
            for ( WebExamPackage webExamPackage : webExamPackages ) {
                WebExamPackageRes webExamPackageRes = new WebExamPackageRes();
                BeanUtils.copyProperties(webExamPackage,webExamPackageRes);
                webExamPackageList.add(webExamPackageRes);
            }
            return new RELResultUtils(webExamPackageList) ;
        }
        return RELResultUtils._509("暂无体检套餐") ;
    }

    @ApiOperation(value=" 002**** POST 参数 获取套餐详情(明细)")
    @RequestMapping(value="/getWebExamDetails", method=RequestMethod.POST)
    public RELResultUtils<WebExamDetailRes> getWebExamDetails(@RequestBody WebExamDetailReq webExamDetailReq){
        String openId = webExamDetailReq.getOpenId() ;
        Integer openIdType = webExamDetailReq.getOpenIdType() ;
        String tcid = webExamDetailReq.getTcid();
        List<WebExamDetail> webExamDetails = examCenterService.getWebExamDetails(openId,openIdType,tcid);
        if ( CollectionUtils.isEmpty(webExamDetails) )
            return RELResultUtils._509("请检查套餐ID") ;
        List<WebExamDetailRes> webExamDetailList = new ArrayList<WebExamDetailRes>();
        for ( WebExamDetail webExamDetail : webExamDetails ) {
            WebExamDetailRes webExamDetailRes = new WebExamDetailRes();
            BeanUtils.copyProperties(webExamDetail,webExamDetailRes);
            webExamDetailList.add(webExamDetailRes);
        }
        return new RELResultUtils(webExamDetailList) ;
    }

    @ApiOperation(value=" 003**** POST 参数 个人预约")
    @RequestMapping(value="/reservePerson", method=RequestMethod.POST)
    public RETResultUtils<ExamReserveRes> reservePerson(@RequestBody ExamReservePersonReq examReservePersonReq){
        String openId = examReservePersonReq.getOpenId() ;
        if (StringUtils.isEmptyOrBlank(openId))
            return RETResultUtils._509("请检查套餐ID") ;
        Integer openIdType = examReservePersonReq.getOpenIdType() ;
        String  brid  = examReservePersonReq.getBrid();
        if (StringUtils.isEmptyOrBlank(brid))
            return RETResultUtils._509("就诊人ID不能为空") ;
        String tcid = examReservePersonReq.getTcid();
        if (StringUtils.isEmptyOrBlank(tcid))
            return RETResultUtils._509("请选择对应套餐") ;
        String yyrq = examReservePersonReq.getYyrq();
        if (StringUtils.isEmptyOrBlank(yyrq))
            return RETResultUtils._509("请选择有效体检日期") ;
        NumoPatientDeatilRes numoPatientDeatilRes = complexPatientService.getNumoPatientInfo(openId,openIdType,brid);
        ExamReserve examReserve = examCenterService.examReserve(yyrq,0,"",1,brid,tcid,numoPatientDeatilRes.getName(),
                numoPatientDeatilRes.getTel(),examReservePersonReq.getLxdz(),examReservePersonReq.getBeizhu(),numoPatientDeatilRes.getIdCard(),
                "",examReservePersonReq.getTcmc(),openId);
        ExamReserveRes examReserveRes = new ExamReserveRes();
        BeanUtils.copyProperties(examReserve,examReserveRes);
        return new RETResultUtils(examReserveRes) ;
    }

    @ApiOperation(value=" 004**** POST 参数 团队预约")
    @RequestMapping(value="/reserveTeam", method=RequestMethod.POST)
    public RETResultUtils<ExamReserveRes> reserveTeam(@RequestBody ExamReserveTeamReq examReserveTeamReq){
        String openId = examReserveTeamReq.getOpenId() ;
        if (StringUtils.isEmptyOrBlank(openId))
            return RETResultUtils._509("请检查套餐ID") ;
        Integer openIdType = examReserveTeamReq.getOpenIdType() ;
        String yyrq = examReserveTeamReq.getYyrq();
        if (StringUtils.isEmptyOrBlank(yyrq))
            return RETResultUtils._509("请选择有效体检日期") ;
        String  lxr  = examReserveTeamReq.getLxr();
        if (StringUtils.isEmptyOrBlank(lxr))
            return RETResultUtils._509("联系人不能为空") ;
        String lsfx = examReserveTeamReq.getLxfs() ;
        if (StringUtils.isEmptyOrBlank(lsfx))
            return RETResultUtils._509("联系方式不能为空") ;
        String yydw = examReserveTeamReq.getYydw();
        if (StringUtils.isEmptyOrBlank(lsfx))
            return RETResultUtils._509("单位名称") ;
        ExamReserve examReserve = examCenterService.examReserve(yyrq,1,yydw,examReserveTeamReq.getYyrs(),"","",lxr,
                lsfx,examReserveTeamReq.getLxdz(),examReserveTeamReq.getBeizhu(),"",
                examReserveTeamReq.getRjys(),"",openId);
        ExamReserveRes examReserveRes = new ExamReserveRes();
        BeanUtils.copyProperties(examReserve,examReserveRes);
        return new RETResultUtils(examReserveRes) ;
    }

    //预约记录
    @ApiOperation(value=" 005**** POST 参数 预约记录")
    @RequestMapping(value="/getReserveRecords", method=RequestMethod.POST)
    public RELResultUtils<ReserveRecordRes>  getReserveRecords(@RequestBody ReserveRecordReq reserveRecordReq){
        String openId = reserveRecordReq.getOpenId() ;
        Integer openIdType = reserveRecordReq.getOpenIdType() ;
        List<ReserveRecord> list = examCenterService.getReserveRecords(openId,openIdType);
        if ( CollectionUtils.isEmpty(list) )
            return RELResultUtils._506("暂无体检预约记录") ;
        List<ReserveRecordRes> reserveRecordList = new ArrayList<ReserveRecordRes>();
        for ( ReserveRecord reserveRecord : list ) {
            ReserveRecordRes reserveRecordRes = new ReserveRecordRes();
            BeanUtils.copyProperties(reserveRecord,reserveRecordRes);
            reserveRecordList.add(reserveRecordRes);
        }
        return new RELResultUtils(reserveRecordList) ;
    }

    //记录详情
    @ApiOperation(value=" 006**** POST 参数 记录详情")
    @RequestMapping(value="/getReserveRecord", method=RequestMethod.POST)
    public RETResultUtils<ReserveRecordRes>  getReserveRecord(@RequestBody ReserveRecordReq reserveRecordReq){
        String openId = reserveRecordReq.getOpenId() ;
        Integer openIdType = reserveRecordReq.getOpenIdType() ;
        String yyh = reserveRecordReq.getYyh();
        if (StringUtils.isEmptyOrBlank(yyh))
            return RETResultUtils._509("预约号不能为空") ;
        ReserveRecord reserveRecord = examCenterService.getReserveRecord(openId,openIdType,yyh);
        ReserveRecordRes reserveRecordRes = new ReserveRecordRes();
        BeanUtils.copyProperties(reserveRecord,reserveRecordRes);
        return new RETResultUtils(reserveRecordRes) ;

    }


}
