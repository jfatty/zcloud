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
@TableName("hospital_banner_img")
public class BannerImg extends Model<BannerImg> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID页面页面标识唯一
     */
    private String id;

    /**
     * 图片标题
     */
    private String title;

    /**
     * 图片一般存储为地址
     */
    private String img;

    /**
     * 图片二进制文件
     */
    private byte[] picture;

    /**
     * 图片类型 0 表示图片地址 1 表示二进制文件
     */
    private Integer imgType;

    /**
     * 图片使用方
     */
    private String user;

    /**
     * 路由地址
     */
    private String route;

    /**
     * 跳转链接
     */
    private String link;

    /**
     * 链接跳转类型 打开新页面还是本页面打开
     */
    private String linkType;

    /**
     * 排序号
     */
    private Integer orderNum;

    /**
     * 版本
     */
    private String version;

    /**
     * 备注或者描述
     */
    private String description;

    /**
     * 是否显示
     */
    private Integer display;

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


}
