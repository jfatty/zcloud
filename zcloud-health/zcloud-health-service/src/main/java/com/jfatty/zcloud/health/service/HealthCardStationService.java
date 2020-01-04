package com.jfatty.zcloud.health.service;

import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.req.HCSHealthCardInfoReq;
import com.jfatty.zcloud.health.vo.DynamicQRCodeVO;
import com.jfatty.zcloud.health.vo.HCSIDCardInfoVO;
import com.jfatty.zcloud.health.vo.HealthCardInfoVO;
import com.jfatty.zcloud.health.vo.ReportHISDataVO;
import com.jfatty.zcloud.health.model.HealthCardInfo;

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
     * @param hospitalId
     * @param hcsHealthCardInfoReq
     * @return
     * @throws Exception
     */
    HealthCardInfoVO registerHealthCard(String hospitalId, HCSHealthCardInfoReq hcsHealthCardInfoReq) throws Exception ;

    /**
     * 3.2.3 通过健康卡授权码获取接口
     * @param hospitalId
     * @param healthCode
     * @return
     * @throws Exception
     */
    HealthCardInfoVO getHealthCardByHealthCode(String hospitalId, String healthCode) throws Exception ;

    /**
     * 3.2.4 通过健康卡二维码获取接口
     * @param hospitalId
     * @param qrCodeText
     * @return
     * @throws Exception
     */
    HealthCardInfoVO getHealthCardByQRCode(String hospitalId, String qrCodeText) throws Exception ;

    /**
     * 3.2.5 OCROCR 接口
     * @param hospitalId
     * @param imageContent
     * @return
     * @throws Exception
     */
    HCSIDCardInfoVO ocrInfo(String hospitalId,String imageContent) throws Exception ;

    /**
     * 3.2.6 绑定健康卡和院内 ID 关系接口
     * @param hospitalId
     * @param patId
     * @param qrCodeText
     * @return
     * @throws Exception
     */
    Boolean bindCardRelation(String hospitalId, String patId, String qrCodeText) throws Exception ;

    /**
     * 3.2.7 用卡数据监测接口
     * @param hospitalId
     * @param reportHISData
     * @throws Exception
     */
    void reportHISData(String hospitalId, ReportHISDataVO reportHISData) throws Exception ;

    /**
     * 3.2.8 获取卡包订单  ID接口
     * @param hospitalId
     * @param qrCodeText
     * @return
     * @throws Exception
     */
    String getOrderIdByOutAppId(String hospitalId, String qrCodeText) throws Exception ;

    /**
     * 3.2.9 注册批量健康卡接口
     * @param hospitalId
     * @param healthCardInfos
     * @return
     * @throws Exception
     */
    List<HealthCardInfo> registerBatchHealthCard(String hospitalId, List<HealthCardInfo> healthCardInfos) throws Exception ;

    /**
     * 3.2.10 获取动态二维码接口
     * @param hospitalId
     * @param healthCardId
     * @param idType
     * @param idNumber
     * @return
     * @throws Exception
     */
    DynamicQRCodeVO getDynamicQRCode(String hospitalId, String healthCardId, String idType, String idNumber) throws Exception ;


}
