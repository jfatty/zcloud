package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 预约HIS返回
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
public class PreRegistered  extends BaseResponse {

    /**
     * 科室ID
     */
    private String ksid ;
    /**
     * 科室说明
     */
    private String ksmc ;
    /**
     * 科室位置
     */
    private String kswz ;
    /**
     * 预约号
     */
    private String yyh ;

    /**
     * 预约日期
     */
    private String yyrq ;

    /**
     * 预约医院
     */
    private String yyHos = "" ;

}
