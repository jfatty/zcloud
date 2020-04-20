package com.jfatty.zcloud.wechat.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述 微信菜单
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
public class AccountMenuDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    @ApiModelProperty(name = "mtype", position = 12 , value = "菜单类型" , example = "按钮" )
    private String mtype;

    /**
     * 事件类型
     */
    @ApiModelProperty(name = "eventType", position = 12 , value = "事件类型" , example = "click" )
    private String eventType;

    @ApiModelProperty(name = "name", position = 12 , value = "菜单名称" , example = "公司介绍" )
    private String name;

    @ApiModelProperty(name = "inputCode", position = 12 , value = "查询关键字" , example = "subscribe" )
    private String inputCode;

    @ApiModelProperty(name = "url", position = 12 , value = "url地址" , example = "www.baidu.com" )
    private String url;

    @ApiModelProperty(name = "sort", position = 12 , value = "排序号" , example = "25" )
    private Integer sort;

    /**
     * 父类ID
     */
    @ApiModelProperty(name = "parentId", position = 12 , value = "父类菜单ID" , example = "AZSXDMJHJ988" )
    private String parentId;

    @ApiModelProperty(name = "msgType", position = 12 , value = "消息类型" , example = "text" )
    private String msgType;

    @ApiModelProperty(name = "msgId", position = 12 , value = "消息ID" , example = "UJHKISJUHJHSia" )
    private String msgId;

    @ApiModelProperty(name = "gid", position = 12 , value = "gid" , example = "" )
    private String gid;

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
