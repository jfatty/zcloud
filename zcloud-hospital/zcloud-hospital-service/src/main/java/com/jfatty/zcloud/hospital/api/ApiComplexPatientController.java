package com.jfatty.zcloud.hospital.api;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jfatty.zcloud.base.utils.IDCardUtil;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.hospital.req.ComplexPatientReq;
import com.jfatty.zcloud.hospital.req.NumoDefaultPatientReq;
import com.jfatty.zcloud.hospital.req.NumoPatientDeatilReq;
import com.jfatty.zcloud.hospital.req.NumoPatientInfoReq;
import com.jfatty.zcloud.hospital.res.NumoPatientDeatilRes;
import com.jfatty.zcloud.hospital.res.WebRegPatientRes;
import com.jfatty.zcloud.hospital.service.ComplexPatientService;
import com.jfatty.zcloud.hospital.utils.IdCardUtil;
import com.jfatty.zcloud.hospital.vo.NumoPatientInfo;
import com.jfatty.zcloud.hospital.vo.WebRegPatient;
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
    public RELResultUtils<WebRegPatientRes> getComplexPatients(@RequestBody ComplexPatientReq complexPatientReq){
        List<WebRegPatient> list = complexPatientService.getWebRegList(complexPatientReq.getOpenId(), complexPatientReq.getOpenIdType(),complexPatientReq.getPageIndex(),complexPatientReq.getPageSize());
        if(CollectionUtils.isNotEmpty(list)){
            if ( !(list.get(0).success()) ){
                String msg = list.get(0).getMsg() ;
                if (msg.contains("未找到有效"))
                    return RELResultUtils._506("请先添加就诊人!") ;
                return RELResultUtils._506(msg);
            }
            List<WebRegPatientRes> results = new ArrayList<WebRegPatientRes>();
            list.forEach(
                    webRegPatient -> {
                        WebRegPatientRes webRegPatientRes = new WebRegPatientRes();
                        BeanUtils.copyProperties(webRegPatient,webRegPatientRes);
                        results.add(webRegPatientRes);
                    }
            );
            return new RELResultUtils(results) ;
        }
        return RELResultUtils._506("请先添加就诊人!") ;
    }


    @ApiOperation(value=" 002**** 添加/绑定 就诊人")
    @RequestMapping(value="/addComplexPatient", method=RequestMethod.POST)
    public RETResultUtils<String> AddComplexPatient(@RequestBody NumoPatientInfoReq numoPatientInfoReq){
        boolean res = false;
        String openId = numoPatientInfoReq.getOpenId() ;
        Integer openIdType = numoPatientInfoReq.getOpenIdType() ;
        String idCard = null;
        String gender = null;
        try {
            idCard = numoPatientInfoReq.getIdCard() ;
            IDCardUtil idCardUtil = new IDCardUtil(idCard) ;
            gender = idCardUtil.getGender();
        } catch (Exception e) {
            log.error("程序绑定就诊人信息时出现异常 就诊人身份证号[{}]不合法:",idCard);
            return RETResultUtils._509("请输入合法的就诊人身份证号");
        }
        try {
            boolean b = complexPatientService.isExist(openId, openIdType, NumoPatientInfo.ATTENTION);
            if ( !b )
                complexPatientService.subscribeEvent(openId, openIdType, NumoPatientInfo.ATTENTION);
        } catch (Exception e) {
            log.error("====> 关注公众号事件,添加用户信息 处理异常 openId= [{}] openIdType= [{}] 异常信息=[{}]" , openId , openIdType ,e.getMessage() );
        }
        try {

            res = complexPatientService.saveComplexPatient(openId,openIdType,numoPatientInfoReq.getName(),//
                    gender,idCard,numoPatientInfoReq.getTel(),//
                    numoPatientInfoReq.getAddress(),numoPatientInfoReq.getNation(),//
                    numoPatientInfoReq.getRelationship(),numoPatientInfoReq.getHasCard(),//
                    numoPatientInfoReq.getHisCardNo(),numoPatientInfoReq.getHisCardType());
            if(res)
                return RETResultUtils.success("绑定成功");
        } catch (Exception e) {
            log.error("程序绑定就诊人信息时出现异常 请核查:[{}]",e.getMessage());
            return RETResultUtils._506(e.getMessage());
        }
        return RETResultUtils.faild("网络延时,请稍后重试");
    }

    @ApiOperation(value=" 003****查询单个就诊人详情")
    @RequestMapping(value="/getNumoPatientInfo", method=RequestMethod.POST)
    public RETResultUtils<NumoPatientDeatilRes> getNumoPatientInfo(@RequestBody NumoPatientDeatilReq numoPatientDeatilReq){
        String openId = numoPatientDeatilReq.getOpenId() ;
        Integer openIdType = numoPatientDeatilReq.getOpenIdType() ;
        String brid = numoPatientDeatilReq.getBrid();
        if( StringUtils.isEmptyOrBlank( openId ) )
            return RETResultUtils._509("openId不能为空");
        if( StringUtils.isEmptyOrBlank( brid ) )
            return RETResultUtils._509("病人ID不能为空");
        try {
            boolean b = complexPatientService.isExist(openId, openIdType, NumoPatientInfo.ATTENTION);
            if ( !b )
                complexPatientService.subscribeEvent(openId, openIdType, NumoPatientInfo.ATTENTION);
        } catch (Exception e) {
            log.error("====> 关注公众号事件,添加用户信息 处理异常 openId= [{}] openIdType= [{}] 异常信息=[{}]" , openId , openIdType ,e.getMessage() );
        }
        boolean b = complexPatientService.checkRightByBrid(openId, openIdType, brid);                      //查询用户有无操作就诊人的权限
        if ( !b )
            return RETResultUtils._509("此病人不在本系统中");//没有操作数据的权限
        NumoPatientDeatilRes numoPatientDeatilRes = complexPatientService.getNumoPatientInfo(openId,openIdType,brid);
        numoPatientDeatilRes.setIdCard(IdCardUtil.coverStarts(numoPatientDeatilRes.getIdCard(),6,14));
        return new RETResultUtils(numoPatientDeatilRes);
    }

    @ApiOperation(value=" 004****开关设置默认就诊人")
    @RequestMapping(value="/setDefaultPat", method=RequestMethod.POST)
    public RETResultUtils<String> setDefaultPat(@RequestBody NumoDefaultPatientReq numoDefaultPatientReq){
        String openId = numoDefaultPatientReq.getOpenId() ;
        Integer openIdType = numoDefaultPatientReq.getOpenIdType() ;
        String brid = numoDefaultPatientReq.getBrid();
        if( StringUtils.isEmptyOrBlank( openId ) )
            return RETResultUtils._509("openId不能为空");
        if( StringUtils.isEmptyOrBlank( brid ) )
            return RETResultUtils._509("病人ID不能为空");
        boolean b = complexPatientService.checkRightByBrid(openId, openIdType, brid);                      //查询用户有无操作就诊人的权限
        if ( !b )
            return RETResultUtils._509("此病人不在本系统中");//没有操作数据的权限
        Integer bindStatus = numoDefaultPatientReq.getBindStatus() ;
        boolean result = false;
        try {
            result = complexPatientService.bindDefaultPat(openId, openIdType, brid,bindStatus);
            String msg = bindStatus == 1 ? "":"取消" ;
            if(result)
                return new RETResultUtils("默认就诊人"+msg+"绑定成功");
        } catch (Exception e) {
            log.error("设置默认就诊人出现异常 [{}]",e.getMessage());
            return RETResultUtils.faild("网络崩溃了,请联系运维小哥哥");
        }
        return RETResultUtils.faild("网络延时,请稍后重试");
    }

    @ApiOperation(value=" 005****删除就诊人，即将就诊人与用户解绑")
    @RequestMapping(value="/delComplexPatient", method=RequestMethod.POST)
    public RETResultUtils<String> deleteComplexPatient(@RequestBody NumoPatientDeatilReq numoPatientDeatilReq){
        String openId = numoPatientDeatilReq.getOpenId() ;
        Integer openIdType = numoPatientDeatilReq.getOpenIdType() ;
        String brid = numoPatientDeatilReq.getBrid();
        if( StringUtils.isEmptyOrBlank( openId ) )
            return RETResultUtils._509("openId不能为空");
        if( StringUtils.isEmptyOrBlank( brid ) )
            return RETResultUtils._509("病人ID不能为空");
        NumoPatientDeatilRes numoPatientDeatilRes = complexPatientService.getNumoPatientInfo(openId,openIdType,brid);
        try {
            if( complexPatientService.deleteComplexPatient(numoPatientDeatilRes.getId(),numoPatientDeatilRes.getIdCard(),numoPatientDeatilRes.getName(),numoPatientDeatilReq.getOpenId(),numoPatientDeatilReq.getOpenIdType()) )
                return RETResultUtils.success("就诊人解绑成功");
            return RETResultUtils.faild("his注销绑定失败!请稍后重试!");
        } catch (Exception e) {
            log.error("his注销绑定失败! [{}]",e.getMessage());
            return RETResultUtils.faild("his注销绑定失败!请稍后重试!");
        }
    }


}
