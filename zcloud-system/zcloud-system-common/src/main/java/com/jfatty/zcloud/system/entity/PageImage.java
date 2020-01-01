package com.jfatty.zcloud.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 界面图片开发配置
 * </p>
 *
 * @author jfatty
 * @since 2019-12-31
 */
@Data
@TableName("sys_page_image")
public class PageImage extends Model<PageImage> {

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
     * 页面标识ID
     */
    private String pageId;

    /**
     * 页面标签ID 或者是唯一确定元素
     */
    private String elemId;

    /**
     * 图片标题
     */
    private String imgTitle;

    /**
     * 图片对应缺标题
     */
    private String imgAlt;

    /**
     * 图片类型 0 表示图片地址 1 表示二进制文件
     */
    private Integer imgType;

    /**
     * 激活图片对应路径
     */
    private String actIconUrl;

    /**
     * 图片对应路径
     */
    private String iconUrl;

    /**
     * 激活图片二进制文件
     */
    private byte[] actImg;

    /**
     * 图片二进制文件
     */
    private byte[] img;

    /**
     * 设置字段 根据需求使用本字段
     */
    private String site;

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
