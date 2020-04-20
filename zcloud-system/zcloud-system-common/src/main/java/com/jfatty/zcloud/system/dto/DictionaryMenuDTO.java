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
public class DictionaryMenuDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 菜单字典名称
     */
    @ApiModelProperty(name = "name", position = 2 , value = "菜单字典名称" , example = "民族菜单" )
    private String name;

    /**
     * 菜单字典编码
     */
    @ApiModelProperty(name = "menuCode", position = 2 , value = "菜单字典编码" , example = "MZBM" )
    private String menuCode;

    /**
     * 菜单字典描述
     */
    @ApiModelProperty(name = "description", position = 2 , value = "菜单字典描述" , example = "字典菜单描述" )
    private String description;

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
