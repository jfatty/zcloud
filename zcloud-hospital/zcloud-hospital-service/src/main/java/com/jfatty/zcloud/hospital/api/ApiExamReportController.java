package com.jfatty.zcloud.hospital.api;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.hospital.req.ExamReportDetailReq;
import com.jfatty.zcloud.hospital.req.ExamReportReq;
import com.jfatty.zcloud.hospital.res.ExamReportRes;
import com.jfatty.zcloud.hospital.res.ExamReportTaskRes;
import com.jfatty.zcloud.hospital.service.ComplexPatientService;
import com.jfatty.zcloud.hospital.service.ExamReportService;
import com.jfatty.zcloud.hospital.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */
@Api(tags ="API体检报告查询接口", value = "体检报告查询接口", description = "体检报告查询服务")
@Slf4j
@RestController
@RequestMapping(value="/api/examReport")
public class ApiExamReportController {


    @Autowired
    private ExamReportService examReportService ;

    @Autowired
    private ComplexPatientService complexPatientService ;

    @ApiOperation(value=" 001**** POST 参数 查询有体检报告的就诊人列表附带报告数量 ")
    @RequestMapping(value="/getExamReports", method=RequestMethod.POST)
    public RELResultUtils<ExamReportRes> getExamReports(@RequestBody ExamReportReq examReportReq ){
        String openId = examReportReq.getOpenId() ;
        Integer openIdType = examReportReq.getOpenIdType() ;
        List<WebRegPatient> list = complexPatientService.getWebRegList(openId, openIdType,examReportReq.getPageIndex(),examReportReq.getPageSize());
        if ( !CollectionUtils.isEmpty(list) ){
            if ( !(list.get(0).success()) )
                return RELResultUtils._506("未找到有效体检报告") ;
            List<ExamReportRes> results = new ArrayList<ExamReportRes>();
            for ( WebRegPatient webRegPatient : list ) {
                List<ExamReportTask>  examReportTasks = examReportService.getExamReportTasks(webRegPatient.getBrid());
                if ( !CollectionUtils.isEmpty(list) && examReportTasks.get(0).success() ){
                    List<ExamReportTaskRes> tasks = new ArrayList<ExamReportTaskRes>();
                    for ( ExamReportTask examReportTask : examReportTasks ) {
                        ExamReportTaskRes examReportTaskRes = new ExamReportTaskRes();
                        BeanUtils.copyProperties(examReportTask,examReportTaskRes);
                        tasks.add(examReportTaskRes);
                    }
                    ExamReportRes examReportRes = new ExamReportRes();
                    BeanUtils.copyProperties(webRegPatient,examReportRes);
                    examReportRes.setBgsl(examReportTasks.size());
                    examReportRes.setTasks(new ArrayList<ExamReportTaskRes>(tasks));
                    results.add(examReportRes);
                }
            }
            if ( CollectionUtils.isEmpty(results) )
                return RELResultUtils._506("未找到有效体检报告!") ;
            return new RELResultUtils(results) ;
        }
        return RELResultUtils._506("请先添加就诊人!") ;
    }

    @ApiOperation(value=" 002**** POST 参数 根据体检报告单据号查询体检报告详情 ")
    @RequestMapping(value="/getExamReportDetail", method=RequestMethod.POST)
    public ResultUtils getExamReportDetail(@RequestBody ExamReportDetailReq examReportDetailReq){
        String openId = examReportDetailReq.getOpenId() ;
        Integer openIdType = examReportDetailReq.getOpenIdType() ;
        String djh  = examReportDetailReq.getDjh() ;
        Map<String,Object> result = new HashMap<String,Object>() ;
        //基础信息
        ReportJcxx reportJcxx = examReportService.getReportJcxx(djh);
        //总结建议
        ReportZjjy reportZjjy = examReportService.getReportZjjy(djh);
        List<EreportBase> ereports =  examReportService.getEreportResponse(djh) ;
        result.put("reportJcxx",reportJcxx);
        result.put("reportZjjy",reportZjjy);
        result.put("ereports",ereports);
        return ResultUtils.success(result);
    }
}
