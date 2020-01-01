package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 协议或用户需知表
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Data
@TableName("hospital_protocol")
public class Protocol extends Model<Protocol> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID页面页面标识唯一
     */
    private String id;
    /**
     * 应用ID APPID
     */
    private String appid;
    /**
     * 协议标题
     */
    private String title;

    /**
     * 协议内容
     */
    private String content;

    /**
     * 协议署名
     */
    private String signature;

    /**
     * 协议类型
     */
    private String type;

    /**
     * 版本
     */
    private String version;

    /**
     * 使用方唯一码
     */
    private String user;

    /**
     * 操作码例如 绑定就诊卡 预约挂号
     */
    private String opcode;

    /**
     * 备注或者描述
     */
    private String description;

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


}
