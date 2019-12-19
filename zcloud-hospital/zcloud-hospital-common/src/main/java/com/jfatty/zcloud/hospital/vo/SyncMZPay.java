package com.jfatty.zcloud.hospital.vo;


import lombok.Data;

/**
 * 描述 门诊缴费异步对账通知
 * @author jfatty on 2019/4/17
 * @email jfatty@163.com
 */
@Data
public class SyncMZPay extends BaseResponse {

    /**
     * 收费号
     * HIS系统中已经缴费的标志没有缴费的情况下是没有收费号的
     */
    private String sfh ;
    /**
     * 挂号ID
     */
    private String ghid ;
    /**
     * 支付金额
     */
    private String zfje ;

    /**
     *
     * 扩展字段Ext1  有返回信息
     *
     */


}