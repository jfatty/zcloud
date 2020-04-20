package com.jfatty.zcloud.system.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


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
    @ApiModelProperty(name = "title", value = "权限标题名称", required = true , position = 2, example = "用户管理")
    private String title;

    /**
     * 权限控制链接
     */
    @ApiModelProperty(name = "href", value = "权限控制链接", required = true , position = 2, example = "/user/list")
    private String href;

    /**
     * 权限表示配合shiro使用
     */
    @ApiModelProperty(name = "sysPermission", value = "权限表示配合shiro使用",  position = 2, example = "user:add")
    private String sysPermission;

    /**
     * 角色列表表示配合shiro使用角色名称之间,号分隔
     */
    @ApiModelProperty(name = "sysRole", value = "角色列表表示配合shiro使用角色名称之间,号分隔",  position = 2, example = "sys:admin")
    private String sysRole;

    /**
     * 权限布局方位,顶部导航，左侧菜单，右侧内容，底部
     */
    @ApiModelProperty(name = "layoutPosition", value = "权限布局方位,顶部导航，左侧菜单，右侧内容，底部",  position = 2, example = "底部")
    private String layoutPosition;

    /**
     * 父级权限
     */
    @ApiModelProperty(name = "parentId", value = "权限布局方位,顶部导航，左侧菜单，右侧内容，底部",  position = 2, example = "底部")
    private String parentId;

    /**
     * 上级权限ID集合
     */
    @ApiModelProperty(name = "parentId", value = "上级权限ID集合",  position = 2, example = "系统管理")
    private String superior;

    /**
     * 权限描述
     */
    @ApiModelProperty(name = "description", value = "权限描述",  position = 2, example = "用于用户管理")
    private String description;

    /**
     * 权限图标样式
     */
    @ApiModelProperty(name = "icon", value = "权限图标样式",  position = 2, example = "icon:color:red")
    private String icon;

    /**
     * 页面索引 页面查询列表按钮权限时使用
     */
    @ApiModelProperty(name = "pageIndex", value = "页面索引 页面查询列表按钮权限时使用",  position = 2, example = "用户")
    private String pageIndex;

    /**
     * 权限样式
     */
    @ApiModelProperty(name = "plass", value = "权限样式",  position = 2, example = "plass:color:red")
    private String plass;

    /**
     * 是否为顶级权限
     */
    @ApiModelProperty(name = "root", value = "是否为顶级权限",  position = 2, example = "true",allowableValues = "true,false")
    private Boolean root;

    /**
     * 展开状态
     */
    @ApiModelProperty(name = "spread", value = "展开状态",  position = 2, example = "false",allowableValues = "true,false")
    private Boolean spread;

    /**
     * 目标链接窗口
     */
    @ApiModelProperty(name = "target", value = "目标链接窗口",  position = 2, example = "目标地址")
    private String target;

    /**
     * 权限类型'TARGET','BUTTON','HREF','ACTION','SCRIPT','MENU'
     */
    @ApiModelProperty(name = "type", value = "权限类型'TARGET','BUTTON','HREF','ACTION','SCRIPT','MENU'",  position = 2, example = "BUTTON")
    private String type;

    /**
     * 最大层级
     */
    @ApiModelProperty(name = "levelMax", position = 2 , value = "最大层级" , example = "N" )
    private Integer levelMax;

    /**
     * 当前层级
     */
    @ApiModelProperty(name = "level", position = 2 , value = "当前层级" , example = "5" )
    private Integer level;

    /**
     * 排序号
     */
    @ApiModelProperty(name = "sortNum", position = 2 , value = "排序号" , example = "13" )
    private Integer sortNum;


    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", position = 11,required = true,value = "正常使用 1 停用 0 使用状态" , example = "1" ,allowableValues = "0,1")
    private Integer state;


    /**
     * 域值
     */
    @ApiModelProperty(name = "realm", position = 12 , value = "域值" )
    private String realm;



}
