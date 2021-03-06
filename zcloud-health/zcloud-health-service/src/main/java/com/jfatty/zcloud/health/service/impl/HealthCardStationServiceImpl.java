package com.jfatty.zcloud.health.service.impl;

import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.mapper.HealthCardSettingsMapper;
import com.jfatty.zcloud.health.req.HCSHealthCardInfoReq;
import com.jfatty.zcloud.health.service.HealthCardStationService;
import com.jfatty.zcloud.health.vo.DynamicQRCodeVO;
import com.jfatty.zcloud.health.vo.HCSIDCardInfoVO;
import com.jfatty.zcloud.health.vo.HealthCardInfoVO;
import com.jfatty.zcloud.health.vo.ReportHISDataVO;
import com.tencent.healthcard.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
            //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
            log.error("重新获取AppToken===> 请求Id [{}]",settings.getRequestId());
            HealthCardClientServiceImpl  healthCard = new HealthCardClientServiceImpl(settings.getAppSecret());
            CommonIn commonIn=new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
            //调用接口appId

            AppTokenInfo appTokenInfo = healthCard.getAppToken(commonIn,appId);
            log.error("重新获取AppToken===> 卡平台返回AppToken [{}]",appTokenInfo.getAppToken());
            //打印响应
            settings.setAppToken(appTokenInfo.getAppToken());
            settings.setExpiresIn(appTokenInfo.getExpiresIn());
            settings.setUpdateTime(LocalDateTime.now());
            //
            Long expiresIn = timestamp +  new Long((long)appTokenInfo.getExpiresIn() * 1000) - 60000;
            LocalDateTime expireTime = LocalDateTime.ofEpochSecond(expiresIn/1000,0,ZoneOffset.ofHours(8));
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
        HealthCardClientServiceImpl  healthCard = new HealthCardClientServiceImpl(settings.getAppSecret());
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        //创建【公共输入参数commonIn】实例
        CommonIn commonIn = new CommonIn(settings.getAppToken(), settings.getRequestId(), settings.getHospitalId());
        IDCardInfo idCardInfo = healthCard.ocrInfo(commonIn,imageContent);
        log.error("orc身份证图片数据获取 [{}]",idCardInfo.getId());
        HCSIDCardInfoVO hcsidCardInfoVO = new HCSIDCardInfoVO();
        BeanUtils.copyProperties(idCardInfo,hcsidCardInfoVO);
        return hcsidCardInfoVO;
    }


    @Override
    public HealthCardInfoVO registerHealthCard(String hospitalId, HCSHealthCardInfoReq hcsHealthCardInfoReq) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);

        HealthCardClientServiceImpl  healthCard = new HealthCardClientServiceImpl(settings.getAppSecret());
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        com.jfatty.zcloud.health.model.HealthCardInfo  healthCardInfoR = new com.jfatty.zcloud.health.model.HealthCardInfo ();
        BeanUtils.copyProperties(hcsHealthCardInfoReq,healthCardInfoR);
        /************************************************************/
        healthCardInfoR.setWechatCode(settings.getWechatCode());
        /************************************************************/
        com.jfatty.zcloud.health.model.HealthCardInfo  hInfo = healthCard.registerHealthCard(commonIn,healthCardInfoR);
        System.out.println("腾讯返回===================>"+hInfo.getPhid());
        HealthCardInfoVO healthCardInfoVO = new HealthCardInfoVO();
        BeanUtils.copyProperties(hInfo,healthCardInfoVO);
        System.out.println("属性拷贝后===================>"+healthCardInfoVO.getPhid());
        return healthCardInfoVO;
    }

    @Override
    public HealthCardInfoVO getHealthCardByHealthCode(String hospitalId, String healthCode) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        HealthCardClientServiceImpl  healthCard = new HealthCardClientServiceImpl(settings.getAppSecret());
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        com.jfatty.zcloud.health.model.HealthCardInfo hInfo = healthCard.getHealthCardByHealthCode(commonIn,healthCode);
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
        HealthCardClientServiceImpl  healthCard = new HealthCardClientServiceImpl(settings.getAppSecret());
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        com.jfatty.zcloud.health.model.HealthCardInfo hInfo = healthCard.getHealthCardByQRCode(commonIn,qrCodeText);
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
        HealthCardClientServiceImpl  healthCard = new HealthCardClientServiceImpl(settings.getAppSecret());
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        return healthCard.bindCardRelation(commonIn,patId,qrCodeText).getBoolean("result");
    }

    @Override
    public void reportHISData(String hospitalId, ReportHISDataVO reportHISData) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        HealthCardClientServiceImpl  healthCard = new HealthCardClientServiceImpl(settings.getAppSecret());
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        //ReportHISData reportHIS = new ReportHISData();
        //BeanUtils.copyProperties(reportHISData,reportHIS);
        //healthCard.reportHISData(commonIn,reportHIS);
        healthCard.reportHISData(commonIn,reportHISData);
    }

    @Override
    public String getOrderIdByOutAppId(String hospitalId, String qrCodeText) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        String appId = settings.getAppid();
        HealthCardClientServiceImpl  healthCard = new HealthCardClientServiceImpl(settings.getAppSecret());
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        return healthCard.getOrderIdByOutAppId(commonIn,appId,qrCodeText);
    }

    @Override
    public List<com.jfatty.zcloud.health.model.HealthCardInfo> registerBatchHealthCard(String hospitalId, List<com.jfatty.zcloud.health.model.HealthCardInfo> healthCardInfos) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        HealthCardClientServiceImpl  healthCard = new HealthCardClientServiceImpl(settings.getAppSecret());
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        return healthCard.registerBatchHealthCard(commonIn,healthCardInfos);
    }

    @Override
    public DynamicQRCodeVO getDynamicQRCode(String hospitalId, String healthCardId, String idType, String idNumber) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        HealthCardClientServiceImpl  healthCard = new HealthCardClientServiceImpl(settings.getAppSecret());
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        DynamicQRCode dynamicQRCode = healthCard.getDynamicQRCode(commonIn,healthCardId,idType,idNumber);
        DynamicQRCodeVO dynamicQRCodeVO = new DynamicQRCodeVO();
        BeanUtils.copyProperties(dynamicQRCode,dynamicQRCodeVO);
        //System.out.println("**************************QrCodeImg**********************************");
        //System.out.println(dynamicQRCode.getQrCodeImg());
        //System.out.println("**************************QrCodeImg**********************************");
        return dynamicQRCodeVO;
    }

    @Override
    public DynamicQRCodeVO getDynamicQRCode(String hospitalId, String healthCardId, String idType, String idNumber, String codeType) throws Exception {
        HealthCardSettings settings =  getAppTokenHealthCardSettings(hospitalId);
        HealthCardClientServiceImpl  healthCard = new HealthCardClientServiceImpl(settings.getAppSecret());
        CommonIn commonIn = new CommonIn(settings.getAppToken(),settings.getRequestId(),settings.getHospitalId());
        com.jfatty.zcloud.health.model.DynamicQRCode  dynamicQRCode = healthCard.getDynamicQRCode(commonIn,healthCardId,idType,idNumber,codeType);
        DynamicQRCodeVO dynamicQRCodeVO = new DynamicQRCodeVO();
        BeanUtils.copyProperties(dynamicQRCode,dynamicQRCodeVO);
        return dynamicQRCodeVO;
    }
}
