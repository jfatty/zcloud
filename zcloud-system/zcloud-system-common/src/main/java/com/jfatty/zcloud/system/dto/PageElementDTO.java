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
public class PageElementDTO<T extends BaseDTO> extends BaseDTO {
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
     * 页面标识ID
     */
    @ApiModelProperty(name = "pageId", value = "页面标识ID", required = true, position = 2, example = "HOME201912525")
    private String pageId;

    /**
     * 页面标签ID 或者是唯一确定元素
     */
    @ApiModelProperty(name = "elemId", value = "页面标签ID 或者是唯一确定元素", required = true, position = 2, example = "nation,sex...")
    private String elemId;

    /**
     * 页面标签类型 input select radio等
     */
    @ApiModelProperty(name = "elemType", value = "页面标签类型 input select radio等", required = true, position = 2, example = "select")
    private String elemType;

    /**
     * 二级页面标签类型 hidden checbox 等
     */
    @ApiModelProperty(name = "elemSecType", value = "二级页面标签类型 hidden checbox 等",  position = 2, example = "checbox")
    private String elemSecType;

    /**
     * 字典菜单ID
     */
    @ApiModelProperty(name = "dictionaryMenu", value = "字典菜单ID 后台查询 SSKSJK25282828", required = true, position = 2, example = "SSKSJK25282828")
    private String dictionaryMenu;

    /**
     * 设置字段 根据需求使用本字段
     */
    @ApiModelProperty(name = "site", value = "设置字段 根据需求使用本字段",  position = 2, example = "根据需求自定义")
    private String site;

    /**
     * 备注或者描述
     */
    @ApiModelProperty(name = "description", value = "备注或者描述",  position = 2, example = "备注或者描述备注或者描述备注或者描述备注或者描述备注或者描述")
    private String description;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", value = "使用状态", required = true, position = 2, example = "1" ,allowableValues = "1,0")
    private Integer state;

}
