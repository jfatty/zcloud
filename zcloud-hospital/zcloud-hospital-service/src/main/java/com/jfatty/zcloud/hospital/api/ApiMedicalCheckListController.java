package com.jfatty.zcloud.hospital.api;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.hospital.req.WebCyfyqdReq;
import com.jfatty.zcloud.hospital.req.WebCyqdListReq;
import com.jfatty.zcloud.hospital.req.WebZyrqdReq;
import com.jfatty.zcloud.hospital.res.WebCyfyqdRes;
import com.jfatty.zcloud.hospital.res.WebCyqdListRes;
import com.jfatty.zcloud.hospital.res.WebZyrqdRes;
import com.jfatty.zcloud.hospital.service.MedicalCheckListService;
import com.jfatty.zcloud.hospital.vo.WebCyfyqd;
import com.jfatty.zcloud.hospital.vo.WebCyqdList;
import com.jfatty.zcloud.hospital.vo.WebZyrqd;
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
import java.util.List;

/**
 * 描述 住/出院清单查看
 *
 * @author jfatty on 2020/7/15
 * @email jfatty@163.com
 */
@Api(tags ="API住/出院清单查看", value = "住/出院清单查看", description = "住/出院清单查看接口服务")
@Slf4j
@RestController
@RequestMapping("/api/medicalCheckList")
public class ApiMedicalCheckListController {

    @Autowired
    private MedicalCheckListService medicalCheckListService ;


    @ApiOperation(value="**********01住院日清单查询")
    @RequestMapping(value = {"/getInHosCheckList"} ,method = RequestMethod.POST)
    public RELResultUtils<WebZyrqdRes> getInHosCheckList(@RequestBody WebZyrqdReq webZyrqdReq ) {
        String openId = webZyrqdReq.getOpenId() ;
        Integer openIdType = webZyrqdReq.getOpenIdType() ;
        String brid = webZyrqdReq.getBrid() ;
        String startTime = webZyrqdReq.getStartTime() ;
        String endTime = webZyrqdReq.getEndTime() ;
        if( StringUtils.isEmptyOrBlank( openId ) )
            return RELResultUtils._509("openId不能为空");
        if( StringUtils.isEmptyOrBlank( brid ) )
            return RELResultUtils._509("病人ID不能为空");
        List<WebZyrqd> webZyrqds = medicalCheckListService.getWebZyrqd(openId,openIdType,brid,startTime,endTime) ;
        if( !CollectionUtils.isEmpty(webZyrqds) ){
            if(!webZyrqds.get(0).success()){
                return RELResultUtils._506((webZyrqds.get(0)).getMsg());
            }
            List<WebZyrqdRes> results = new ArrayList<WebZyrqdRes>();
            for ( WebZyrqd webZyrqd : webZyrqds) {
                WebZyrqdRes resItem = new WebZyrqdRes();
                BeanUtils.copyProperties(webZyrqd,resItem);
                results.add(resItem);
            }
            return new RELResultUtils(results);
        }
        return RELResultUtils._506("没有查询到住院日清单信息!");
    }

    @ApiOperation(value="**********02住院记录查询")
    @RequestMapping(value = {"/getOutHosTask"} ,method = RequestMethod.POST)
    public RELResultUtils<WebCyqdListRes> getOutHosTask(@RequestBody WebCyqdListReq webCyqdListReq ) {
        String openId = webCyqdListReq.getOpenId() ;
        Integer openIdType = webCyqdListReq.getOpenIdType() ;
        String brid = webCyqdListReq.getBrid() ;
        if( StringUtils.isEmptyOrBlank( openId ) )
            return RELResultUtils._509("openId不能为空");
        if( StringUtils.isEmptyOrBlank( brid ) )
            return RELResultUtils._509("病人ID不能为空");
        List<WebCyqdList> webCyqdLists = medicalCheckListService.getWebCyqdList(openId,openIdType,brid) ;
        if( !CollectionUtils.isEmpty(webCyqdLists) ){
            if(!webCyqdLists.get(0).success()){
                return RELResultUtils._506((webCyqdLists.get(0)).getMsg());
            }
            List<WebCyqdListRes> results = new ArrayList<WebCyqdListRes>();
            for (WebCyqdList webCyqdLi : webCyqdLists ) {
                WebCyqdListRes resItem = new WebCyqdListRes() ;
                BeanUtils.copyProperties(webCyqdLi,resItem);
                results.add(resItem);
            }
            return new RELResultUtils(results);
        }
        return RELResultUtils._506("没有查询到您的住院记录!");
    }

    @ApiOperation(value="**********03出院清单查询")
    @RequestMapping(value = {"/getOutHosList"} ,method = RequestMethod.POST)
    public RELResultUtils<WebCyfyqdRes> getOutHosList(@RequestBody WebCyfyqdReq webCyfyqdReq ) {
        String openId = webCyfyqdReq.getOpenId() ;
        Integer openIdType = webCyfyqdReq.getOpenIdType() ;
        String zybh = webCyfyqdReq.getZybh() ;
        if( StringUtils.isEmptyOrBlank( openId ) )
            return RELResultUtils._509("openId不能为空");
        if( StringUtils.isEmptyOrBlank( zybh ) )
            return RELResultUtils._509("住院编号不能为空");
        List<WebCyfyqd>  webCyfyqds = medicalCheckListService.getWebCyfyqd(openId,openIdType,zybh) ;
        if( !CollectionUtils.isEmpty(webCyfyqds) ){
            if(!webCyfyqds.get(0).success()){
                return RELResultUtils._506((webCyfyqds.get(0)).getMsg());
            }
            List<WebCyfyqdRes> results = new ArrayList<WebCyfyqdRes>();
            for ( WebCyfyqd webCyfyqd : webCyfyqds ) {
                WebCyfyqdRes resItem = new WebCyfyqdRes() ;
                BeanUtils.copyProperties(webCyfyqd,resItem);
                results.add(resItem);
            }
            return new RELResultUtils(results);
        }
        return RELResultUtils._506("没有查询到有关出院清单!");
    }


}
