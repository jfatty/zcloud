package com.jfatty.zcloud.hospital.api;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.hospital.entity.Menu;
import com.jfatty.zcloud.hospital.entity.SurveyAnswer;
import com.jfatty.zcloud.hospital.entity.SurveyOpenTime;
import com.jfatty.zcloud.hospital.req.SurveyFormReq;
import com.jfatty.zcloud.hospital.res.SurveyFormRes;
import com.jfatty.zcloud.hospital.service.HealthPatientService;
import com.jfatty.zcloud.hospital.service.MenuService;
import com.jfatty.zcloud.hospital.service.SurveyOpenTimeService;
import com.jfatty.zcloud.hospital.service.SurveyQuestionOptionsService;
import com.jfatty.zcloud.hospital.vo.SurveyForm;
import com.jfatty.zcloud.hospital.vo.WebRecordsMz;
import com.jfatty.zcloud.hospital.vo.WebRecordsZy;
import com.jfatty.zcloud.hospital.vo.WebVerifyUserinfo;
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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/5/27
 * @email jfatty@163.com
 */
@Api(tags = "满意度评价 院内自评 评价表管理 API" ,value = "包含 满意度评价 院内自评 ")
@Slf4j
@RestController
@RequestMapping("/api/surveyQuestionOptions")
public class ApiSurveyQuestionOptionsController {

    @Autowired
    private SurveyQuestionOptionsService surveyQuestionOptionsService ;

    @Autowired
    private MenuService menuService ;

    @Autowired
    private HealthPatientService healthPatientService ;

    @Autowired
    private SurveyOpenTimeService surveyOpenTimeService ;

