package com.jfatty.zcloud.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 界面开发配置
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Data
@TableName("sys_page_config")
public class PageConfig extends Model<PageConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID页面页面标识唯一
     */
    private String id;

    /**
     * 页面标题
     */
    private String title;

    /**
     * 页面类型 数据字典 PC网页还是H5页面
     */
    private String pype;

    /**
     * 客户名称
     */
    private String useClient;

    /**
     * 使用次页面的系统名称
     */
    private String useSys;

    /**
     * 版本
     */
    private String version;

    /**
     * 页面js类型 原生js vue 等
     */
    private String jsType;

    /**
     * 页面CSS 类型 css scss less等
     */
    private String cssType;

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
