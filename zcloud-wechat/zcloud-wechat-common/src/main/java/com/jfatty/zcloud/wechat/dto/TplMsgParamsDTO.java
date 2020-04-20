package com.jfatty.zcloud.wechat.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述 微信模板消息参数配置
 *
 * @author jfatty on 2020/1/5
 * @email jfatty@163.com
 */
@Data
public class TplMsgParamsDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;

    /**
     * 模板ID
     */
    @ApiModelProperty(name = "tplId", position = 12 , value = "模板ID" , example = "QAZXSWEDCVFRTGBNHYUM" )
    private String tplId;

    /**
     * 模板消息配置key值
     */
    @ApiModelProperty(name = "tplMsgKey", position = 12 , value = "模板消息配置key值" , example = "msgKey" )
    private String tplMsgKey;

    /**
     * 模板消息配置value
     */
    @ApiModelProperty(name = "tplMsgVal", position = 12 , value = "模板消息配置value" , example = "kjkaiuj" )
    private String tplMsgVal;

    /**
     * 排序号
     */
    @ApiModelProperty(name = "orderNum", position = 12 , value = "排序号" , example = "21" )
    private Integer orderNum;

    /**
     * 备注或者描述
     */
    @ApiModelProperty(name = "description", position = 12 , value = "微信模板消息参数配置备注或者描述" , example = "备注或者描述" )
    private String description;

    /**
     * 微信原始ID
     */
    @ApiModelProperty(name = "account", position = 12 , value = "微信原始ID" ,required = true , example = "gh_sjsijaijhishaiai" )
    private String account;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", position = 11,required = true,value = "正常使用 1 停用 0 使用状态" , example = "1" ,allowableValues = "0,1")
    private Integer state;

    /**
     * 域值
     */
    @ApiModelProperty(name = "realm", position = 12 , value = "域值" )
    private String realm;

    /**
     * 更新人
     */
    @ApiModelProperty(name = "updateOperator", position = 12 , value = "更新人" , example = "张三" )
    private String updateOperator;

    /**
     * 更新时间
     */
    @ApiModelProperty(name = "updateTime", position = 13 , value = "更新时间" ,allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;



}
