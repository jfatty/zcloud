package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 病人住院记录查询
 *
 * @author jfatty on 2020/6/11
 * @email jfatty@163.com
 */
@Data
public class WebRecordsZy extends BaseResponse {

    /**
     * 病人ID
     */
    private String brid ;

    /**
     * 就诊号
     */
    private String jzh ;

    /**
     * 手术标志 0 表示未手术1表示已手术
     */
    private String ssbz ;

    /**
     * 出院科室ID
     */
    private String cyks ;

    /**
     * 出院科室名称
     */
    private String  cyksmc ;

    /**
     * 住院时间
     */
    private String beginHosTime ;

    /**
     * 出院时间
     */
    private String endHosTime ;

    /**
     * 住院天数
     */
    private Integer zyts ;

    /**
     * 出院后三天时间节点
     */
    private String otherHosTime ;

}
