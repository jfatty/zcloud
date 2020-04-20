package com.jfatty.zcloud.wechat.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
public class MsgTextDTO<T extends BaseDTO> extends BaseDTO {


    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String inputcode;//关注者发送的消息

    @ApiModelProperty(name = "title", position = 12 , value = "消息标题" , example = "张三" )
    private String title;//消息标题

    @ApiModelProperty(name = "content", position = 12 , value = "消息内容" , example = "张三同志你好" )
    private String content;//消息内容

    @ApiModelProperty(name = "baseId", position = 12 , value = "消息主表id" , example = "baseIIJSKKHSIKKSJJKSKK" )
    private String baseId;//消息主表id

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
