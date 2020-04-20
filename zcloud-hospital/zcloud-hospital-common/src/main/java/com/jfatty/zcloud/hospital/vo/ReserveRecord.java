package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述 预约记录
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */
@Data
public class ReserveRecord implements Serializable {


    /**
     * 预约号
     */
    private String yyh ;
    /**
     * 预约日期
     */
    private String yyrq ;
    /**
     * 团队标志
     */
    private String tdbz ;
    /**
     * 预约单位 团队名称
     */
    private String yydw ;
    /**
     * 预约人数
     */
    private Integer yyrs ;

    /**
     * 客户名称
     */
    private String khmc ;

    /**
     * 联系人
     */
    private String lxr ;

    /**
     * 联系方式
     */
    private String lxfs ;
    /**
     * 联系地址
     */
    private String lxdz ;
    /**
     * 预约状态
     */
    private String yyzt ;
    /**
     * 处理状态
     */
    private String clzt  ;
    /**
     * 备注
     */
    private String beizhu = "";
    /**
     * 操作员
     */
    private String czy  ;
    /**
     * 记录时间
     */
    private String jlsj ;
    /**
     * 人均预算
     */
    private String rjys ;

    /**
     * 预约套餐
     */
    private String yytc = "" ;
    /**
     * 套餐名称
     */
    private String tcmc = "" ;
    /**
     * 身份证号
     */
    private String sfzh = "" ;
    /**
     * 婚姻状况
     */
    private String hyzk = "" ;

}
