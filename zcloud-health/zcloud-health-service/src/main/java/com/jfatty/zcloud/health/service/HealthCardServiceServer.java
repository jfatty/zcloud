package com.jfatty.zcloud.health.service;

import com.tencent.healthcard.model.*;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/1/4
 * @email jfatty@163.com
 */
public interface HealthCardServiceServer {

    AppTokenInfo getAppToken(CommonIn var1, String var2);

    com.jfatty.zcloud.health.model.HealthCardInfo  registerHealthCard(CommonIn var1, com.jfatty.zcloud.health.model.HealthCardInfo  var2);

    com.jfatty.zcloud.health.model.HealthCardInfo  getHealthCardByHealthCode(CommonIn var1, String var2);

    com.jfatty.zcloud.health.model.HealthCardInfo  getHealthCardByQRCode(CommonIn var1, String var2);

    IDCardInfo ocrInfo(CommonIn var1, String var2);

    Boolean bindCardRelation(CommonIn var1, String var2, String var3);

    List<BindResultInfo> bindUnionId(CommonIn var1, String var2, List<String> var3);

    void reportHISData(CommonIn var1, ReportHISData var2);

    void recvPushMsg(CommonIn var1, PushMsg var2);

    String getOrderIdByOutAppId(CommonIn var1, String var2, String var3);

    List<com.jfatty.zcloud.health.model.HealthCardInfo > registerBatchHealthCard(CommonIn var1, List<com.jfatty.zcloud.health.model.HealthCardInfo > var2);

    DynamicQRCode getDynamicQRCode(CommonIn var1, String var2, String var3, String var4);

    VerifyQRCodeResult verifyQRCode(CommonIn var1, VerifyQRCodeInfo var2);

    public interface URL {
        String GET_ACCESS_TOKEN = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenAuth/AuthObj/getAppToken";
        String REGISTER_HEALTH_CARD = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/registerHealthCard";
        String GET_HEALTH_CARD_BY_HEALTH_CODE = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/getHealthCardByHealthCode";
        String GET_HEALTH_CARD_BY_QR_CODE = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/getHealthCardByQRCode";
        String OCR_INFO = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/ocrInfo";
        String BIND_CARD_RELATION = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/bindCardRelation";
        String BIND_UNION_ID = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/bindUnionId";
        String REPORT_HISDATA = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/reportHISData";
        String RECV_PUSH_MSG = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/recvPushMsg";
        String GET_ORDER_ID_BY_OUT_APP_ID = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/getOrderIdByOutAppId";
        String REGISTER_BATCH_HEALTH_CARD = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/registerBatchHealthCard";
        String GET_DYNAMIC_QRCODE = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/getDynamicQRCode";
        String VERIFY_QRCODE = "https://p-healthopen.tengmed.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/verifyQRCode";
    }
}
