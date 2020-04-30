package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
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
     *id
     */
    private String id;
    /**
     *开发者微信号
     */
    private String tousername;
    /**
     *发送方帐号（一个OpenID）
     */
    private String fromusername;
    /**
     *消息创建时间 （整型）
     */
    private Date createtime;
    /**
     *消息类型（text/image/location/link）
     */
    private String msgtype;
    /**
     *消息id，64位整型
     */
    private String msgid;
    /**
     *消息内容
     */
    private String content;
    /**
     *是否回复
     */
    private String response;
    /**
     *回复内容
     */
    private String rescontent;
    /**
     *用户昵称
     */
    private String nickname;

    /**
     * 应用id
     */
    private String agentId;
    /**
     *微信账号Id
     */
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
