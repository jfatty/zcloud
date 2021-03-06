package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 智慧医疗首页菜单表
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Data
@TableName("hospital_menu")
public class Menu extends Model<Menu> {

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
     * 菜单标题
     */
    private String title;

    /**
     * 菜单定位
     */
    private String pos;

    /**
     * 所属导航ID没有的情况下可以为空
     */
    private String navId ;

    /**
     * 模块 例如首页 个人中心
     */
    private String module;

    /**
     * 路由
     */
    private String route;

    /**
     * 权限布局方位,顶部导航，左侧菜单，右侧内容，底部
     */
    private String layoutMode;

    /**
     * 规格布局 大2中1小0  布局 左4中5右6 上8中5下2
     */
    private Integer norm;

    /**
     * 父级菜单
     */
    private String parentId;

    /**
     * 菜单描述
     */
    private String description;

    /**
     * 菜单使用对象范围 ALL 所有人 INTERNAL 内部人员 SYSTEM 系统人员
     */
    private String useScope;

    /**
     * 菜单图标样式
     */
    @TableField(exist = false)
    private String icon;

    /**
     * 导航激活状态图标路径
     */
    @TableField(exist = false)
    private String actIcon;

    /**
     * icon图标二进制文件
     */
    @TableField(exist = false)
    private byte[]  iconImg;

    /**
     * 导航图标激活状态二进制文件
     */
    @TableField(exist = false)
    private byte[] actIconImg;

    /**
     * 图标 类型 0 表示图片地址 1 表示二进制文件
     */
    private Integer iconType;

    /**
     * 页面索引页面查询列表按钮权限时使用
     */
    private String pageIndex;

    /**
     * 菜单样式
     */
    private String plass;

    /**
     * 是否为顶级菜单
     */
    private Boolean root;

    /**
     * 展开状态
     */
    private Boolean spread;

    /**
     * 目标链接窗口
     */
    private String target;

    /**
     * 菜单类型
     */
    private String type;

    /**
     * 当前层级
     */
    private Integer level;

    /**
     * 最大层级
     */
    private Integer levelMax;

    /**
     * 排序号
     */
    private Integer sortNum;

    /**
     * 菜单版本
     */
    private String version;

    /**
     * 使用状态0表示正常使用-1表示维护中-2表示建设中...
     */
    private Integer status ;

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
    private LocalDateTime createTime ;

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
