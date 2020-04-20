package com.jfatty.zcloud.system.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 描述
 *
 * @author jfatty on 2020/1/1
 * @email jfatty@163.com
 */
@Data
public class PageHrefDTO<T extends BaseDTO> extends BaseDTO {

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
     * 医院ID
     */
    @ApiModelProperty(name = "hospitalId", position = 0,required = true, value = "医院ID" ,example = "30646")
    private String hospitalId;

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
     * 图片标题
     */
    @ApiModelProperty(name = "elemTitle", value = "图片标题",  position = 2, example = "星空.png")
    private String elemTitle;

    /**
     * 链接显示类型 按钮或者a标签
     */
    @ApiModelProperty(name = "elemType", value = "链接显示类型 按钮或者a标签",  position = 2, example = "按钮")
    private String elemType;

    /**
     * 目标地址
     */
    @ApiModelProperty(name = "targetHref", value = "目标地址",  position = 2, example = "按钮")
    private String targetHref;

    /**
     * 校验code值
     */
    @ApiModelProperty(name = "verifyCode", value = "校验code值",  position = 2, example = "按钮")
    private String verifyCode;
    /**
     * 校验名称
     */
    @ApiModelProperty(name = "verifyName", value = "校验名称",  position = 2, example = "")
    private String verifyName;
    /**
     * 校验规则
     */
    @ApiModelProperty(name = "verifyRule", value = "校验规则",  position = 2, example = "")
    private String verifyRule;

    /**
     * 设置字段 根据需求使用本字段
     */
    @ApiModelProperty(name = "site", value = "设置字段 根据需求使用本字段",  position = 2, example = "" )
    private String site;

    /**
     * 备注或者描述
     */
    @ApiModelProperty(name = "description", value = "备注或者描述",  position = 2, example = "备注或者描述备注或者描述备注或者描述备注或者描述备注或者描述")
    private String description;




}
