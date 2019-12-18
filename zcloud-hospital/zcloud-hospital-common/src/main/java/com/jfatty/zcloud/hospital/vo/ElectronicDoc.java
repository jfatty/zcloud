package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class ElectronicDoc extends BaseResponse {

    /**
     * 病人编号
     */
    private String brbh ;
    /**
     * 姓名
     */
    private String xm ;
    /**
     * 身份证号
     */
    private String sfzh ;
    /**
     * 缴费类型
     */
    private String lx ;
    /**
     * 交易单号
     */
    private String jydh ;
    /**
     * 交易时间
     */
    private String jysj ;
    /**
     * 付款方式
     */
    private String fkfs ;
    /**
     * 金额
     */
    private String je ;
    /**
     * 2019-06-18 新增字段
     */
    private String sfh ;
}
