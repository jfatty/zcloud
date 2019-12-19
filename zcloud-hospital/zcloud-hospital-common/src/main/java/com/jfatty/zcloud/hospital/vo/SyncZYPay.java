package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 住院预缴异步对账通知
 * @author jfatty on 2019/4/18
 * @email jfatty@163.com
 */
@Data
public class SyncZYPay extends BaseResponse {

    /**
     * 预缴号
     */
    private String yjh ;
    /**
     * 住院编号
     */
    private String zybh ;
    /**
     * 病人姓名
     */
    private String xm ;
    /**
     * 病人类型
     */
    private String brlx ;
    /**
     * 科室名称
     */
    private String ksmc ;
    /**
     * 床位号
     */
    private String cwh ;
    /**
     *
     */
    private String dqfyhj ;
    /**
     *
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