    @ApiOperation(value=" 001**** 患者满意度评价 查询可供评估量表列表页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "brid", value = "病人ID",dataType = "String",defaultValue = "483756"),
            @ApiImplicitParam(name = "openId", value = "微信 支付宝 openId",dataType = "String",defaultValue = "oPGot0QAYXg-Y4OiTYUDn55sjRdo"),
            @ApiImplicitParam(name = "openIdType", value = "微信 2 支付宝 1 APP 3 openId 类型",dataType = "Integer",defaultValue = "2")
    })
    @RequestMapping(value="/getSurFormsByPatInfo", method=RequestMethod.GET)
    public RELResultUtils<SurveyFormRes> getSurFormsByPatInfo(@RequestParam(value = "brid" , defaultValue = "" ) String brid  ,
                                                        @RequestParam(value = "openId" , defaultValue = "") String openId ,
                                                        @RequestParam(value = "openIdType" , defaultValue = "" ) Integer openIdType){
        if ( StringUtils.isEmptyOrBlank(brid) ) {
            return RELResultUtils._509("病人ID不能为空");
        }
        List<SurveyForm> resSurveyForms = new ArrayList<SurveyForm>() ;
        List<String> surveyTypes = new ArrayList<String>();

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = df.format(LocalDateTime.now()) ;
        WebRecordsZy webRecordsZy = healthPatientService.getWebRecordsZy(brid);
        if ( webRecordsZy != null && webRecordsZy.success() ) {
            surveyTypes.add("zy");
            if ( "1".equals(webRecordsZy.getSsbz()) ) {
                surveyTypes.add("ss");
            }
            List<SurveyForm> sszyForms = surveyQuestionOptionsService.getSurFormsByTypes(surveyTypes);
            for ( SurveyForm surveyForm : sszyForms) {
                String startTime = webRecordsZy.getBeginHosTime() ;
                String endTime = null ;
                if ( StringUtils.isEmptyOrBlank(webRecordsZy.getOtherHosTime()) ) {
                    endTime = currentTime ;
                } else {
                    endTime = webRecordsZy.getOtherHosTime() ;
                }
                SurveyAnswer surveyAnswer = surveyQuestionOptionsService.getMidSurveyAnswer(surveyForm.getSurveyId(),brid,startTime,endTime);
                if ( surveyAnswer != null ) {
                    surveyForm.setAnswerId(surveyAnswer.getId());
                    surveyForm.setAssociationId(surveyAnswer.getAssociationId());
                    surveyForm.setAssociationer(surveyAnswer.getAssociationer());
                    surveyForm.setOperator(surveyAnswer.getOperator());
                    surveyForm.setOperationTime(surveyAnswer.getOperationTime());
                    surveyForm.setAnswerState(1);
                }
            }
            resSurveyForms.addAll(sszyForms);
        }
        surveyTypes.clear();
        WebRecordsMz webRecordsMz = healthPatientService.getWebRecordsMz(brid);
        if ( webRecordsMz != null && webRecordsMz.success() ) {
            surveyTypes.add("mz");
            List<SurveyForm> mzForms = surveyQuestionOptionsService.getSurFormsByTypes(surveyTypes);
            for ( SurveyForm surveyForm : mzForms ) {
                SurveyAnswer surveyAnswer = surveyQuestionOptionsService.getMoreSurveyAnswer(surveyForm.getSurveyId(),brid,webRecordsMz.getJzrq());
                if ( surveyAnswer != null ) {
                    surveyForm.setAnswerId(surveyAnswer.getId());
                    surveyForm.setAssociationId(surveyAnswer.getAssociationId());
                    surveyForm.setAssociationer(surveyAnswer.getAssociationer());
                    surveyForm.setOperator(surveyAnswer.getOperator());
                    surveyForm.setOperationTime(surveyAnswer.getOperationTime());
                    surveyForm.setAnswerState(1);
                }
            }
            resSurveyForms.addAll(mzForms);
        }
        surveyTypes.clear();
        surveyTypes.add("yj");
        List<SurveyForm> yjForms = surveyQuestionOptionsService.getSurFormsByTypes(surveyTypes);
        for ( SurveyForm surveyForm : yjForms) {
            SurveyOpenTime surveyOpenTime = surveyOpenTimeService.selectOpenTime(surveyForm.getSurveyId(),currentTime);
            if ( surveyOpenTime != null ) {
                SurveyAnswer surveyAnswer = surveyQuestionOptionsService.getMidSurveyAnswer(surveyForm.getSurveyId(),brid,surveyOpenTime.getStartTime().toString(),surveyOpenTime.getEndTime().toString());
                if ( surveyAnswer != null ) {
                    surveyForm.setAnswerId(surveyAnswer.getId());
                    surveyForm.setAssociationId(surveyAnswer.getAssociationId());
                    surveyForm.setAssociationer(surveyAnswer.getAssociationer());
                    surveyForm.setOperator(surveyAnswer.getOperator());
                    surveyForm.setOperationTime(surveyAnswer.getOperationTime());
                    surveyForm.setAnswerState(1);
                }
                resSurveyForms.add(surveyForm);
            }
        }
        if ( resSurveyForms.size() > 0  ) {
            List<SurveyFormRes> surveyFormRes = new ArrayList<SurveyFormRes>() ;
            for ( SurveyForm surveyForm : resSurveyForms) {
                SurveyFormRes surveyFormR = new SurveyFormRes() ;
                BeanUtils.copyProperties(surveyForm,surveyFormR);
                surveyFormRes.add(surveyFormR);
            }
            return  new RELResultUtils(surveyFormRes) ;
        }
        return RELResultUtils._506("该就诊人暂无满意度评价项目");
    }


    @ApiOperation(value=" 002**** 院内评价 通过菜单ID查询可供评估量表列表页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuId", value = "菜单ID",dataType = "String",defaultValue = "AAACCdXS"),
            @ApiImplicitParam(name = "phone", value = "用户登录",dataType = "String",defaultValue = "13275141536"),
            @ApiImplicitParam(name = "openId", value = "微信 支付宝 openId",dataType = "String",defaultValue = "oPGot0QAYXg-Y4OiTYUDn55sjRdo"),
            @ApiImplicitParam(name = "openIdType", value = "微信 2 支付宝 1 APP 3 openId 类型",dataType = "Integer",defaultValue = "2")
    })
    @RequestMapping(value="/getSurveyForms", method=RequestMethod.GET)
    public RELResultUtils<SurveyFormRes> getSurveyForms(@RequestParam(value = "menuId" , defaultValue = "" ) String menuId  ,
                                                        @RequestParam(value = "phone" , defaultValue = "") String phone ,
                                                        @RequestParam(value = "openId" , defaultValue = "") String openId ,
                                                        @RequestParam(value = "openIdType" , defaultValue = "" ) Integer openIdType){
        if ( StringUtils.isEmptyOrBlank(menuId) ) {
            return RELResultUtils._509("菜单ID不能为空");
        }
        if ( StringUtils.isEmptyOrBlank(phone) ) {
            return RELResultUtils._509("手机号不能为空");
        }
        Menu menu = menuService.getById(menuId) ;
        if ( null == menu ) {
            return RELResultUtils._509("菜单ID有误");
        }
        if ( "INTERNAL".equals(menu.getUseScope() ) ) {
            log.error("内部人员操作 需要调用HIS 验证用户信息");
            WebVerifyUserinfo webVerifyUserinfo = healthPatientService.verifyUserinfo(phone);
            if ( webVerifyUserinfo == null || !webVerifyUserinfo.success() ) {
                return RELResultUtils._506("抱歉!您不在本院职工信息中,暂不能进行院内评价");
            }
        }

        //判断 menuId
        List<SurveyForm> surveyForms = surveyQuestionOptionsService.getSurveyForms(menuId);
        if ( CollectionUtils.isEmpty(surveyForms) ) {
            return RELResultUtils._506("未查询到对应评价量表");
        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = df.format(LocalDateTime.now()) ;

        List<SurveyFormRes> surveyFormRes = new ArrayList<SurveyFormRes>() ;
        for ( SurveyForm surveyForm : surveyForms) {
            SurveyOpenTime surveyOpenTime = surveyOpenTimeService.selectOpenTime(surveyForm.getSurveyId(),currentTime);
            if ( surveyOpenTime != null ) {
                SurveyAnswer surveyAnswer = surveyQuestionOptionsService.getMidSurveyAnswer(surveyForm.getSurveyId(),phone,surveyOpenTime.getStartTime().toString(),surveyOpenTime.getEndTime().toString());
                if ( surveyAnswer != null ) {
                    surveyForm.setAnswerId(surveyAnswer.getId());
                    surveyForm.setAssociationId(surveyAnswer.getAssociationId());
                    surveyForm.setAssociationer(surveyAnswer.getAssociationer());
                    surveyForm.setOperator(surveyAnswer.getOperator());
                    surveyForm.setOperationTime(surveyAnswer.getOperationTime());
                    surveyForm.setAnswerState(1);
                }
            }
            SurveyFormRes surveyFormR = new SurveyFormRes() ;
            BeanUtils.copyProperties(surveyForm,surveyFormR);
            surveyFormRes.add(surveyFormR);
        }
        return  new RELResultUtils(surveyFormRes) ;
    }

    //回显 保存的数据

    //要操作的量表 ID 操作员ID 已评价状态下还有 答案ID
    @ApiOperation(value=" 003**** 量表回显 或者是量表带用户填写答案回显")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "surveyId", value = "量表ID",dataType = "String",defaultValue = "4028fe81726dc6e101726dcb39e70000"),
            @ApiImplicitParam(name = "answerId", value = "答案ID",dataType = "String",defaultValue = "871cd363a6af489e93e137d98156eb81"),
            @ApiImplicitParam(name = "operator", value = "操作员编码",dataType = "String",defaultValue = "wxe3336a60d2685379")
    })
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public RETResultUtils<SurveyFormRes> view(@RequestParam(value = "surveyId" , defaultValue = "" ) String surveyId  ,
                                              @RequestParam(value = "answerId" , defaultValue = "") String answerId ,
                                              @RequestParam(value = "operator" , defaultValue = "" ) String operator ) {
        if (StringUtils.isEmptyOrBlank(surveyId) ){
            return RETResultUtils._509("量表ID不能为空");
        }
        SurveyFormRes surveyFormRes = surveyQuestionOptionsService.getSurveyForm(surveyId,answerId,operator);
        return new RETResultUtils(surveyFormRes) ;

    }


    //修改
    //保存 数据格式同回显一样
    @ApiOperation(value=" 004**** 用户提交保存量表数据或修改已经保存的量表数据")
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RETResultUtils<String> edit(@RequestBody SurveyFormReq surveyFormReq ) {
        try {
            String msg = surveyQuestionOptionsService.edit(surveyFormReq);
            return new RETResultUtils(msg);
        } catch (Exception e) {
            log.error("用户提交保存量表数据或修改已经保存的量表数据 出现异常[{}]",e.getMessage());
            return new RETResultUtils("网络异常,请稍后重试");
        }

    }





}
