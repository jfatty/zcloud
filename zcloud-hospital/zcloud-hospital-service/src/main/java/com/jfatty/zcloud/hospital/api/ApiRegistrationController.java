package com.jfatty.zcloud.hospital.api;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.hospital.entity.RegisteredInfo;
import com.jfatty.zcloud.hospital.req.HosClazzReq;
import com.jfatty.zcloud.hospital.req.HosDeptReq;
import com.jfatty.zcloud.hospital.req.HosHolidayReq;
import com.jfatty.zcloud.hospital.req.PreRegisteredReq;
import com.jfatty.zcloud.hospital.res.HosClazzRes;
import com.jfatty.zcloud.hospital.res.HosDeptRes;
import com.jfatty.zcloud.hospital.res.PreRegisteredRes;
import com.jfatty.zcloud.hospital.service.ComplexPatientService;
import com.jfatty.zcloud.hospital.service.RegisteredInfoService;
import com.jfatty.zcloud.hospital.service.RegistrationService;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述 门诊挂号
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Api(tags = "门诊挂号API" ,value = "门诊挂号")
@Slf4j
@RestController
@RequestMapping("/api/registration")
public class ApiRegistrationController {

    @Autowired
    private RegistrationService registrationService ;

    @Autowired
    private ComplexPatientService complexPatientService ;

    @Autowired
    private RegisteredInfoService registeredInfoService ;

    @ApiOperation(value="001****获取医院 可预约挂号科室信息")
    @RequestMapping(value = {"/getHosDepts"} ,method = RequestMethod.POST)
    public RELResultUtils<HosDeptRes> getHosDepts(@RequestBody HosDeptReq hosDeptReq){
        List<HosDept> list = registrationService.getHosDepts(hosDeptReq.getOpenId(),hosDeptReq.getOpenIdType()) ;
        if( !CollectionUtils.isEmpty(list) ){
            if ( !(list.get(0).success()) )
                return RELResultUtils.success(list.get(0).getMsg());
            List<HosDeptRes> hosDeptReses = new ArrayList<HosDeptRes>();
            list.forEach(
                    hosDept -> {
                        HosDeptRes hosDeptRes = new HosDeptRes();
                        BeanUtils.copyProperties(hosDept,hosDeptRes);
                        hosDeptReses.add(hosDeptRes);
                    }
            );
            return new RELResultUtils(hosDeptReses);
        }
        return RELResultUtils.success("暂无可预约挂号科室信息");
    }

    @ApiOperation(value="002****获取医院 值班班次 信息")
    @RequestMapping(value = {"/getHosClazzs"} ,method = RequestMethod.POST)
    public RELResultUtils<HosClazzRes> getHosClazzs(@RequestBody HosClazzReq hosClazzReq){
        List<HosClazz> list = registrationService.getHosClazzs(hosClazzReq.getOpenId(),hosClazzReq.getOpenIdType()) ;
        if( !CollectionUtils.isEmpty(list) ){
            if ( !(list.get(0).success()) )
                return RELResultUtils.success(list.get(0).getMsg());
            List<HosClazzRes> hosClazzReses = new ArrayList<HosClazzRes>();
            list.forEach(
                    hosClazz -> {
                        HosClazzRes hosClazzRes = new HosClazzRes();
                        BeanUtils.copyProperties(hosClazz,hosClazzRes);
                        hosClazzReses.add(hosClazzRes);
                    }
            );
            return new RELResultUtils(hosClazzReses);
        }
        return RELResultUtils.success("暂无值班班次信息");
    }

    @ApiOperation(value="003****检验用户选择的日期是否为节假日")
    @RequestMapping(value = {"/checkHoliday"} ,method = RequestMethod.POST)
    public ResultUtils checkHoliday(@RequestBody HosHolidayReq hosHolidayReq){
        HosHoliday hosHoliday = registrationService.checkHoliday(hosHolidayReq.getOpenId(),hosHolidayReq.getOpenIdType(),hosHolidayReq.getCheckTime()) ;
        if(hosHoliday != null && hosHoliday.success() )
            return ResultUtils.success(hosHoliday.getMsg());
        return ResultUtils.success(hosHoliday.getMsg());
    }

    @ApiOperation(value="004****预约挂号*****")
    @RequestMapping(value = {"/preRegistered"} ,method = RequestMethod.POST)
    public RETResultUtils<PreRegisteredRes> preRegistered(@RequestBody PreRegisteredReq preRegisteredReq ){
        NumoPatientInfo numoPatientInfo = complexPatientService.getNumoPatientInfoByBrid(preRegisteredReq.getBrid());
        String sex = numoPatientInfo.getGender() == 1 ? "男" : "女" ;
        try {
            List<RegisteredInfo> registeredInfos = registeredInfoService.getRegisteredInfo(numoPatientInfo.getName(),numoPatientInfo.getIdCard(),null);
            if( !CollectionUtils.isEmpty(registeredInfos) ){
                String dateTime = registeredInfos.get(0).getPreTreatTime() ;
                dateTime = dateTime.substring(0,10);
                return new RETResultUtils(600,"就诊人"+numoPatientInfo.getName()+"已预约于"+dateTime+"在本院就诊") ;
            }
            PreRegistered preRegistered = registrationService.preRegistered(preRegisteredReq.getOpenId(),//
                    preRegisteredReq.getOpenIdType(),preRegisteredReq.getBrid(),//
                    numoPatientInfo.getName(),sex,numoPatientInfo.getIdCard(),//
                    numoPatientInfo.getTel(),preRegisteredReq.getKsid(),//
                    preRegisteredReq.getPreDate(),preRegisteredReq.getPreTime());
            if(preRegistered != null && !preRegistered.success() )
                return RETResultUtils.success(preRegistered.getMsg());
            PreRegisteredRes preRegisteredRes = new PreRegisteredRes();
            BeanUtils.copyProperties(preRegistered,preRegisteredRes);
            preRegisteredRes.setName(numoPatientInfo.getName());
            preRegisteredRes.setYyghsj(LocalDateTime.now().toString());
            preRegisteredRes.setStatus("成功");
            return new RETResultUtils(preRegisteredRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RETResultUtils(500,"网络异常,请稍后重试") ;
    }

}
