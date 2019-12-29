package com.jfatty.zcloud.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统短信息发送日志记录表
 * </p>
 *
 * @author jfatty
 * @since 2019-12-27
 */
@Data
@TableName("auth_sms_log")
public class AuthSmsLog extends Model<AuthSmsLog> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 每个应用都对应有appId支付宝、微信、第三方APPappId
     */
    private String appid;

    /**
     * 发送短息的手机号
     */
    private String smsPhone;

    /**
     * 短信发送编码全局唯一 短信发送内容
     */
    private String smsContent;

    /**
     * 短信发送状态 0表示正常 -1表示信息发送异常
     */
    private Integer smsStatus;

    /**
     * 短信应用SDK AppID
     */
    private String accessKeyId;

    /**
     * 短信服务提供商名称
     */
    private String providerName;

    /**
     * 短信模板ID，需要在短信应用中申请
     */
    private String templateId;

    /**
     * 必填:短信签名-可在短信控制台中找到
     */
    private String signName;

    /**
     * 错误信息
     */
    private String errMsg;

    /**
     * 使用状态0表示正常使用-1表示维护中-2表示建设中...
     */
    private Integer status;

    /**
     * 使用状态
     */
    private Integer state;

    /**
     * 域值
     */
    private String realm;

    /**
     * 创建人
     */
    private String createOperator;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

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

    /**
     * 删除状态0表示非删除状态1表示数据已经删除
     */
    private Integer deleteState;

    /**
     * 删除时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deleteTime;

    /**
     * 删除操作者
     */
    private String deleteOperator;

}
