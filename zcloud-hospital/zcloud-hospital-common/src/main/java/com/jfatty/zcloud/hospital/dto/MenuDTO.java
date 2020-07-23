package com.jfatty.zcloud.hospital.dto;

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
public class MenuDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 应用ID APPID
     */
    @ApiModelProperty(name = "appid", position = 1, required = true, value = "应用ID APPID" , example = "wxe3336a60d2685379")
    private String appid;

    /**
     * 菜单标题
     */
    @ApiModelProperty(name = "title", position = 1 ,required = true, value = "菜单标题" ,example = "住院缴费")
    private String title;

    /**
     * 菜单定位
     */
    @ApiModelProperty(name = "pos", position = 2 ,required = true, value = "菜单定位" ,example = "top")
    private String pos;

    /**
     * 所属导航ID没有的情况下可以为空
     */
    @ApiModelProperty(name = "navId", position = 1 ,value = "所属导航ID没有的情况下可以为空" ,example = "402881906F12FFF9016F130045C40005")
    private String navId ;

    /**
     * 模块 例如首页 个人中心
     */
    @ApiModelProperty(name = "module", position = 1 ,required = true, value = "模块 例如首页 个人中心" ,example = "首页")
    private String module;

    /**
     * 路由
     */
    @ApiModelProperty(name = "route", position = 1 ,required = true, value = "路由" ,example = "/home")
    private String route;

    /**
     * 权限布局方位,顶部导航，左侧菜单，右侧内容，底部
     */
    @ApiModelProperty(name = "layoutMode", position = 1 , value = "权限布局方位,顶部导航，左侧菜单，右侧内容，底部 grid block" ,example = "grid",allowableValues = "grid.block")
    private String layoutMode;

    /**
     * 规格布局 大2中1小0  布局 左4中5右6 上8中5下2
     */
    @ApiModelProperty(name = "norm", position = 1 ,required = true, value = "规格布局 大2中1小0  布局 左4中5右6 上8中5下2" ,example = "5")
    private Integer norm;

    /**
     * 父级菜单
     */
    @ApiModelProperty(name = "parentId", position = 1 , value = "父级菜单" ,example = "AJJSHSHSHJ")
    private String parentId;

    /**
     * 菜单描述
     */
    @ApiModelProperty(name = "description", position = 1 , value = "菜单描述" ,example = "菜单描述 描述 菜单描述 菜单描述 菜单描述")
    private String description;


    /**
     * 菜单使用对象范围 ALL 所有人 INTERNAL 内部人员 SYSTEM 系统人员
     */
    @ApiModelProperty(name = "useScope", position = 1 , value = "菜单使用对象范围" ,example = "ALL 所有人 INTERNAL 内部人员 SYSTEM 系统人员")
    private String useScope;

    /**
     * 菜单图标样式
     */
    @ApiModelProperty(name = "icon", position = 1 , value = "菜单图标" ,example = "菜单图标")
    private String icon;

    /**
     * 菜单图标状激活态图标路径
     */
    @ApiModelProperty(name = "actIcon", position = 1 , value = "菜单图标状激活态图标路径" ,example = "菜单图标状激活态图标路径")
    private String actIcon;

    /**
     * 图标 类型 0 表示图片地址 1 表示二进制文件
     */
    @ApiModelProperty(name = "iconType", position = 1 , value = "图标 类型 0 表示图片地址 1 表示二进制文件" ,example = "0" , allowableValues = "1,0")
    private Integer iconType;

    /**
     * 页面索引页面查询列表按钮权限时使用
     */
    @ApiModelProperty(name = "pageIndex", position = 1 , value = "页面索引页面查询列表按钮权限时使用" ,example = "首页")
    private String pageIndex;

    /**
     * 菜单样式
     */
    @ApiModelProperty(name = "plass", value = "菜单样式", position = 6, example = "red")
    private String plass;

    /**
     * 目标链接窗口
     */
    @ApiModelProperty(name = "target", value = "目标链接窗口", position = 6, example = "https://www.baidu.com")
    private String target;

    /**
     * 菜单类型
     */
    @ApiModelProperty(name = "type", value = "菜单类型 'TARGET','ROUTE','HREF' ", position = 5, example = "ROUTE",allowableValues = "TARGET,ROUTE,HREF")
    private String type;

    /**
     * 排序号
     */
    @ApiModelProperty(name = "sortNum", value = "排序号", position = 6,  example = "3")
    private Integer sortNum;

    /**
     * 菜单版本
     */
    @ApiModelProperty(name = "version", value = "菜单版本", position = 6, required = true,  example = "1.0.0")
    private String version;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", value = "是否有效", position = 6, required = true, example = "1", allowableValues = "1,0")
    private Integer state;

    /**
     * 使用状态0表示正常使用-1表示维护中-2表示建设中...
     */
    @ApiModelProperty(name = "status", value = "使用状态0表示正常使用-1表示维护中-2表示建设中...", position = 6, required = true, example = "0" ,allowableValues = "0,-1,-2")
    private Integer status ;
}
