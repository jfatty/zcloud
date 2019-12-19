package com.jfatty.zcloud.hospital.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/12/17
 * @email jfatty@163.com
 */
@Accessors(chain = true)
@Data
public class ComplexPay implements Serializable {

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

    /***************费用类型**********************************************************/
    /**
     * 费用类型，挂号
     */
    public final static int FEE_TYPE_GH = 1;

    /**
     * 费用类型，门诊
     */
    public final static int FEE_TYPE_MZ = 2;

    /**
     * 费用类型，住院
     */
    public final static int FEE_TYPE_ZY = 3;

    /***************支付状态**********************************************************/
    /**
     * 支付状态，未知
     */
    public final static int PAY_STATE_UNNKNOWN = 0;

    /**
     * 支付状态，支付成功
     */
    public final static int PAY_STATE_SUCCESS = 1;

    /**
     * 支付状态，支付失败
     */
    public final static int PAY_STATE_FAILD = 2;

    /**
     * 支付状态，支付已经取消
     */
    public final static int PAY_STATE_CANCEL = 3;

    /**
     * 支付状态，已经退款（医院向用户退款）
     */
    public final static int PAY_STATE_REFIND = 4;

    /***************支付方式**********************************************************/
    /**
     * 支付方式， 微信支付
     */
    public final static int PAY_WAY_WECHAT = 2; // PAY_WAY_WECHAT = 19;

    /**
     * 支付方式，支付宝支付
     */
    public final static int PAY_WAY_ZFB = 1;//  PAY_WAY_ZFB =20;

    /**
     * 支付方式， 三方APP支付 建行
     */
    public final static int PAY_WAY_APP = 3;

    /***************与HIS系统同步状态********************************************************/
    /**
     * 支付结果没有和HIS系统同步
     */
    public final static int HIS_SYNC_NO = 0;

    /**
     * 支付结果已经与HIS系统同步
     */
    public final static int HIS_SYNC_YES = 1;

    /***************支付同步状态********************************************************/
    /**
     * 支付同步状态， 未异步回调修改支付状态
     */
    public final static int PAY_SYNC_NO = 0;

    /**
     * 支付同步状态， 已经异步回调修改支付状态
     */
    public final static int PAY_SYNC_YES = 1;
    /***************支付方向**********************************************************/
    /**
     * 支付方向， 用户向医院付款
     */
    public final static int PAY_ORIENTATION_FRONT = 1;

    /**
     * 支付方向， 医院向用户退款
     */
    public final static int PAY_ORIENTATION_BACK = 2;

}
