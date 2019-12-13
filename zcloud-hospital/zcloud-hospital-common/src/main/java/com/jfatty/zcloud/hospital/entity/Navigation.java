package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Data
@TableName("hospital_navigation")
public class Navigation extends Model<Navigation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID页面页面标识唯一
     */
    private String id;

    /**
     * 导航标题
     */
    private String title;

    /**
     * 导航图标路径
     */
    private String icon;

    /**
     * 导航激活状态图标路径
     */
    private String actIcon;

    /**
     * 导航图标二进制文件
     */
    private byte[] iconImg;

    /**
     * 导航图标激活状态二进制文件
     */
    private byte[] actIconImg;

    /**
     * 版本
     */
    private String version;

    /**
     * 路由
     */
    private String route;

    /**
     * 备注或者描述
     */
    private String description;

    /**
     * 排序号
     */
    private Integer orderNum;

    /**
     * 跳转链接
     */
    private String link;

    /**
     * 链接跳转类型 打开新页面还是本页面打开
     */
    private String linkType;

    /**
     * 是否显示 1 表示显示 0 表示不显示
     */
    private Integer display;

    /**
     * 使用状态 1表示为可用状态0表示为不可用状态
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

}
