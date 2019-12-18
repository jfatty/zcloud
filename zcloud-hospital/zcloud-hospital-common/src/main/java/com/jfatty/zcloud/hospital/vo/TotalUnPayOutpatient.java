package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

import java.io.Serializable;


/**
 * 描述 门诊缴费实体
 * @author jfatty on 2019/4/16
 * @email jfatty@163.com
 */
@Data
public class TotalUnPayOutpatient implements Serializable {

    /**
     * 费用单号
     * 费用订单列表 传入时 用逗号拼接   HIS系统中的费用单号
     */
    private String fydh;
    /**
     * 项目名称
     */
    private String xmmc;
    /**
     * 科室名称
     */
    private String ksmc;
    /**
     * 当前日期
     */
    private String dqrq;

    /**
     * 支付金额
     */
    private Double zfje;
    /**
     * 支付状态
     */
    private Integer payState;
    /**
     * his系统中的收费号
     */
    private String sfh;

    /**
     *
     * 扩展字段Ext1  有返回信息
     *
     */


}
