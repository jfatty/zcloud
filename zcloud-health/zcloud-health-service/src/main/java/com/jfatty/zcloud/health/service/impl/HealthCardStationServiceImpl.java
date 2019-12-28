package com.jfatty.zcloud.health.service.impl;

import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.health.entity.HCSIDCardInfo;
import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.mapper.HCSIDCardInfoMapper;
import com.jfatty.zcloud.health.mapper.HealthCardSettingsMapper;
import com.jfatty.zcloud.health.req.HCSHealthCardInfoReq;
import com.jfatty.zcloud.health.service.HealthCardStationService;
import com.jfatty.zcloud.health.vo.DynamicQRCodeVO;
import com.jfatty.zcloud.health.vo.HCSIDCardInfoVO;
import com.jfatty.zcloud.health.vo.HealthCardInfoVO;
import com.jfatty.zcloud.health.vo.ReportHISDataVO;
import com.tencent.healthcard.impl.HealthCardServerImpl;
import com.tencent.healthcard.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

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


    private HealthCardSettings getAppTokenHealthCardSettings(String appId){
        HealthCardSettings settings =  healthCardSettingsMapper.getByAppId(appId);
        //获取秒数 second
        //Long timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        //Long expireTimeSecond = settings.getExpireTime().toEpochSecond(ZoneOffset.of("+8"));
        Long timestamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        Long expireTimeSecond = settings.getExpireTime().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        Long dis = timestamp - expireTimeSecond - 60000;
        log.error("判断appToken是否超时===>[{}]",dis);
        if ( StringUtils.isEmptyOrBlank(settings.getAppToken()) || dis > 0  ){ //或者超时
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
            //
            Long expiresIn = timestamp +  new Long((long)appTokenInfo.getExpiresIn()) - 60000;
            LocalDateTime expireTime =LocalDateTime.ofEpochSecond(expiresIn/1000,0,ZoneOffset.ofHours(8));
            settings.setExpireTime(expireTime);
            //Instant instant = Instant.ofEpochMilli(expiresIn);
            //settings.setExpireTime(LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai")));
            healthCardSettingsMapper.updateById(settings);
        }
        return settings ;
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


    @Override
    public HealthCardInfoVO registerHealthCard(String appId, HCSHealthCardInfoReq hcsHealthCardInfoReq) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(appId);

        HealthCardClientServiceImpl  healthCard = new HealthCardClientServiceImpl(settings.getAppSecret());
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        HealthCardInfo healthCardInfoR = new HealthCardInfo();
        BeanUtils.copyProperties(hcsHealthCardInfoReq,healthCardInfoR);
        /************************************************************/
        healthCardInfoR.setWechatCode(settings.getWechatCode());
        /************************************************************/
        HealthCardInfo hInfo = healthCard.registerHealthCard(commonIn,healthCardInfoR);
        System.out.println("腾讯返回===================>"+hInfo.getPhid());
        HealthCardInfoVO healthCardInfoVO = new HealthCardInfoVO();
        BeanUtils.copyProperties(hInfo,healthCardInfoVO);
        System.out.println("属性拷贝后===================>"+healthCardInfoVO.getPhid());
        return healthCardInfoVO;
    }

    @Override
    public HealthCardInfoVO getHealthCardByHealthCode(String appId, String healthCode) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(appId);
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        HealthCardInfo hInfo = healthCard.getHealthCardByHealthCode(commonIn,healthCode);
        HealthCardInfoVO healthCardInfoVO = new HealthCardInfoVO();
        BeanUtils.copyProperties(hInfo,healthCardInfoVO);
        return healthCardInfoVO;
    }

    @Override
    public HealthCardInfoVO getHealthCardByQRCode(String appId, String qrCodeText) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(appId);
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        HealthCardInfo hInfo = healthCard.getHealthCardByQRCode(commonIn,qrCodeText);
        HealthCardInfoVO healthCardInfoVO = new HealthCardInfoVO();
        BeanUtils.copyProperties(hInfo,healthCardInfoVO);
        return healthCardInfoVO;
    }

    @Override
    public Boolean bindCardRelation(String appId, String patId, String qrCodeText) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(appId);
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        return healthCard.bindCardRelation(commonIn,patId,qrCodeText);
    }

    @Override
    public void reportHISData(String appId, ReportHISDataVO reportHISData) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(appId);
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        ReportHISData reportHIS = new ReportHISData();
        BeanUtils.copyProperties(reportHISData,reportHIS);
        healthCard.reportHISData(commonIn,reportHIS);
    }

    @Override
    public String getOrderIdByOutAppId(String appId, String qrCodeText) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(appId);
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        return healthCard.getOrderIdByOutAppId(commonIn,appId,qrCodeText);
    }

    @Override
    public List<HealthCardInfoVO> registerBatchHealthCard(String appId, List<HealthCardInfoVO> healthCardInfos) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(appId);
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());

        List<HealthCardInfo> cardInfos = new ArrayList<HealthCardInfo>();
        healthCardInfos.forEach(
                inInfo -> {
                    HealthCardInfo cInfo = new HealthCardInfo();
                    BeanUtils.copyProperties(inInfo,cInfo);
                    cardInfos.add(cInfo);
                }
        );
        List<HealthCardInfo> hInfos = healthCard.registerBatchHealthCard(commonIn,cardInfos);
        List<HealthCardInfoVO> hInfosReses = new ArrayList<HealthCardInfoVO>();
        hInfos.forEach(
                info -> {
                    HealthCardInfoVO eInfo = new HealthCardInfoVO();
                    BeanUtils.copyProperties(info,eInfo);
                    hInfosReses.add(eInfo);
                }
        );
        return hInfosReses;
    }

    @Override
    public DynamicQRCodeVO getDynamicQRCode(String appId, String healthCardId, String idType, String idNumber) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(appId);
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        DynamicQRCode dynamicQRCode = healthCard.getDynamicQRCode(commonIn,healthCardId,idType,idNumber);
        DynamicQRCodeVO dynamicQRCodeVO = new DynamicQRCodeVO();
        BeanUtils.copyProperties(dynamicQRCode,dynamicQRCodeVO);
        return dynamicQRCodeVO;
    }
}
