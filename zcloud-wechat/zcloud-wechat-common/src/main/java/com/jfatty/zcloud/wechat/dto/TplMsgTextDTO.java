package com.jfatty.zcloud.wechat.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述 微信模板消息
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
public class TplMsgTextDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;


    /**
     * 唯一关键字
     */
    @ApiModelProperty(name = "kw", position = 3 ,required = true, value = "唯一关键字" ,example = "kw")
    private String kw;

    /**
     * 模板ID
     */
    @ApiModelProperty(name = "tplId", position = 12 , value = "模板ID" , example = "QAZXSWEDC741258963" )
    private String tplId;

    /**
     * 链接
     */
    @ApiModelProperty(name = "url", position = 12 , value = "链接" , example = "模板消息链接地址" )
    private String url;

    /**
     * 标题
     */
    @ApiModelProperty(name = "title", position = 12 , value = "标题" , example = "模板消息标题" )
    private String title;

    /**
     * 内容
     */
    @ApiModelProperty(name = "content", position = 12 , value = "内容" , example = "尊敬的用户您好" )
    private String content;

    /**
     * 微信模板
     */
    @ApiModelProperty(name = "wxTpl", position = 12 , value = "微信模板" , example = "moban88iuajki88u8uu" )
    private String wxTpl;

    /**
     * 系统发送时的map内容
     */
    @ApiModelProperty(name = "sendContent", position = 12 , value = "系统发送时的map内容" , example = "map参数" )
    private String sendContent;

    /**
     * 基础ID
     */
    @ApiModelProperty(name = "baseId", position = 12 , value = "基础ID" , example = "AAWSWD525854" )
    private String baseId;

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
