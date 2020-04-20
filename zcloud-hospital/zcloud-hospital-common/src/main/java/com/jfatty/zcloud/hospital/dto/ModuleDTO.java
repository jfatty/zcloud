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
public class ModuleDTO<T extends BaseDTO> extends BaseDTO {

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
     * 模块名称
     */
    @ApiModelProperty(name = "name", position = 2 ,required = true, value = "模块名称" ,example = "首页")
    private String name;

    /**
     * 唯一关键字
     */
    @ApiModelProperty(name = "kw", position = 3 ,required = true, value = "唯一关键字" ,example = "kw")
    private String kw;

    /**
     * 父模块ID
     */
    @ApiModelProperty(name = "parentId", position = 2 , value = "父模块ID" ,example = "")
    private String parentId;

    /**
     * 模块位置 从上至下
     */
    @ApiModelProperty(name = "pos", position = 2 , value = "模块位置 从上至下" ,example = "top")
    private String pos;

    /**
     * 排序号
     */
    @ApiModelProperty(name = "orderNum", value = "排序号", position = 5, required = true ,example = "15")
    private Integer orderNum;

    /**
     * 备注或者描述
     */
    @ApiModelProperty(name = "description", position = 7 , value = "备注或者描述" ,example = "这是描述")
    private String description;

    /**
     * 模块使用方
     */
    @ApiModelProperty(name = "user", position = 2, value = "图片使用方" ,example = "中心医院")
    private String user;

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
