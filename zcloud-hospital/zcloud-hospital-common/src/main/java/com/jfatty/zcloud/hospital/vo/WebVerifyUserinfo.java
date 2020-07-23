package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 通过手机号验证人员信息
 *
 * @author jfatty on 2020/6/11
 * @email jfatty@163.com
 */
@Data
public class WebVerifyUserinfo extends BaseResponse {

    /**
     * 科室ID
     */
    private String ksid ;

    /**
     * 科室名称
     */
    private String ksmc ;

    /**
     * 人员id
     */
    private String ryid ;

    /**
     * 人员名称
     */
    private String rymc ;


}
