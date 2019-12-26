package com.jfatty.zcloud.health.service.impl;

import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.health.entity.HCSIDCardInfo;
import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.mapper.HCSIDCardInfoMapper;
import com.jfatty.zcloud.health.mapper.HealthCardSettingsMapper;
import com.jfatty.zcloud.health.service.HealthCardStationService;
import com.jfatty.zcloud.health.vo.HCSIDCardInfoVO;
import com.tencent.healthcard.impl.HealthCardServerImpl;
import com.tencent.healthcard.model.AppTokenInfo;
import com.tencent.healthcard.model.CommonIn;
import com.tencent.healthcard.model.IDCardInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class HealthCardStationServiceImpl extends BaseHealthServiceImpl<HealthCardSettings,HealthCardSettingsMapper> implements HealthCardStationService {

    private HealthCardSettingsMapper healthCardSettingsMapper ;

    @Autowired
    private HCSIDCardInfoMapper hcsidCardInfoMapper ;

    @Autowired
    public void setHealthCardSettingsMapper(HealthCardSettingsMapper healthCardSettingsMapper) {
        super.setBaseMapper(healthCardSettingsMapper);
        this.healthCardSettingsMapper = healthCardSettingsMapper;
    }

    @Override
    public HCSIDCardInfoVO ocrInfo(String appId,String imageContent) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(appId);
        //创建健康卡实例，传入appSecret
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        //创建【公共输入参数commonIn】实例
        CommonIn commonIn = new CommonIn(settings.getAppToken(), settings.getRequestId(), settings.getHospitalId());
        IDCardInfo idCardInfo = healthCard.ocrInfo(commonIn,imageContent);
        log.error("orc身份证图片数据获取 [{}]",idCardInfo.getId());
        HCSIDCardInfo hcsidCardInfo = new HCSIDCardInfo();
        BeanUtils.copyProperties(idCardInfo,hcsidCardInfo);
        hcsidCardInfoMapper.insert(hcsidCardInfo);
        HCSIDCardInfoVO hcsidCardInfoVO = new HCSIDCardInfoVO();
        BeanUtils.copyProperties(idCardInfo,hcsidCardInfoVO);
        return hcsidCardInfoVO;
    }

    private HealthCardSettings getAppTokenHealthCardSettings(String appId){
        HealthCardSettings settings =  healthCardSettingsMapper.getByAppId(appId);
        if ( StringUtils.isEmptyOrBlank(settings.getAppToken())  ){ //或者超时
            //创建健康卡实例，传入appSecret
            HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
            CommonIn commonIn=new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
            //调用接口appId
            AppTokenInfo appTokenInfo = healthCard.getAppToken(commonIn,appId);
            //打印响应
            System.out.println(appTokenInfo.getAppToken());
            settings.setAppToken(appTokenInfo.getAppToken());
            settings.setExpiresIn(appTokenInfo.getExpiresIn());
            settings.setUpdateTime(LocalDateTime.now());
            healthCardSettingsMapper.updateById(settings);
        }
        return settings ;
    }
}
