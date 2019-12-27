package com.jfatty.zcloud.health.service;

import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.req.HCSHealthCardInfoReq;
import com.jfatty.zcloud.health.vo.DynamicQRCodeVO;
import com.jfatty.zcloud.health.vo.HCSIDCardInfoVO;
import com.jfatty.zcloud.health.vo.HealthCardInfoVO;
import com.jfatty.zcloud.health.vo.ReportHISDataVO;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
public interface HealthCardStationService extends BaseHealthService<HealthCardSettings> {

    /**
     * 3.2.2 注册健康卡接口
     * @param appId
     * @param hcsHealthCardInfoReq
     * @return
     * @throws Exception
     */
    HealthCardInfoVO registerHealthCard(String appId, HCSHealthCardInfoReq hcsHealthCardInfoReq) throws Exception ;

    /**
     * 3.2.3 通过健康卡授权码获取接口
     * @param appId
     * @param healthCode
     * @return
     * @throws Exception
     */
    HealthCardInfoVO getHealthCardByHealthCode(String appId, String healthCode) throws Exception ;

    /**
     * 3.2.4 通过健康卡二维码获取接口
     * @param appId
     * @param qrCodeText
     * @return
     * @throws Exception
     */
    HealthCardInfoVO getHealthCardByQRCode(String appId, String qrCodeText) throws Exception ;

    /**
     * 3.2.5 OCROCR 接口
     * @param appId
     * @param imageContent
     * @return
     * @throws Exception
     */
    HCSIDCardInfoVO ocrInfo(String appId,String imageContent) throws Exception ;

    /**
     * 3.2.6 绑定健康卡和院内 ID 关系接口
     * @param appId
     * @param patId
     * @param qrCodeText
     * @return
     * @throws Exception
     */
    Boolean bindCardRelation(String appId, String patId, String qrCodeText) throws Exception ;

    /**
     * 3.2.7 用卡数据监测接口
     * @param appId
     * @param reportHISData
     * @throws Exception
     */
    void reportHISData(String appId, ReportHISDataVO reportHISData) throws Exception ;

    /**
     * 3.2.8 获取卡包订单  ID接口
     * @param appId
     * @param qrCodeText
     * @return
     * @throws Exception
     */
    String getOrderIdByOutAppId(String appId, String qrCodeText) throws Exception ;

    /**
     * 3.2.9 注册批量健康卡接口
     * @param appId
     * @param healthCardInfos
     * @return
     * @throws Exception
     */
    List<HealthCardInfoVO> registerBatchHealthCard(String appId, List<HealthCardInfoVO> healthCardInfos) throws Exception ;

    /**
     * 3.2.10 获取动态二维码接口
     * @param appId
     * @param healthCardId
     * @param idType
     * @param idNumber
     * @return
     * @throws Exception
     */
    DynamicQRCodeVO getDynamicQRCode(String appId, String healthCardId, String idType, String idNumber) throws Exception ;


}
