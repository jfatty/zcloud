package com.jfatty.zcloud.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 微信账号表
 * </p>
 *
 * @author jfatty
 * @since 2019-04-04
 */
@Data
@TableName("wxcms_account")
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

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

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     * 更新人
     */
    private String updateOperator;

    /**
     * 更新时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
