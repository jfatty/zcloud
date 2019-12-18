package com.jfatty.zcloud.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class PrivilegeDTO<T extends BaseDTO> extends BaseDTO {
    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime = LocalDateTime.now() ;

}
