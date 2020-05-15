package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 描述 文本消息
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
public class AlipayReceivetextDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;
    /**
     *开发者微信号
     */
    @ApiModelProperty(name = "tousername", position = 0, required = true, value = "开发者微信号",example = "20109292929")
    private String tousername;
    /**
     *发送方帐号（一个OpenID）
     */
    @ApiModelProperty(name = "fromusername", position = 0, required = true, value = "发送方帐号（一个OpenID）",example = "45252342342")
    private String fromusername;
    /**
     *消息创建时间 （整型）
     */
    private Date createtime;
    /**
     *消息类型（text/image/location/link）
     */
    @ApiModelProperty(name = "msgtype", position = 0, required = true, value = "消息类型（text/image/location/link）",example = "image")
    private String msgtype;
    /**
     *消息id，64位整型
     */
    @ApiModelProperty(name = "msgid", position = 0, value = "消息id，64位整型",example = "343728482")
    private String msgid;
    /**
     *消息内容
     */
    @ApiModelProperty(name = "content", position = 0, required = true, value = "消息内容",example = "超正点")
    private String content;
    /**
     *是否回复
     */
    @ApiModelProperty(name = "response", position = 0,  value = "是否回复",example = "0")
    private String response;
    /**
     *回复内容
     */
    @ApiModelProperty(name = "rescontent", position = 0,  value = "回复内容",example = "尊敬的用户,您好")
    private String rescontent;
    /**
     *用户昵称
     */
    @ApiModelProperty(name = "nickname", position = 0,  value = "用户昵称",example = "欢欢")
    private String nickname;

    /**
     * 应用id
     */
    @ApiModelProperty(name = "agentId", position = 0,  value = "应用id",example = "8387373ej")
    private String agentId;
    /**
     *微信账号Id
     */
    @ApiModelProperty(name = "accountid", position = 0,  value = "微信账号Id",example = "33487978237821")
    private String accountid;
    /**
     *创建人名称
     */
    private String createName;
    /**
     *创建人登录名称
     */
    private String createBy;
    /**
     *创建日期
     */
    private Date createDate;
    /**
     *更新人名称
     */
    private String updateName;
    /**
     *更新人登录名称
     */
    private String updateBy;
    /**
     *更新日期
     */
    private Date updateDate;

}
