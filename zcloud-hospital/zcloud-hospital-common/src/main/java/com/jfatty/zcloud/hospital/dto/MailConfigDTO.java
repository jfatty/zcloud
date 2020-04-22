package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 智慧医疗邮件发送配置
 *
 * @author jfatty on 2020/4/22
 * @email jfatty@163.com
 */
@Data
public class MailConfigDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 应用ID APPID
     */
    @ApiModelProperty(name = "appid", position = 1, required = true, value = "应用ID APPID" , example = "wxe3336a60d2685379")
    private String appid;


    /**
     * 邮件接收者账号
     */
    @ApiModelProperty(name = "receiverAccount", position = 1 ,required = true, value = "邮件接收者账号" ,example = "yang133@qq.com")
    private String receiverAccount;

    /**
     * 邮件发送者账号
     */
    @ApiModelProperty(name = "senderAccount", position = 1 ,required = true, value = "邮件发送者账号" ,example = "yygt654@qq.com")
    private String senderAccount;

    /**
     * 邮件发送者密码
     */
    @ApiModelProperty(name = "senderCert", position = 1 ,required = true, value = "邮件发送者密码" ,example = "yygt654@qq.com")
    private String senderCert;


    @ApiModelProperty(name = "senderHost", position = 1 ,required = true, value = "邮件发送主机" ,example = "smtp.163.com")
    private String senderHost;

    /**
     * 描述
     */
    @ApiModelProperty(name = "description", position = 1 , value = "描述" ,example = "描述")
    private String description;

    /**
     * 邮件发送配置激活状态1表示激活0表示未激活
     */
    @ApiModelProperty(name = "activeStatus", position = 1 ,required = true, value = "邮件发送配置激活状态1表示激活0表示未激活" , example = "1", allowableValues = "1,0")
    private Integer activeStatus;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", value = "是否有效", position = 6, required = true, example = "1", allowableValues = "1,0")
    private Integer state;

}
