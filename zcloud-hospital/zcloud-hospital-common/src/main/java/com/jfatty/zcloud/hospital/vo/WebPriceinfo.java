package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 物价查询返回实体信息
 * @author jfatty on 2019/4/17
 * @email jfatty@163.com
 */
@Data
public class WebPriceinfo extends BaseResponse {

    /**
     * 类别
     */
    private String lb ;
    /**
     * 别名
     */
    private String bm ;
    /**
     * 名称
     */
    private String mc ;
    /**
     * 规格
     */
    private String gg ;
    /**
     * 单位
     */
    private String dw ;
    /**
     * 定价
     */
    private String dj ;
    /**
     *费用类别
     */
    private String fylb ;
    /**
     * 分类名称
     */
    private String flmc ;
    /**
     * 项目别名
     */
    private String xmbm ;
    /**
     * 项目名称
     */
    private String xmmc ;

}
