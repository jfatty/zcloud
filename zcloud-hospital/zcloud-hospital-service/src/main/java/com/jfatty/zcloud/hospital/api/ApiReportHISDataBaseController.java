package com.jfatty.zcloud.hospital.api;

import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.health.feign.HealthCardStationFeignClient;
import com.jfatty.zcloud.health.vo.ReportHISDataVO;
import com.jfatty.zcloud.hospital.entity.ConfigProfile;
import com.jfatty.zcloud.hospital.entity.HealthPatient;
import com.jfatty.zcloud.hospital.service.ConfigProfileService;
import com.jfatty.zcloud.hospital.service.HealthPatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 描述 智慧医疗 电子健康卡用卡数据上报 基础API
 *
 * @author jfatty on 2020/5/22
 * @email jfatty@163.com
 */
@Slf4j
public class ApiReportHISDataBaseController {

    @Autowired
    protected ConfigProfileService configProfileService ;

    @Autowired
    protected HealthPatientService healthPatientService ;

    @Autowired
    protected HealthCardStationFeignClient healthCardStationFeignClient ;

    public void reportHISData(String brid,String sfzh,String scene ,String sceneName ,String department , String cardCostTypes ){
        try {
            //数据上报电子健康卡平台
            ConfigProfile configProfile = configProfileService.getConfigProfileByAppId(null);
            if ( configProfile != null && ConfigProfile.HEALTH_CARD_ENABLE.equals(configProfile.getHealthCardEnable()) ) {
                //数据上报
                ReportHISDataVO reportHISDataVO = new ReportHISDataVO();
                HealthPatient healthPatient = healthPatientService.getHealthPatient(brid,sfzh);
                reportHISDataVO.setName(healthPatient.getXm());
                reportHISDataVO.setQrCodeText(healthPatient.getQrCodeText());
                reportHISDataVO.setIdCardNumber(healthPatient.getSfzh());
                reportHISDataVO.setHospitalCode(configProfile.getHospitalId());
                //用卡环节代码预约挂号
                reportHISDataVO.setScene(scene);
                reportHISDataVO.setDepartment(department);
                reportHISDataVO.setTime( LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) );
                reportHISDataVO.setCardChannel("0401");
                reportHISDataVO.setCardType("11");
//                if (StringUtils.isEmptyOrBlank( healthPatient.getQrCodeText()) ){
//                    reportHISDataVO.setCardType("01");
//                } else {
//                    reportHISDataVO.setCardType("11");
//                }
                if ( StringUtils.isEmptyOrBlank( cardCostTypes ) ){
                    reportHISDataVO.setCardCostTypes( cardCostTypes );
                }
                healthCardStationFeignClient.reportHISData(configProfile.getHospitalId(),reportHISDataVO);
            }
        } catch ( Exception e ) {
            log.error("[{}] 数据上报电子健康卡平台 出现异常 ====> [{]]",sceneName,e.getMessage());
        }
    }


}
