package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * @author jfatty
 * 创建时间：2018年11月05日
 * 描述  检查报告内容
 */
@Data
public class WebPacsReport extends BaseResponse {

    /**
     *
     */
    private static final long serialVersionUID = -1434124336950132183L;
    /**
     * 流水号
     */
    private String djh ;
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
     * 送检医生
     */
    private String sjys ;
    /**
     * 检查描述
     */
    private String jcms ;
    /**
     * 检查结论
     */
    private String jcjl ;
    /**
     *
     */
    private String jsys ;
    /**
     *
     */
    private String jsysmc ;
    /**
     * 检查医生名称
     */
    private String jcysqm ;
    /**
     * 检查日期
     */
    private String jcrq ;
    /**
     * 审核医生ID
     */
    private String shys ;
    /**
     * 审核医生名称
     */
    private String shysmc ;
    /**
     * 审核医生签名
     */
    private String shysqm ;
    /**
     * 审核日期
     */
    private String shrq ;

}
