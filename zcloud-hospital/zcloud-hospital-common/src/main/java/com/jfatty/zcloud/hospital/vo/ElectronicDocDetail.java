package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 我的服务单门诊缴费详情
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class ElectronicDocDetail extends BaseResponse {

    /**
     * 挂号id
     */
    private String ghid ;

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
     * 科室id
     */
    private String ksid ;

    /**
     * 科室名称
     */
    private String ksmc ;

    /**
     * 收费号
     */
    private String sfh ;

    /**
     * 收费日期
     */
    private String sfrq ;

    /**
     * 收费分类ID
     */
    private String sfflid ;

    /**
     * 收费分类名称
     */
    private String sfflmc ;

    /**
     * 收费项目id
     */
    private String sfxmid ;

    /**
     * 收费项目名称
     */
    private String sfxmmc ;

    /**
     * 金额
     */
    private String je ;

    /**
     * 执行科室id
     */
    private String zxksid ;
    /**
     * 执行科室名称
     */
    private String zxksmc ;
    /**
     * 状态
     */
    private String zt = "";

}
