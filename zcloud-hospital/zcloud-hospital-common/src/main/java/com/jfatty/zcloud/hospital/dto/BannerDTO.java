package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/11
 * @email jfatty@163.com
 */
@Data
public class BannerDTO<T extends BaseDTO> extends BaseDTO {

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
     * 图片标题
     */
    @ApiModelProperty(name = "title", position = 1,required = true, value = "图片标题" ,example = "智慧停车")
    private String title;

    /**
     * 图片类型 0 表示图片地址 1 表示二进制文件
     */
    @ApiModelProperty(name = "imgType", position = 9 ,required = true, value = "图片类型 0 表示图片地址 1 表示二进制文件",example = "0",allowableValues = "1,0")
    private Integer imgType;


    /**
     * 图片使用方
     */
    @ApiModelProperty(name = "user", position = 2, value = "图片使用方" ,example = "中心医院")
    private String user;

    /**
     * 路由地址
     */
    @ApiModelProperty(name = "route", position = 2, value = "路由地址" ,example = "/home")
    private String route;

    /**
     * 跳转链接
     */
    @ApiModelProperty(name = "link", position = 3, value = "跳转链接" ,example = "https://hub.docker.com/_/python")
    private String link;

    /**
     * 链接跳转类型 打开新页面还是本页面打开
     */
    @ApiModelProperty(name = "linkType", position = 4, value = "链接跳转类型 'TARGET','ROUTE','HREF' " ,required = true,example = "ROUTE" ,allowableValues = "TARGET,ROUTE,HREF")
    private String linkType;

    /**
     * 排序号
     */
    @ApiModelProperty(name = "orderNum", position = 5, value = "排序号",required = true ,example = "14")
    private Integer orderNum;

    /**
     * 版本
     */
    @ApiModelProperty(name = "version", position = 6, value = "版本" ,required = true,example = "1.0.0" )
    private String version;

    /**
     * 备注或者描述
     */
    @ApiModelProperty(name = "description", position = 7 , value = "备注或者描述" ,example = "这是描述")
    private String description;

    /**
     * 是否显示
     */
    @ApiModelProperty(name = "display", position = 8 ,required = true, value = "是否显示 0 不显示 1 显示" ,example = "1",allowableValues = "1,0")
    private Integer display;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", position = 8 ,required = true, value = "使用状态" ,example = "1",allowableValues = "1,0")
    private Integer state;

    /**
     * 域值
     */
    @ApiModelProperty(name = "realm", position = 12 , value = "域值" )
    private String realm;


}
