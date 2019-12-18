package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 *
 * @author jfatty
 * 创建时间：2018年11月05日
 * 描述  检验报告表头
 */
@Data
public class WebReportLisHead extends BaseResponse {

    /**
     *
     */
    private static final long serialVersionUID = -5181883438425054276L;
    /**
     * 病人编号
     */
    private String brbh ;
    /**
     * 姓名
     */
    private String xm ;
    /**
     * 性别
     */
    private String xb ;
    /**
     * 年龄
     */
    private String nl ;
    /**
     * 可是ID
     */
    private String ksid ;
    /**
     * 科室名称
     */
    private String ksmc ;
    /**
     * 床位号
     */
    private String cwh ;
    /**
     * 诊断
     */
    private String zd ;
    /**
     * 标本类型ID
     */
    private String bblxid ;
    /**
     * 标本类型名称
     */
    private String bblxmc ;
    /**
     * 送样时间
     */
    private String sysj ;
    /**
     *
     */
    private String bz ;
    /**
     *
     */
    private String sqsj ;
    /**
     * 采集时间
     */
    private String cjsj ;
    /**
     *
     */
    private String qssj ;
    /**
     *
     */
    private String sjys ;
    /**
     * 报告时间
     */
    private String bgsj ;
    /**
     *
     */
    private String jys ;
    /**
     * 审核人
     */
    private String shr ;
    /**
     * 审核人名称
     */
    private String shrmc ;
    /**
     * 审核人签名
     */
    private String shrqm ;
    /**
     *
     */
    private String jybh ;
    /**
     *
     */
    private String jyrq ;
    /**
     * 样本条形码
     */
    private String barcode ;

}
