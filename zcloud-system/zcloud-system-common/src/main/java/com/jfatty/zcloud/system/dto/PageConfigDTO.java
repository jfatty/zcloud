package com.jfatty.zcloud.system.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class PageConfigDTO<T extends BaseDTO> extends BaseDTO {
    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 应用ID APPID
     */
    @ApiModelProperty(name = "appid", position = 2,required = true, value = "微信  支付宝  APP appId" , example = "wx0725202a2fe5ffcf" )
    private String appid;
    /**
     * 页面标题
     */
    @ApiModelProperty(name = "title", value = "页面标题", required = true, position = 2, example = "门诊挂号")
    private String title;

    /**
     * 页面类型 数据字典 PC网页还是H5页面
     */
    @ApiModelProperty(name = "pype", value = "页面类型 PC网页还是H5页面", required = true, position = 2, example = "H5")
    private String pype;

    /**
     * 客户名称
     */
    @ApiModelProperty(name = "useClient", value = "客户名称", required = true, position = 2, example = "龙山县中医院")
    private String useClient;

    /**
     * 使用此页面的系统名称
     */
    @ApiModelProperty(name = "useSys", value = "使用此页面的系统名称", required = true, position = 2, example = "智慧医疗")
    private String useSys;

    /**
     * 版本
     */
    @ApiModelProperty(name = "version", value = "版本", required = true, position = 2, example = "1.0.0")
    private String version;

    /**
     * 页面js类型 原生js vue 等
     */
    @ApiModelProperty(name = "jsType", value = "页面js类型 原生js vue 等", position = 2, example = "vue")
    private String jsType;

    /**
     * 页面CSS 类型 css scss less等
     */
    @ApiModelProperty(name = "cssType", value = "页面CSS 类型 css scss less等",  position = 2, example = "css")
    private String cssType;

    /**
     * 备注或者描述
     */
    @ApiModelProperty(name = "description", value = "备注或者描述",  position = 2, example = "备注或者描述备注或者描述备注或者描述")
    private String description;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", value = "使用状态", required = true, position = 2, example = "1" ,allowableValues = "1,0")
    private Integer state;

}
