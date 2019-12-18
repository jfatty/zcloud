package com.jfatty.zcloud.wechat.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
public class AccountDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 原始ID
     */
    private String account;

    /**
     * 开发者ID
     */
    private String appid;

    /**
     * 开发者密码
     */
    private String appsecret;

    /**
     * 服务器地址(URL)
     */
    private String url;

    /**
     * 令牌(Token)
     */
    private String token;

    /**
     * 微信号
     */
    private String wxAccount;

    /**
     * AccessToken
     */
    private String accessToken;

    /**
     * 消息条数
     */
    private Integer msgCount;

    /**
     * 描述
     */
    private String description;

    /**
     * 消息加解密密钥(EncodingAESKey)
     */
    private String encodingaesKey;

    /**
     * 公众号类型 订阅号 企业号 服务号 小程序
     */
    private String type;

    /**
     * 电子邮箱,登录邮箱
     */
    private String email;

    /**
     * 该微信账号的管理员
     */
    private String manager;

    /**
     * 数据字典对应字段数据交互类型json，xml
     */
    private String dataType;

    /**
     * 管理员联系方式
     */
    private String managerContact;

    /**
     * 域值
     */
    private String realm;

    /**
     * 使用状态
     */
    private Integer state;

    /**
     * 创建人
     */
    private String createOperator;

}
