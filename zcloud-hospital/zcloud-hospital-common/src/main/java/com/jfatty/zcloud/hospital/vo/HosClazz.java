package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 医院工作班次
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
public class HosClazz extends BaseResponse {

    /**
     * 班次ID
     */
    private String bcid ;
    /**
     * 班次名称
     */
    private String bcmc ;
    /**
     * 开始时间
     */
    private String kssj ;
    /**
     * 结束时间
     */
    private String jssj ;
}
