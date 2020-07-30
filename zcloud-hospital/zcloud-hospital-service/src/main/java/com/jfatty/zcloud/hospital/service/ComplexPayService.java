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
    List<OutpatientDetail> getWebmzDetail(String openId, Integer openIdType, String fydh);

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

    /**
     * 根据 HIS系统中的 '唯一订单号' 和 支付类型 和 病人id  查询 最新的那一条支付记录
     * @param hisNo   HIS系统中的 '唯一订单号'
     * @param feeType 支付类型
     * @param brid      病人id
     * @param payWay  支付方式
     * @param payChannel  支付渠道
     * @return
     */
    ComplexPay getLatestPayRecord(String hisNo, int feeType, String brid, int payWay,int payChannel);

    /**
     * 描述 门诊缴费 本地系统支付系统数据存储成功之后调用存储过程通知his系统
     * @author jfatty 创建时间：2018年3月27日
     * @param openId 支付宝微信openId
     * @param openIdType openId类型 1表示支付宝2表示微信 openId
     * @param outTradeNo 交易订单号
     * @param brid 病人ID
     * @param fydh 费用订单列表 传入时 用逗号拼接 HIS系统中的费用单号
     * @param fkfs 付款方式
     * @param ssje 实收金额
     * @param ext1 扩展字段
     * @param ext2 扩展字段
     * @param ext3 扩展字段
     */
    SyncMZPay syncMZPay(String openId, Integer openIdType, String outTradeNo, String brid, String fydh, Integer fkfs, String ssje, String ext1, String ext2, String ext3) throws Exception ;

    /**
     * 记录HIS系统对账返回的情况  jfatty 2017-11-19
     * @param outTradeNo  本地系统唯一订单号
     * @param hisSync     同步情况
     */
    void syncHisFeeBack(String outTradeNo, int hisSync, String hisNo) throws Exception ;

    /**
     * 描述 住院预缴 本地系统支付系统数据存储成功之后调用存储过程通知his系统
     * @author jfatty 创建时间：2018年3月28日
     * @param openId 支付宝微信openId
     * @param openIdType  openId类型 1表示支付宝2表示微信 openId
     * @param outTradeNo 交易订单号
     * @param brid 病人ID
     * @param zybh 住院编号 HIS系统中的住院编号
     * @param fkfs 付款方式
     * @param yjje 预缴金额
     * @param ext1 扩展字段
     * @param ext2 扩展字段
     * @param ext3 扩展字段
     */
    SyncZYPay syncZYPay(String openId, Integer openIdType, String outTradeNo, String brid, String zybh, Integer fkfs, String yjje, String ext1, String ext2, String ext3) throws Exception ;

    /**
     * 记录HIS系统对账(住院预缴)返回的情况  jfatty 2017-11-19
     * @param outTradeNo   支付宝、微信订单号
     * @param hisSync      同步标志
     * @param yjh          预缴号
     */
    void syncHisInHospitalFeeBack(String outTradeNo, int hisSync, String yjh) throws Exception ;

    /**
     * 向数据库订单表中插入订单信息
     * @param complexPay
     * @throws Exception
     */
    void saveOrderRecord(ComplexPay complexPay) throws Exception ;

    void confirmAsyncStatus(String openId, Integer openIdType, ComplexPay lastPayOrder) throws Exception ;

    /**
     * 同步处理订单回调HIS
     * @param openId
     * @param openIdType
     * @param lastPayOrder
     * @throws Exception
     */
    void confirmSyncStatus(String openId, Integer openIdType, ComplexPay lastPayOrder) throws Exception ;

    /**
     * 异步通知，改变状态
     * @param complexPayOrder
     * @throws Exception
     */
    void payAsync(ComplexPay complexPayOrder) throws Exception ;
}
