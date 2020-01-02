package com.jfatty.zcloud.health.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tencent.healthcard.AbstractHealthCardServer;
import com.tencent.healthcard.model.*;
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
    public JSONObject getAppToken(CommonIn commonIn, String s) {
        return null;
    }

    @Override
    public JSONObject registerHealthCard(CommonIn commonIn, HealthCardInfo healthCardInfo) {
        return null;
    }

    @Override
    public JSONObject getHealthCardByHealthCode(CommonIn commonIn, String s) {
        return null;
    }

    @Override
    public JSONObject getHealthCardByQRCode(CommonIn commonIn, String s) {
        return null;
    }

    @Override
    public JSONObject ocrInfo(CommonIn commonIn, String s) {
        return null;
    }

    @Override
    public JSONObject bindCardRelation(CommonIn commonIn, String s, String s1) {
        return null;
    }

    @Override
    public JSONObject reportHISData(CommonIn commonIn, ReportHISData reportHISData) {
        return null;
    }

    @Override
    public JSONObject getOrderIdByOutAppId(CommonIn commonIn, String s, String s1) {
        return null;
    }

    @Override
    public JSONObject registerBatchHealthCard(CommonIn commonIn, List<HealthCardInfo> list) {
        return null;
    }

    @Override
    public JSONObject getDynamicQRCode(CommonIn commonIn, String s, String s1, String s2, String s3) {
        return null;
    }

    @Override
    public JSONObject verifyQRCode(CommonIn commonIn, VerifyQRCodeInfo verifyQRCodeInfo) {
        return null;
    }

    @Override
    public JSONObject registerOrder(CommonIn commonIn, String s, String s1) {
        return null;
    }

    @Override
    public JSONObject verifyFaceIdentity(CommonIn commonIn, String s, String s1) {
        return null;
    }

    @Override
    public JSONObject updateHealthCardId(CommonIn commonIn, List<HealthCardInfo> list) {
        return null;
    }
}
