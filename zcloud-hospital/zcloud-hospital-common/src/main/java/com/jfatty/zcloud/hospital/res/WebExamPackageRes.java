package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.WebExamPackageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "体检套餐列表响应实体")
public class WebExamPackageRes extends WebExamPackageDTO<WebExamPackageRes> {

    /**
     * 套餐ID
     */
    @ApiModelProperty(name = "tcid", position = 2,required = true, value = "套餐ID " , example = "141")
    private String tcid  ;

    /**
     * 套餐名称
     */
    @ApiModelProperty(name = "tcmc", position = 2,required = true, value = "套餐名称 " , example = "体检套餐A男")
    private String tcmc ;

    /**
     * 单价
     */
    @ApiModelProperty(name = "dj", position = 2,required = true, value = "单价 " , example = "500.00")
    private String dj ;
    /**
     * 性别
     */
    @ApiModelProperty(name = "xb", position = 2,required = true, value = "性别 " , example = "女")
    private String xb ;
    /**
     * 温馨提示
     */
    @ApiModelProperty(name = "wxts", position = 2, value = "温馨提示 " , example = "1、体检前一天晚上10点后，不进食和水  2、体检当日检前不要进食水也不要大小便")
    private String wxts = "";


}
