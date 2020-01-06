package com.jfatty.zcloud.health.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <p>
 * 电子健康卡平台配置信息表
 * </p>
 *
 * @author jfatty
 * @since 2019-12-26
 */
@Data
@TableName("hcs_health_card_settings")
public class HealthCardSettings extends Model<HealthCardSettings> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 开放平台官网分配的appId
     */
    private String appid;

    /**
     * 医院ID
     */
    private String hospitalId;

    private String appSecret;

    /**
     * 其他所有接口的调用凭证
     */
    private String appToken = "";

    /**
     * appToken有效时间，默认为7200秒
     */
    private Integer expiresIn;

    private String wechatCode;

    private String description;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expireTime;

    /**
     * 发卡机构名称
     */
    private String issueCardOrg ;

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

    @TableField(exist = false)
    private String requestId = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();

}
