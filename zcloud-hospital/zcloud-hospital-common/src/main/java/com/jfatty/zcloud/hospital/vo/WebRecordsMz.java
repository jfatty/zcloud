package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 病人门诊记录查询
 *
 * @author jfatty on 2020/6/11
 * @email jfatty@163.com
 */
@Data
public class WebRecordsMz  extends BaseResponse {

    /**
     * 病人ID
     */
    private String brid ;

    /**
     * 就诊号
     */
    private String jzh ;

    /**
     * 就诊科室ID
     */
    private String jzks ;

    /**
     * 就诊科室名称
     */
    private String jzksmc ;

    /**
     * 就诊日期
     */
    private String jzrq ;

}
