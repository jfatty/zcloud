package com.jfatty.zcloud.system.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/31
 * @email jfatty@163.com
 */
@Data
public class PageImageDTO<T extends BaseDTO> extends BaseDTO {


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
     * 图片标题
     */
    @ApiModelProperty(name = "imgTitle", value = "图片标题",  position = 2, example = "主大图")
    private String imgTitle;
    /**
     * 图片副标题
     */
    @ApiModelProperty(name = "subTitle", value = "图片副标题",  position = 2, example = "图片详细描述")
    private String subTitle;

    /**
     * 图片对应缺省标题
     */
    @ApiModelProperty(name = "imgAlt", value = "图片对应缺省标题",  position = 2, example = "图片01")
    private String imgAlt;

    /**
     * 图片类型 0 表示图片地址 1 表示二进制文件
     */
    @ApiModelProperty(name = "imgType", value = "图片类型 0 表示图片地址 1 表示二进制文件",  position = 2, example = "0" , allowableValues = "0,1")
    private Integer imgType;

    /**
     * 激活图片对应路径
     */
    @ApiModelProperty(name = "actIconUrl", value = "激活图片对应路径",  position = 2, example = "www.baidu.com/img" )
    private String actIconUrl;

    /**
     * 图片对应路径
     */
    @ApiModelProperty(name = "iconUrl", value = "图片对应路径",  position = 2, example = "www.baidu.com/img/img" )
    private String iconUrl;

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
