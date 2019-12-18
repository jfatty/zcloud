package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 描述  获取门诊未缴费订单列表
 *
 * @author jfatty on 2019/4/15
 * @email jfatty@163.com
 */
@Data
public class WebmzList  extends BaseResponse {

    /**
     * 费用单号
     */
    private String fydh ;
    /**
     * 序号
     */
    private String xh ;
    /**
     * 科室名称
     */
    private String ksmc ;
    /**
     * 收费项目名称
     */
    private String sfxmmc ;

    /**
     * 金额
     */
    private String je ;
}