package com.jfatty.zcloud.hospital.dto;


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
public class ProtocolDTO<T extends BaseDTO> extends BaseDTO {

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
     * 协议标题
     */
    @ApiModelProperty(name = "title", value = "协议标题", required = true, position = 2, example = "绑定就诊人")
    private String title;

    /**
     * 协议内容
     */
    @ApiModelProperty(name = "content", value = "协议内容", required = true, position = 2, example = "绑定就诊人绑定就诊人绑定就诊人绑定就诊人绑定就诊人绑定就诊人绑定就诊人绑定就诊人绑定就诊人绑定")
    private String content;

    /**
     * 协议署名
     */
    @ApiModelProperty(name = "signature", value = "协议署名", required = true, position = 2, example = "中医院")
    private String signature;

    /**
     * 协议类型
     */
    @ApiModelProperty(name = "type", value = "协议类型", required = true, position = 2, example = "bd")
    private String type;

    /**
     * 版本
     */
    @ApiModelProperty(name = "version", value = "版本", required = true, position = 2, example = "1.0.0")
    private String version;

    /**
     * 使用方唯一码
     */
    @ApiModelProperty(name = "user", value = "使用方唯一码", required = true, position = 2, example = "lsxzyy")
    private String user;

    /**
     * 操作码例如 绑定就诊卡 预约挂号
     */
    @ApiModelProperty(name = "opcode", value = "操作码例如 绑定就诊卡 预约挂号", required = true, position = 2, example = "bdjzr")
    private String opcode;

    /**
     * 备注或者描述
     */
    @ApiModelProperty(name = "description", value = "备注或者描述",  position = 2, example = "绑定就诊人绑ssdadsds定就诊人绑定就诊人绑")
    private String description;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", position = 11,required = true,value = "正常使用 1 停用 0 使用状态" , example = "1" ,allowableValues = "0,1")
    private Integer state;

}
