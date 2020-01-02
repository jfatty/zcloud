package com.jfatty.zcloud.health.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.mapper.HealthCardSettingsMapper;
import com.jfatty.zcloud.health.model.AppTokenInfo;
import com.jfatty.zcloud.health.model.DynamicQRCode;
import com.jfatty.zcloud.health.model.IDCardInfo;
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
import java.util.*;

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
    public void setHealthCardSettingsMapper(HealthCardSettingsMapper healthCardSettingsMapper) {
        super.setBaseMapper(healthCardSettingsMapper);
        this.healthCardSettingsMapper = healthCardSettingsMapper;
    }


    private HealthCardSettings getAppTokenHealthCardSettings(String hospitalId){
        HealthCardSettings settings =  healthCardSettingsMapper.getByHospitalId(hospitalId);
        //获取秒数 second
        //Long timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        //Long expireTimeSecond = settings.getExpireTime().toEpochSecond(ZoneOffset.of("+8"));
        String appId = settings.getAppid();
        Long timestamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        Long expireTimeSecond = settings.getExpireTime().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        Long dis = timestamp - expireTimeSecond - 60000;
        log.error("判断appToken是否超时===>[{}]",dis);
        if ( StringUtils.isEmptyOrBlank(settings.getAppToken()) || dis > 0  ){ //或者超时
            //创建健康卡实例，传入appSecret
            HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
            CommonIn commonIn=new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId(),0);
            //调用接口appId

            AppTokenInfo appTokenInfo = healthCard.getAppToken(commonIn,appId).toJavaObject(AppTokenInfo.class);
            //打印响应
            settings.setAppToken(appTokenInfo.getAppToken());
            settings.setExpiresIn(appTokenInfo.getExpiresIn());
            settings.setUpdateTime(LocalDateTime.now());
            //
            Long expiresIn = timestamp +  new Long((long)appTokenInfo.getExpiresIn() * 1000) - 60000;
            LocalDateTime expireTime =LocalDateTime.ofEpochSecond(expiresIn/1000,0,ZoneOffset.ofHours(8));
            settings.setExpireTime(expireTime);
            //Instant instant = Instant.ofEpochMilli(expiresIn);
            //settings.setExpireTime(LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai")));
            healthCardSettingsMapper.updateById(settings);
        }
        return settings ;
    }


    @Override
    public HCSIDCardInfoVO ocrInfo(String hospitalId,String imageContent) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        //创建健康卡实例，传入appSecret
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        //创建【公共输入参数commonIn】实例
        CommonIn commonIn = new CommonIn(settings.getAppToken(), settings.getRequestId(), settings.getHospitalId(),0);
        IDCardInfo idCardInfo = healthCard.ocrInfo(commonIn,imageContent).getJSONObject("cardInfo").toJavaObject(IDCardInfo.class);
        log.error("orc身份证图片数据获取 [{}]",idCardInfo.getId());
        HCSIDCardInfoVO hcsidCardInfoVO = new HCSIDCardInfoVO();
        BeanUtils.copyProperties(idCardInfo,hcsidCardInfoVO);
        return hcsidCardInfoVO;
    }


    @Override
    public HealthCardInfoVO registerHealthCard(String hospitalId, HCSHealthCardInfoReq hcsHealthCardInfoReq) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);

        HealthCardServerImpl  healthCard = new HealthCardServerImpl(settings.getAppSecret());
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId(),0);
        HealthCardInfo healthCardInfoR = new HealthCardInfo();
        BeanUtils.copyProperties(hcsHealthCardInfoReq,healthCardInfoR);
        /************************************************************/
        healthCardInfoR.setWechatCode(settings.getWechatCode());
        /************************************************************/
        JSONObject jsonObject = healthCard.registerHealthCard(commonIn,healthCardInfoR);

        HealthCardInfoVO healthCardInfoVO = new HealthCardInfoVO();
        healthCardInfoVO.setQrCodeText(jsonObject.getString("qrCodeText"));
        healthCardInfoVO.setHealthCardId(jsonObject.getString("healthCardId"));
        healthCardInfoVO.setPhid(jsonObject.getString("phid"));
        // HealthCardInfo hInfo = healthCard.registerHealthCard(commonIn,healthCardInfoR);
        //System.out.println("腾讯返回===================>"+hInfo.getPhid());
        //BeanUtils.copyProperties(hInfo,healthCardInfoVO);
        System.out.println("属性拷贝后===================>"+healthCardInfoVO.getPhid());
        return healthCardInfoVO;
    }


    @Override
    public HealthCardInfoVO getHealthCardByHealthCode(String hospitalId, String healthCode) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId(),0);
        HealthCardInfo hInfo = healthCard.getHealthCardByHealthCode(commonIn,healthCode).getJSONObject("card").toJavaObject(HealthCardInfo.class);
        HealthCardInfoVO healthCardInfoVO = new HealthCardInfoVO();
        BeanUtils.copyProperties(hInfo,healthCardInfoVO);
        /************************************************************/
        healthCardInfoVO.setWechatCode(settings.getWechatCode());
        /************************************************************/
        return healthCardInfoVO;
    }

    @Override
    public HealthCardInfoVO getHealthCardByQRCode(String hospitalId, String qrCodeText) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId(),0);
        HealthCardInfo hInfo = healthCard.getHealthCardByQRCode(commonIn,qrCodeText).getJSONObject("card").toJavaObject(HealthCardInfo.class);
        HealthCardInfoVO healthCardInfoVO = new HealthCardInfoVO();
        BeanUtils.copyProperties(hInfo,healthCardInfoVO);
        /************************************************************/
        healthCardInfoVO.setWechatCode(settings.getWechatCode());
        /************************************************************/
        return healthCardInfoVO;
    }


    @Override
    public Boolean bindCardRelation(String hospitalId, String patId, String qrCodeText) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId(),0);
        return healthCard.bindCardRelation(commonIn,patId,qrCodeText).getBoolean("result");
    }



    @Override
    public void reportHISData(String hospitalId, ReportHISDataVO reportHISData) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId(),0);
        ReportHISData reportHIS = new ReportHISData();
        BeanUtils.copyProperties(reportHISData,reportHIS);
        healthCard.reportHISData(commonIn,reportHIS);
    }


    @Override
    public String getOrderIdByOutAppId(String hospitalId, String qrCodeText) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        String appId = settings.getAppid();
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId(),0);
        return healthCard.getOrderIdByOutAppId(commonIn,appId,qrCodeText).getString("orderId");
    }




    @Override
    public List<HealthCardInfo> registerBatchHealthCard(String hospitalId, List<HealthCardInfo> healthCardInfos) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        HealthCardClientServiceImpl  healthCardService = new HealthCardClientServiceImpl(settings.getAppSecret());
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId(),0);
        List<HealthCardInfo> infoList = healthCardService.registerBatchHealthCard(commonIn,healthCardInfos).getJSONArray("rspItems").toJavaList(HealthCardInfo.class);
        Map<String, HealthCardInfo> infoMap = new HashMap();
        Iterator iterator = infoList.iterator();

        HealthCardInfo healthCard;
        while(iterator.hasNext()) {
            healthCard = (HealthCardInfo)iterator.next();
            infoMap.put(healthCard.getIdNumber(), healthCard);
        }

        iterator = healthCardInfos.iterator();

        while(iterator.hasNext()) {
            healthCard = (HealthCardInfo)iterator.next();
            HealthCardInfo cardInfo = (HealthCardInfo)infoMap.get(healthCard.getIdNumber());
            if (cardInfo != null) {
                healthCard.setHealthCardId(cardInfo.getHealthCardId());
                healthCard.setQrCodeText(cardInfo.getQrCodeText());
            } else {
                iterator.remove();
            }
        }

        return healthCardInfos;
    }


    @Override
    public DynamicQRCodeVO getDynamicQRCode(String hospitalId, String healthCardId, String idType, String idNumber) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId(),0);
        DynamicQRCode dynamicQRCode = healthCard.getDynamicQRCode(commonIn,healthCardId,idType,idNumber,"0").toJavaObject(DynamicQRCode.class);
        DynamicQRCodeVO dynamicQRCodeVO = new DynamicQRCodeVO();
        BeanUtils.copyProperties(dynamicQRCode,dynamicQRCodeVO);
        System.out.println("**************************QrCodeImg**********************************");
        System.out.println(dynamicQRCode.getQrCodeImg());
        System.out.println("**************************QrCodeImg**********************************");
        return dynamicQRCodeVO;
    }
}
