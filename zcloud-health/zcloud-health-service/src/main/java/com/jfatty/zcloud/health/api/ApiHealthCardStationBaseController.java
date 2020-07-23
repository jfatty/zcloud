package com.jfatty.zcloud.health.api;

import com.jfatty.zcloud.base.utils.IDCardUtil;
import com.jfatty.zcloud.health.entity.HCSHealthCardInfo;
import com.jfatty.zcloud.health.entity.HealthCardUser;
import com.jfatty.zcloud.health.service.*;
import com.jfatty.zcloud.health.vo.RegHealthCardInfoVO;
import com.jfatty.zcloud.hospital.feign.ComplexPatientFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述
 *
 * @author jfatty on 2020/5/21
 * @email jfatty@163.com
 */
@Slf4j
public class ApiHealthCardStationBaseController {


    @Autowired
    protected HealthCardStationService healthCardStationService ;

    @Autowired
    protected HCSHealthCardInfoService hcsHealthCardInfoService ;

    @Autowired
    protected HealthCardSettingsService healthCardSettingsService;

    @Autowired
    protected HealthCardUserService healthCardUserService ;

    @Autowired
    protected ComplexPatientFeignClient complexPatientFeignClient ;

    @Autowired
    protected HealthCard2HISService healthCard2HISService ;

    /**
     *  通过电子健康卡ID或身份证号 获取健康卡信息
     * @param healthCardInfoId 电子健康卡ID或身份证号
     * @return
     */
    public HCSHealthCardInfo getHcsHealthCardInfo(String healthCardInfoId) {
        //判断前端传入的是身份证号 还是健康卡信息记录ID(系统健康卡ID)
        IDCardUtil idCardUtil = new IDCardUtil(healthCardInfoId) ;
        //校验身份证号码是否合法
        String gender = idCardUtil.getGender() ;
        if ( null == gender){
            return hcsHealthCardInfoService.getById(healthCardInfoId);
        } else {
            return hcsHealthCardInfoService.getByIdCardNumber(healthCardInfoId);
        }
    }


    /**
     * 同步his电子健康信息
     * @param hcsHealthCardInfo
     * @return
     */
    public String syncHealthCard2HIS(HCSHealthCardInfo hcsHealthCardInfo){

        try{
            //同步his电子健康信息
            RegHealthCardInfoVO regHealthCardInfoVO = healthCard2HISService.regHealthCardInfo(hcsHealthCardInfo);
            log.error("返回信息 [{}]",regHealthCardInfoVO.getMsg());
            if ( regHealthCardInfoVO != null && regHealthCardInfoVO.success() ){
                return regHealthCardInfoVO.getBrid() ;
            }else {
                log.error("====>同步his电子健康信息失败 错误信息[{}]" , regHealthCardInfoVO!=null?regHealthCardInfoVO.getMsg():"返回对象为空");
                return "" ;
            }
        } catch ( Exception e) {
            log.error("====>同步his电子健康信息失败 出现异常[{}]" ,e.getMessage());
            return "" ;
        }
    }

    public void updateHealthCardUser(String wxAppId ,String hospitalId ,String openId ,Integer openIdType ,Integer isActive ,Integer isBatch ,Boolean isAct ){
        HealthCardUser healthCardUser = healthCardUserService.getByOpts(wxAppId,hospitalId,openId,openIdType);
        if ( healthCardUser == null ){
            healthCardUser = new HealthCardUser();
            healthCardUser.setAppid(wxAppId);
            healthCardUser.setHospitalId(hospitalId);
            healthCardUser.setOpenId(openId);
            healthCardUser.setOpenIdType(openIdType);
            String userId = null;
            try {
                userId = healthCardUserService.saveId(healthCardUser);
                healthCardUser.setId(userId);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if ( isAct ) {
            healthCardUser.setIsActive(isActive);
        } else {
            healthCardUser.setIsBatch(isBatch);
        }

        healthCardUserService.updateById(healthCardUser);
    }


}
