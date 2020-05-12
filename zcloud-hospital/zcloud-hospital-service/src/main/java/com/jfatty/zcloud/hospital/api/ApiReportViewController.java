package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.hospital.req.WebPacsReportReq;
import com.jfatty.zcloud.hospital.req.WebReportListContentReq;
import com.jfatty.zcloud.hospital.req.WebReportListReq;
import com.jfatty.zcloud.hospital.req.WebReportMissionReq;
import com.jfatty.zcloud.hospital.res.*;
import com.jfatty.zcloud.hospital.service.ReportViewService;
import com.jfatty.zcloud.hospital.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述 查看报告
 * 检验报告 检查报告
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Api(tags = "查看报告API" ,value = "检验报告 检查报告")
@Slf4j
@RestController
@RequestMapping("/api/reportView")
public class ApiReportViewController {

    @Autowired
    private ReportViewService reportViewService ;

    @ApiOperation(value="001********获取报告任务")
    @RequestMapping(value = {"/getWebReportMission"} ,method = RequestMethod.POST)
    public RELResultUtils<WebReportMissionRes> getWebReportMission(@RequestBody WebReportMissionReq webReportMissionReq){
        List<WebReportMission> list = reportViewService.getWebReportMission(webReportMissionReq.getOpenId(),webReportMissionReq.getOpenIdType());
        if( !CollectionUtils.isEmpty(list) ){
            if( !((list.get(0)).success() ))
                return RELResultUtils._506(((list.get(0)).getMsg()));
            List<WebReportMissionRes> results = new ArrayList<WebReportMissionRes>();
            //list = list.stream().sorted(Comparator.comparing(WebReportMission::getBgrq).reversed()).collect(Collectors.toList());
            list.forEach(
                    webReportMission -> {
                        WebReportMissionRes webReportMissionRes = new WebReportMissionRes();
                        BeanUtils.copyProperties(webReportMission,webReportMissionRes);
                        results.add(webReportMissionRes);
                    }
            );
            return new RELResultUtils(results);
        }
        return RELResultUtils._506("医院系统中没有查询到数据");
    }

    @ApiOperation(value="002*******检验/检查报告列表 返回结果是列表")
    @RequestMapping(value = {"/getWebReportList"} ,method = RequestMethod.POST)
    public RELResultUtils<WebReportListRes> getWebReportList(@RequestBody WebReportListReq webReportListReq){
        List<WebReportList> list = reportViewService.getWebReportList(webReportListReq.getOpenId(), webReportListReq.getOpenIdType(),webReportListReq.getBglx(),webReportListReq.getBrbh());
        if( !CollectionUtils.isEmpty(list) ){
            if( !((list.get(0)).success() ))
                return RELResultUtils._506(((list.get(0)).getMsg()));
            List<WebReportListRes> results = new ArrayList<WebReportListRes>();
            list.forEach(
                    webReportList -> {
                        WebReportListRes webReportListRes = new WebReportListRes();
                        BeanUtils.copyProperties(webReportList,webReportListRes);
                        results.add(webReportListRes);
                    }
            );
            return new RELResultUtils(results);
        }
        return RELResultUtils._506("医院系统中没有查询到数据");
    }

    /**
     * 描述 检查报告内容  一条信息
     * @author jfatty
     * 创建时间：2018年11月06日
     */
    @ApiOperation(value="003*****检查报告内容 一条信息")
    @RequestMapping(value="/getWebPacsReport", method=RequestMethod.POST)
    public RETResultUtils<WebPacsReportRes> getWebPacsReport(@RequestBody WebPacsReportReq webPacsReportReq){
        WebPacsReport webPacsReport = reportViewService.getWebPacsReport(webPacsReportReq.getOpenId(), webPacsReportReq.getOpenIdType(),webPacsReportReq.getDjh());
        if(webPacsReport == null )
            return RETResultUtils._506("没有查询到检查报告数据");
        if(webPacsReport != null && !webPacsReport.success())
            return RETResultUtils._506(webPacsReport.getMsg());
        WebPacsReportRes webPacsReportRes = new WebPacsReportRes();
        BeanUtils.copyProperties(webPacsReport,webPacsReportRes);
        return new RETResultUtils(webPacsReportRes);
    }

    /**
     * 描述 获取检验报告内容包括头部信息以及详情
     * @author jfatty
     * 创建时间：2018年11月06日
     */
    @ApiOperation(value="004******获取检验报告内容包括头部信息以及详情")
    @RequestMapping(value="/getWebReportListContent", method=RequestMethod.POST)
    public ResultUtils getWebReportListContent(@RequestBody WebReportListContentReq webReportListContentReq){
        Map<String,Object> map = new HashMap<String,Object>();
        //头部数据
        WebReportLisHead webReportLisHead =  reportViewService.getWebReportListHead(webReportListContentReq.getOpenId(), webReportListContentReq.getOpenIdType(),webReportListContentReq.getSn());
        if (webReportLisHead == null)
            return ResultUtils._506( "没有查询到检验报告数据" );
        if(webReportLisHead != null && !webReportLisHead.success())
            return ResultUtils._506(webReportLisHead == null ? "没有查询到检验报告数据":webReportLisHead.getMsg() );
        WebReportLisHeadRes webReportLisHeadRes = new WebReportLisHeadRes();
        BeanUtils.copyProperties(webReportLisHead,webReportLisHeadRes);
        map.put("lisHead",webReportLisHeadRes);
        //内容列表数据
        List<WebReportLisDetail> list = reportViewService.getWebReportListDetail(webReportListContentReq.getOpenId(), webReportListContentReq.getOpenIdType(),webReportListContentReq.getSn());
        if( !CollectionUtils.isEmpty(list) ){
            if( !(list.get(0).success()))
                return ResultUtils._506(list.get(0).getMsg() );
            List<WebReportLisDetailRes> webReportLisDetailReses = new ArrayList<WebReportLisDetailRes>();
            list.forEach(
                    webReportLisDetail -> {
                        WebReportLisDetailRes webReportLisDetailRes = new WebReportLisDetailRes();
                        BeanUtils.copyProperties(webReportLisDetail,webReportLisDetailRes);
                        webReportLisDetailReses.add(webReportLisDetailRes);
                    }
            );
            map.put("lisDetail",webReportLisDetailReses);
        }
        return ResultUtils.success(map);
    }


}
