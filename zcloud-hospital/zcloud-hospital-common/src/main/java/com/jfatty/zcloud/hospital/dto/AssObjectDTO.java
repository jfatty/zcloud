package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 量表关联对象
 *
 * @author jfatty on 2020/6/9
 * @email jfatty@163.com
 */
@Data
public class AssObjectDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 关联对象名称
     */
    @ApiModelProperty(name = "name", position = 3 , required = true,value = "关联对象名称" , example = "科主任" )
    private String name;

    /**
     * 关联对象类别
     */
    @ApiModelProperty(name = "type", position = 3 , required = true,value = "关联对象类别" , example = "就诊科室" )
    private String type;

    /**
     * 关联对象编码
     */
    @ApiModelProperty(name = "code", position = 3 , value = "关联对象编码" , example = "jzk" )
    private String code;

    /**
     * 描述
     */
    @ApiModelProperty(name = "description", position = 3 , value = "关联对象描述" , example = "山外青山楼外" )
    private String description;

    /**
     * 排序号
     */
    @ApiModelProperty(name = "orderById", position = 3 , value = "排序号" , example = "3" )
    private Integer orderById;


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
