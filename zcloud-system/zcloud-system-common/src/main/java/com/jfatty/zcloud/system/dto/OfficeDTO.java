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
public class OfficeDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;
    /**
     * 组织机构ID
     */
    @ApiModelProperty(name = "orgId", position = 2 , value = "组织机构ID" , example = "AASWW34434" )
    private String orgId;

    /**
     * 部门ID
     */
    @ApiModelProperty(name = "deptId", position = 2 , value = "部门ID" , example = "AASWW34434" )
    private String deptId;

    /**
     * 科室名称
     */
    @ApiModelProperty(name = "name", position = 2 , value = "科室名称" , example = "信息科" )
    private String name;

    /**
     * 科室描述
     */
    @ApiModelProperty(name = "description", position = 2 , value = "科室描述" , example = "中心医院信息科" )
    private String description;

    /**
     * 科室编码
     */
    @ApiModelProperty(name = "officeCode", position = 2 , value = "科室编码" , example = "XXK" )
    private String officeCode;

    /**
     * 上级科室ID
     */
    @ApiModelProperty(name = "parentId", position = 2 , value = "上级科室ID" , example = "XXKAAAAAA" )
    private String parentId;

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

    /**
     * 创建人
     */
    @ApiModelProperty(name = "createOperator", position = 2 , value = "创建人" , example = "张三" )
    private String createOperator;

}
