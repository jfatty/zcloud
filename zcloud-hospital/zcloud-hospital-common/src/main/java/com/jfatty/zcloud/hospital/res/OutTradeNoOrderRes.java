package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.OutTradeNoOrderDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "交易订单支付信息响应实体")
public class OutTradeNoOrderRes extends OutTradeNoOrderDTO<OutTradeNoOrderRes> {

    @ApiModelProperty(name = "xh", position = 2,required = true, value = "序号 " , example = "3")
    protected Long id;
    @ApiModelProperty(name = "openId", position = 2,required = true, value = "openId " , example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId;                                                          //用户openId
    @ApiModelProperty(name = "patientId", position = 2,required = true, value = "就诊人id " , example = "3626")
    private Long patientId;                                                         //就诊人id
    @ApiModelProperty(name = "hisNo", position = 2,required = true, value = "his系统中的单号 " , example = "sss2225")
    private String hisNo;                                                           //his系统中的单号
    @ApiModelProperty(name = "feeName", position = 2,required = true, value = "费用名称 " , example = "门症费用")
    private String feeName;                                                         //费用名称
    @ApiModelProperty(name = "feeAmount", position = 2,required = true, value = "费用金额 " , example = "200.23")
    private String feeAmount;                                                       //费用金额
    @ApiModelProperty(name = "outTradeNo", position = 2,required = true, value = "户订单号 " , example = "DDD66666633366")
    private String outTradeNo;                                                      //商户订单号
    @ApiModelProperty(name = "tradeNo", position = 2,required = true, value = "微信、支付宝订单号 " , example = "WX2025255222")
    private String tradeNo;                                                         //微信、支付宝订单号
    @ApiModelProperty(name = "payOrientation", position = 2,required = true, value = "支付方向 " , example = "付款")
    private Integer payOrientation;                                                 //支付方向， 付款 或者 退款
    @ApiModelProperty(name = "payState", position = 2,required = true, value = "支付状态 " , example = "支付成功")
    private Integer payState;                                                       //支付状态  支付成功 或者 失败 或者已经关闭
    @ApiModelProperty(name = "buyerAccount", position = 2,required = true, value = "买家账号 " , example = "222")
    private String buyerAccount;                                                    //买家账号
    @ApiModelProperty(name = "sellerAccount", position = 2,required = true, value = "卖家账号 " , example = "111")
    private String sellerAccount;                                                   //卖家账号
    @ApiModelProperty(name = "remark", position = 2,required = true, value = "备注 " , example = "备注")
    private String remark;                                                          //备注
    @ApiModelProperty(name = "hisSign", position = 2,required = true, value = "HIS系统  定时任务同步时 " , example = "前时间的毫秒数  + 序列")
    private Long hisSign;                                                           //HIS系统  定时任务同步时 查询保存的标志（建议以当前时间的毫秒数  + 序列， 以防止重复）
    @ApiModelProperty(name = "wtSign", position = 2,required = true, value = "微信、支付保 定时任务同步时 查询保存的标志 " , example = "毫秒数  + 序列")
    private Long wtSign;                                                            //微信、支付保 定时任务同步时 查询保存的标志（建议以当前时间的毫秒数  + 序列， 以防止重复）
    /**
     * add jfatty
     * his流水号
     * 存在逗号拼接的情况
     * 180328000005,180328000006,180328000007,180328000008,180328000009,180328000010,180328000011,180328000012
     * 与his的约定
     */
    @ApiModelProperty(name = "djh", position = 2,required = true, value = "流水号 " , example = "180328000005,180328000006,180328000007,180328000008,180328000009,180328000010,180328000011,180328000012")
    private String djh ;
    /**
     * add time 20190909
     * 就诊号
     */
    @ApiModelProperty(name = "jzh", position = 2,required = true, value = "就诊号 " , example = "20190909")
    private String jzh = "" ;

    @ApiModelProperty(name = "name", position = 2,required = true, value = "姓名 " , example = "张三")
    private String name ;

    @ApiModelProperty(name = "idCard", position = 2,required = true, value = "身份证号 " , example = "422802558585")
    private String idCard ;

    @ApiModelProperty(name = "createdTime", position = 2,required = true, value = "订单创建时间 " , example = "2020-01-11 15:30")
    private String createdTime ;

}
