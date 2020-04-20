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
public class NavigationDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 导航标题
     */
    @ApiModelProperty(name = "title", value = "导航标题", required = true, position = 1 ,example = "门诊服务")
    private String title;

    /**
     * 导航图标路径
     */
    @ApiModelProperty(name = "icon", value = "导航图标路径", position = 1 , example = "./static/img/nav_defaul1.png")
    private String icon;

    /**
     * 导航激活状态图标路径
     */
    @ApiModelProperty(name = "actIcon", value = "导航激活状态图标路径", position = 1 ,example = "./static/img/nav_select1.png")
    private String actIcon;

    /**
     * 版本
     */
    @ApiModelProperty(name = "version", value = "版本", required = true, position = 4, example = "1.0.0")
    private String version;

    /**
     * 路由
     */
    @ApiModelProperty(name = "route", value = "路由", position = 4, example = "/home")
    private String route;

    /**
     * 备注或者描述
     */
    @ApiModelProperty(name = "description", value = "备注或者描述", position = 5, required = true , example = "同步宿主机时间到容器")
    private String description;

    /**
     * 排序号
     */
    @ApiModelProperty(name = "orderNum", value = "排序号", position = 5, required = true ,example = "15")
    private Integer orderNum;

    /**
     * 跳转链接
     */
    @ApiModelProperty(name = "link", value = "跳转链接", position = 5 ,example = "https://mp.weixin.qq.com/s/d_CuljDTJq680NTndAay8g")
    private String link;

    /**
     * 链接跳转类型 打开新页面还是本页面打开
     */
    @ApiModelProperty(name = "linkType", value = "链接跳转类型 'TARGET','ROUTE','HREF'", position = 5,example = "ROUTE" ,allowableValues = "TARGET,ROUTE,HREF")
    private String linkType;


    /**
     * 使用状态 1表示为可用状态0表示为不可用状态
     */
    @ApiModelProperty(name = "state", value = "是否有效", position = 6, required = true,example = "1",allowableValues = "1,0")
    private Integer state;

    /**
     * 是否显示
     */
    @ApiModelProperty(name = "display", position = 8 ,required = true, value = "是否显示 0 不显示 1 显示" ,example = "1",allowableValues = "1,0")
    private Integer display;



}
