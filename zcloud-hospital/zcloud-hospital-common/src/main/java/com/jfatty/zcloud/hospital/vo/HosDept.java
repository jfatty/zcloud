package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 医院预约科室信息
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
public class HosDept extends BaseResponse {

    /**
     * 科室ID
     */
    private String ksid ;
    /**
     * 科室说明
     */
    private String ksmc ;
    /**
     * 科室说明
     */
    private String kssm ;
    /**
     * 科室位置
     */
    private String kswz ;

}
