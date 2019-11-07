package com.jfatty.zcloud.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jfatty.zcloud.system.converter.LocalDateTimeConverter;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统权限表
 * </p>
 *
 * @author jfatty
 * @since 2019-03-25
 */
@Data
@TableName("sys_privilege")
public class Privilege extends Model<Privilege> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 权限标题名称
     */
    private String title;

    /**
     * 权限控制链接
     */
    private String href;

    /**
     * 权限表示配合shiro使用
     */
    private String sysPermission;

    /**
     * 角色列表表示配合shiro使用角色名称之间,号分隔
     */
    private String sysRole;

    /**
     * 权限布局方位,顶部导航，左侧菜单，右侧内容，底部
     */
    private String layoutPosition;

    /**
     * 父级权限
     */
    private String parentId;

    /**
     * 上级权限ID集合
     */
    private String superior;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 权限图标样式
     */
    private String icon;

    /**
     * 页面索引 页面查询列表按钮权限时使用
     */
    private String pageIndex;

    /**
     * 权限样式
     */
    private String plass;

    /**
     * 是否为顶级权限
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
     * 权限类型'TARGET','BUTTON','HREF','ACTION','SCRIPT','MENU'
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateOperator;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public String getRole() {
        return sysRole;
    }

}
