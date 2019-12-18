package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 住院预缴前期数据查询
 * @author jfatty on 2019/4/18
 * @email jfatty@163.com
 */
@Data
public class InHospitalInfo   extends BaseResponse {

    /**
     * 病人ID
     */
    private String bird ;
    /**
     * 病人姓名
     */
    private String xm ;
    /**
     * 病人身份证号码
     */
    private String sfzh ;
    /**
     * 住院编号
     */
    private String zybh ;
    /**
     * 性别
     */
    private String xb ;
    /**
     * 年龄
     */
    private String nl ;
    /**
     * 入院日期
     */
    private String ryrq ;
    /**
     * 住院天数
     */
    private String zyts ;
    /**
     * 病人类型
     */
    private String brlx ;
    /**
     * 病区
     */
    private String bq ;
    /**
     * 科室名称
     */
    private String ksmc ;
    /**
     * 床位号
     */
    private String cwh ;
    /**
     * 管床医生
     */
    private String gcys ;
    /**
     * 管床护士
     */
    private String gchs ;
    /**
     * 当前费用合计
     */
    private String dqfyhj;
    /**
     * 当前预缴合计
     */
    private String dqyjhj ;
    /**
     * 担保金额
     */
    private String dbje ;
    /**
     * 余额
     */
    private String ye ;

    /**
     *
     * 扩展字段Ext1  有返回信息
     *
     */

}
