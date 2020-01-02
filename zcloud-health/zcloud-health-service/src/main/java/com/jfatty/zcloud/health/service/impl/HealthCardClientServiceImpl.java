package com.jfatty.zcloud.health.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tencent.healthcard.AbstractHealthCardServer;
import com.tencent.healthcard.model.*;
import com.tencent.healthcard.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 描述
 *
 * @author jfatty on 2019/12/28
 * @email jfatty@163.com
 */
@Slf4j
public class HealthCardClientServiceImpl extends AbstractHealthCardServer {


    private String secret;


    public HealthCardClientServiceImpl() {
    }

    public HealthCardClientServiceImpl(String secret) {
        this.secret = secret;
    }




    @Override
    public AppTokenInfo getAppToken(CommonIn commonIn, String appId) {
        Map<String, Object> param = new TreeMap();
        param.put("appId", appId);
        String reqJson = CommonUtil.packParam(this.secret, commonIn, param);
        return (AppTokenInfo)this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenAuth/AuthObj/getAppToken", reqJson).toJavaObject(AppTokenInfo.class);
    }

    @Override
    public HealthCardInfo registerHealthCard(CommonIn commonIn, HealthCardInfo healthCardInfo) {
        String reqJson = CommonUtil.packParam(this.secret, commonIn, healthCardInfo);
        JSONObject jsonObject = this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/registerHealthCard", reqJson);
        healthCardInfo.setQrCodeText(jsonObject.getString("qrCodeText"));
        healthCardInfo.setHealthCardId(jsonObject.getString("healthCardId"));
        healthCardInfo.setPhid(jsonObject.getString("phid"));
        return healthCardInfo;
    }

    @Override
    public HealthCardInfo getHealthCardByHealthCode(CommonIn commonIn, String healthCode) {
        Map<String, Object> param = new TreeMap();
        param.put("healthCode", healthCode);
        String reqJson = CommonUtil.packParam(this.secret, commonIn, param);
        JSONObject cardObj = this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/getHealthCardByHealthCode", reqJson).getJSONObject("card");
        return (HealthCardInfo)cardObj.toJavaObject(HealthCardInfo.class);
    }

    @Override
    public HealthCardInfo getHealthCardByQRCode(CommonIn commonIn, String qrCodeText) {
        Map<String, Object> param = new TreeMap();
        param.put("qrCodeText", qrCodeText);
        String reqJson = CommonUtil.packParam(this.secret, commonIn, param);
        JSONObject cardObj = this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/getHealthCardByQRCode", reqJson).getJSONObject("card");
        return (HealthCardInfo)cardObj.toJavaObject(HealthCardInfo.class);
    }

    @Override
    public IDCardInfo ocrInfo(CommonIn commonIn, String imageContent) {
        Map<String, Object> param = new TreeMap();
        param.put("imageContent", imageContent);
        String reqJson = CommonUtil.packParam(this.secret, commonIn, param);
        JSONObject cardInfoObj = this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/ocrInfo", reqJson).getJSONObject("cardInfo");
        return (IDCardInfo)cardInfoObj.toJavaObject(IDCardInfo.class);
    }

    @Override
    public Boolean bindCardRelation(CommonIn commonIn, String patid, String qrCodeText) {
        Map<String, Object> param = new TreeMap();
        param.put("patid", patid);
        param.put("qrCodeText", qrCodeText);
        String reqJson = CommonUtil.packParam(this.secret, commonIn, param);
        return this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/bindCardRelation", reqJson).getBoolean("result");
    }

    @Override
    public List<BindResultInfo> bindUnionId(CommonIn commonIn, String weChatCode, List<String> qrCodeList) {
        Map<String, Object> param = new TreeMap();
        param.put("weChatCode", weChatCode);
        param.put("qrCodeList", qrCodeList);
        String reqJson = CommonUtil.packParam(this.secret, commonIn, param);
        return this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/bindUnionId", reqJson).getJSONArray("responseStatusList").toJavaList(BindResultInfo.class);
    }

    @Override
    public void reportHISData(CommonIn commonIn, ReportHISData reportHISData) {
        String reqJson = CommonUtil.packParam(this.secret, commonIn, reportHISData);
        this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/reportHISData", reqJson);
    }

    @Override
    public void recvPushMsg(CommonIn commonIn, PushMsg pushMsg) {
        String reqJson = CommonUtil.packParam(this.secret, commonIn, pushMsg);
        this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/recvPushMsg", reqJson);
    }

    @Override
    public String getOrderIdByOutAppId(CommonIn commonIn, String appId, String qrCodeText) {
        Map<String, Object> param = new TreeMap();
        param.put("appId", appId);
        param.put("qrCodeText", qrCodeText);
        String reqJson = CommonUtil.packParam(this.secret, commonIn, param);
        return this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/getOrderIdByOutAppId", reqJson).getString("orderId");
    }

    @Override
    public List<HealthCardInfo> registerBatchHealthCard(CommonIn commonIn, List<HealthCardInfo> healthCardInfos) {
        Map<String, Object> param = new TreeMap();
        param.put("healthCardInfos", healthCardInfos);
        String reqJson = CommonUtil.packParam(this.secret, commonIn, param);

        JSONObject obj = this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/registerBatchHealthCard", reqJson);
        System.out.println(obj.toJSONString());
        List<HealthCardInfo> infoList = obj.getJSONArray("rspItems").toJavaList(HealthCardInfo.class);
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
    public DynamicQRCode getDynamicQRCode(CommonIn commonIn, String healthCardId, String idType, String idNumber) {
        Map<String, Object> param = new TreeMap();
        param.put("healthCardId", healthCardId);
        param.put("idType", idType);
        param.put("idNumber", idNumber);
        String reqJson = CommonUtil.packParam(this.secret, commonIn, param);
        return (DynamicQRCode)this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/getDynamicQRCode", reqJson).toJavaObject(DynamicQRCode.class);
    }

    @Override
    public VerifyQRCodeResult verifyQRCode(CommonIn commonIn, VerifyQRCodeInfo verifyQRCodeInfo) {
        String reqJson = CommonUtil.packParam(this.secret, commonIn, verifyQRCodeInfo);
        return (VerifyQRCodeResult)this.request("https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/verifyQRCode", reqJson).toJavaObject(VerifyQRCodeResult.class);
    }
}
