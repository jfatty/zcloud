package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 描述 智慧医疗交易订单
 *
 * @author jfatty on 2020/4/21
 * @email jfatty@163.com
 */
@Data
public class ComplexPayOrder extends Model<ComplexPayOrder> {

    protected Long id;
    protected String createdBy;
    protected Integer createdType;                                                    //操作人类型，2--微信用户， 1--支付宝用户，3--后台用户
    protected String updatedBy;
    protected String updatedType;                                                     //操作人类型，2--微信用户， 1--支付宝用户，3--后台用户
    protected String createdTime;
    protected String updatedTime;

    private String openId;                                                          //用户openId
    private Long patientId;                                                         //就诊人id
    private String hisNo;                                                           //his系统中的单号
    private String feeName;                                                         //费用名称
    private Integer feeType;                                                        //费用类型 门诊缴费、挂号缴费、住院预缴
    private String feeAmount;                                                       //费用金额
    private Integer payWay;                                                         //支付方式
    private String outTradeNo;                                                      //商户订单号
    private String tradeNo;                                                         //微信、支付宝订单号
    private Integer payOrientation;                                                 //支付方向， 付款 或者 退款
    private Integer async;                                                          //异步通知状态
    private String asyncTime;                                                       //异步通知时间(用户支付成功的时间)
    private Integer hisAsync;                                                       //支付结果同步到his系统的状态
    private String hisAsyncTime;                                                    //支付结果同步到his系统的时间
    private Integer payState;                                                       //支付状态  支付成功 或者 失败 或者已经关闭
    private String buyerAccount;                                                    //买家账号
    private String sellerAccount;                                                   //卖家账号
    private String remark;                                                          //备注
    private String payParam;                                                        //页面支付需要用到的信息，序列化后保存到数据库中
    private Long hisSign;                                                           //HIS系统  定时任务同步时 查询保存的标志（建议以当前时间的毫秒数  + 序列， 以防止重复）
    private Long wtSign;                                                            //微信、支付保 定时任务同步时 查询保存的标志（建议以当前时间的毫秒数  + 序列， 以防止重复）
    /**
     * add jfatty
     * his流水号
     * 存在逗号拼接的情况
     * 180328000005,180328000006,180328000007,180328000008,180328000009,180328000010,180328000011,180328000012
     * 与his的约定
     */
    private String djh ;
    /**
     * add time 20190909
     * 就诊号
     */
    private String jzh = "" ;

}
