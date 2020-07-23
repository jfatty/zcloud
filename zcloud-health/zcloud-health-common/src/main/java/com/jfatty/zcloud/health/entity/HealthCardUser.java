package com.jfatty.zcloud.health.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 电子健康卡微信用户信息表
 * </p>
 *
 * @author jfatty
 * @since 2019-12-31
 */
@Data
@TableName("hcs_health_card_user")
public class HealthCardUser extends Model<HealthCardUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 应用ID APPID
     */
    private String appid;

    /**
     * 医院ID
     */
    private String hospitalId;

    /**
     * 微信openId
     */
    private String openId;

    /**
     * openId类型1,2,3
     */
    private Integer openIdType;

    /**
     * 默认电子健康卡ID
     */
    private String healthCardInfoId;

    /**
     * 微信用户是否已激活电子健康卡0表示未激活-1表示激活
     */
    private Integer isActive;

    /**
     * 是否为批量建卡用户0表示否-1表示是
     */
    private Integer isBatch;

    /**
     * 微信用户姓名或者昵称
     */
    private String name;

    /**
     * 微信用户性别
     */
    private String gender;

    /**
     * 微信用户手机号码
     */
    private String phone;

    /**
     * 出生年月日
     */
    private String birthday;

    /**
     * 地址
     */
    private String address;

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


    public final static int ACTIVE_YES = 1;

    public final static int ACTIVE_NO = 0;

    public final static int BATCH_YES = 1;

    public final static int BATCH_NO = 1;

}
