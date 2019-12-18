package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.vo.*;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/17
 * @email jfatty@163.com
 */
public interface ComplexPayService {

    /**
     * 描述 查询微信 支付宝用户绑定的有门诊缴费信息的病人 以及待缴费 信息
     * @param openId 微信支付宝openId
     * @param openIdType  微信支付宝openId类型
     * @return
     */
    List<WebMission> getWebMissionList(String openId, Integer openIdType);

    /**
     * 描述 查询就诊人当前住院详情 就是之前已经缴费的详细信息
     * @author jfatty 创建时间：2018年3月27日
     * @param djh 住院编号
     */
    InHospitalInfo getZYPre(String openId, Integer openIdType, String djh);

    /**
     * 调用存储过程 查询门诊缴费单详情 通过费用单号
     * @param openId 微信支付宝openId
     * @param openIdType 微信支付宝openId类型
     * @param fydh
     * @return
     */
    OutpatientDetail getWebmzDetail(String openId, Integer openIdType, String fydh);

    /**
     * 调用存储过程 查询就诊人待缴费单信息
     * @param openId 微信支付宝openId
     * @param openIdType 微信支付宝openId类型
     * @param djh 流水号
     * @return
     */
    List<WebmzList> getWebmzList(String openId, Integer openIdType, String djh);

    /**
     * 调用存储过程 获取门诊缴费 合计订单详情
     * @param openId 微信支付宝openId
     * @param openIdType  微信支付宝openId类型
     * @param djh 流水号
     * @param brid 病人ID
     * @return
     */
    TotalUnPayOutpatient getMZPay(String openId, Integer openIdType, String djh, String brid);

    /**
     * 通过  outTradeNo 查询订单情况  jfatty 2017-11-19
     * @param outTradeNo
     * @return
     */
    ComplexPay getPayRecordByOutTradeNo(String outTradeNo);
}
