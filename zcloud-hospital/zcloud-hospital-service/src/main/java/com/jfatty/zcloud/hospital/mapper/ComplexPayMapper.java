package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/17
 * @email jfatty@163.com
 */
public interface ComplexPayMapper {


    /**
     * 查询住院预交与门诊缴费人员名单
     * @return
     */
    List<WebMission> getWebMissionList(@Param("openId") String openId, @Param("openIdType") Integer openIdType);

    /**
     * 描述 查询就诊人当前住院详情 就是之前已经缴费的详细信息
     * @author jfatty
     * 创建时间：2018年3月27日
     */
    InHospitalInfo getZYPre(Map<String,Object> map);

    /**
     * 调用存储过程 查询门诊缴费单详情 通过费用单号
     * @return
     */
    OutpatientDetail getWebmzDetail(@Param("openId") String openId, @Param("openIdType") Integer openIdType, @Param("fydh") String fydh);
    /**
     * 调用存储过程 查询就诊人待缴费单信息
     * @return
     */
    List<WebmzList> getWebmzList(@Param("openId") String openId, @Param("openIdType") Integer openIdType, @Param("djh")String djh);

    /**
     * 通过  outTradeNo 查询订单情况  jfatty 2017-11-19
     * @param outTradeNo
     * @return
     */
    ComplexPay getPayRecordByOutTradeNo(@Param("outTradeNo") String outTradeNo);

    /**
     * 根据 HIS系统中的 '唯一订单号' 和 支付类型 和 病人id  查询 最新的那一条支付记录
     * @param hisNo   HIS系统中的 '唯一订单号'
     * @param feeType 支付类型
     * @param brid      病人id
     * @param payWay  支付方式
     * @return
     */
    ComplexPay getLatestPayRecord(@Param("hisNo") String hisNo,@Param("feeType")  int feeType, @Param("payWay") int payWay,@Param("brid")  String brid);

    /**
     * 描述  本地系统支付系统数据存储成功之后调用存储过程通知his系统
     * @author jfatty
     * 创建时间：2018年3月27日
     * @param   openId 支付宝微信openId
     * @param   openIdType  openId类型 1表示支付宝2表示微信 openId
     * @param   outTradeNo  交易订单号
     * @param   brid  病人ID
     * @param   fydh  费用订单列表 传入时 用逗号拼接   HIS系统中的费用单号
     * @param   fkfs  付款方式
     * @param   ssje  实收金额
     * @param   ext1  扩展字段
     * @param   ext2  扩展字段
     * @param   ext3  扩展字段
     */
    SyncMZPay syncMZPay(@Param("openId") String openId, @Param("openIdType") Integer openIdType,@Param("outTradeNo") String outTradeNo,@Param("brid") String brid, //
                        @Param("fydh") String fydh, @Param("fkfs") Integer fkfs,@Param("ssje") String ssje,//
                        @Param("ext1")  String ext1,  @Param("ext2") String ext2,@Param("ext3") String ext3);

    /**
     * 记录HIS系统对账返回的情况  jfatty 2017-11-19
     * @param outTradeNo  本地系统唯一订单号
     * @param hisSync     同步情况
     * @param hisNo     his系统支付调用成功之后返回的费用号或者预缴号 jfatty
     */
    void syncHisFeeBack(@Param("outTradeNo")  String outTradeNo,@Param("hisSync")   int hisSync,@Param("hisNo")   String hisNo);

    /**
     * 描述 住院预缴 本地系统支付系统数据存储成功之后调用存储过程通知his系统
     * @author jfatty
     * 创建时间：2018年3月28日
     * @param   openId 支付宝微信openId
     * @param   openIdType  openId类型 1表示支付宝2表示微信 openId
     * @param   outTradeNo  交易订单号
     * @param   brid  病人ID
     * @param   zybh  住院编号   HIS系统中的住院编号
     * @param   fkfs  付款方式
     * @param   yjje  预缴金额
     * @param   ext1  扩展字段
     * @param   ext2  扩展字段
     * @param   ext3  扩展字段
     */
    SyncZYPay syncZYPay(@Param("openId") String openId, @Param("openIdType") Integer openIdType,@Param("outTradeNo") String outTradeNo,@Param("brid") String brid, //
                        @Param("zybh") String zybh, @Param("fkfs") Integer fkfs, @Param("yjje") String yjje,//
                        @Param("ext1")  String ext1,  @Param("ext2") String ext2,@Param("ext3") String ext3);

    /**
     * 记录HIS系统对账(住院预缴)返回的情况  jfatty 2017-11-19
     * @param outTradeNo   支付宝、微信订单号
     * @param hisSync      同步标志
     * @param yjh          预缴号
     */
    void syncHisInHospitalFeeBack(@Param("outTradeNo") String outTradeNo,@Param("hisSync")  int hisSync,@Param("yjh")   String yjh);

    /**
     * 向数据库订单表中插入订单信息
     * @param complexPay
     */
    void saveOrderRecord(ComplexPay complexPay);

    /**
     * 异步通知，改变状态
     * @param complexPayOrder
     */
    void payAsync(ComplexPay complexPayOrder);
}
