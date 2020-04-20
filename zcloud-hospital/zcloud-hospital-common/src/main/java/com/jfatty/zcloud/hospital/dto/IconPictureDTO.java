package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/12
 * @email jfatty@163.com
 */
@Data
public class IconPictureDTO<T extends BaseDTO> extends BaseDTO {



    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 关联对象id
     */
    @ApiModelProperty(name = "relationId", position = 2 , required = true, value = "关联对象id" ,example = "ASWS3332232322")
    private String relationId;

    /**
     * 规格,格式  PC MOBILE APP
     */
    @ApiModelProperty(name = "specification", position = 2 , required = true, value = "规格,格式  PC MOBILE APP" ,example = "MOBILE" , allowableValues = "PC,PAD,MOBILE,APP")
    private String specification;

    /**
     * 菜单图标样式
     */
    @ApiModelProperty(name = "icon", position = 2 , value = "菜单图标样式" ,example = "iconimg" )
    private String icon;

    /**
     * 导航激活状态图标路径
     */
    @ApiModelProperty(name = "actIcon", position = 2 ,  value = "导航激活状态图标路径" ,example = "actimg" )
    private String actIcon;

    /**
     * 备注或者描述
     */
    @ApiModelProperty(name = "description", position = 7 , value = "备注或者描述" ,example = "这是描述")
    private String description;

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
