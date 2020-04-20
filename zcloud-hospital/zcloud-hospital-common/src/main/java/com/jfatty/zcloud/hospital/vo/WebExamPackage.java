package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 体检中心套餐列表
 *
 * @author jfatty on 2019/4/30
 * @email jfatty@163.com
 */
@Data
public class WebExamPackage extends BaseResponse {

    /**
     * 套餐ID
     */
    private String tcid  ;

    /**
     * 套餐名称
     */
    private String tcmc ;

    /**
     * 单价
     */
    private String dj ;
    /**
     * 性别
     */
    private String xb ;
    /**
     * 温馨提示
     */
    private String wxts = "";

}
