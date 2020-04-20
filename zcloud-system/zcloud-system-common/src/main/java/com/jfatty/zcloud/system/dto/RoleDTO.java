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
public class RoleDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 角色名称
     */
    @ApiModelProperty(name = "name", position = 2 , value = "角色名称" ,required = true , example = "超级管理员" )
    private String name;

    /**
     * 角色描述
     */
    @ApiModelProperty(name = "description", value = "角色描述",  position = 2, example = "备注或者描述备注或者描述备注或者描述备注或者描述备注或者描述")
    private String description;

    /**
     * 角色编码
     */
    @ApiModelProperty(name = "roleCode", position = 2 , value = "角色编码" , example = "ROLECODE" )
    private String roleCode;

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
