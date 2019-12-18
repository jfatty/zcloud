package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.WebPriceinfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "物价查询响应实体")
public class WebPriceinfoRes extends WebPriceinfoDTO<WebPriceinfoRes> {

    /**
     * 类别
     */
    @ApiModelProperty(name = "lb", position = 2,required = true, value = "类别" , example = "药品")
    private String lb ;
    /**
     * 别名
     */
    @ApiModelProperty(name = "bm", position = 2,required = true, value = "别名" , example = "PPT")
    private String bm ;
    /**
     * 名称
     */
    @ApiModelProperty(name = "mc", position = 2,required = true, value = "名称" , example = "葡萄糖")
    private String mc ;
    /**
     * 规格
     */
    @ApiModelProperty(name = "gg", position = 2,required = true, value = "12粒/盒" , example = "规格")
    private String gg = "";
    /**
     * 单位
     */
    @ApiModelProperty(name = "dw", position = 2,required = true, value = "单位" , example = "单位")
    private String dw = "";
    /**
     * 单价
     */
    @ApiModelProperty(name = "dj", position = 2,required = true, value = "12元/盒" , example = "单价")
    private String dj = "";
    /**
     *费用类别
     */
    @ApiModelProperty(name = "fylb", position = 2,required = true, value = "费用类别" , example = "西药费")
    private String fylb ;
//    /**
//     * 分类名称
//     */
//    @ApiModelProperty(name = "flmc", position = 2,required = true, value = "分类名称" , example = "药品")
//    private String flmc ;
//    /**
//     * 项目别名
//     */
//    @ApiModelProperty(name = "xmbm", position = 2,required = true, value = "项目别名" , example = "PPT")
//    private String xmbm ;
//    /**
//     * 项目名称
//     */
//    @ApiModelProperty(name = "xmmc", position = 2,required = true, value = "项目名称" , example = "葡萄糖")
//    private String xmmc ;

}
