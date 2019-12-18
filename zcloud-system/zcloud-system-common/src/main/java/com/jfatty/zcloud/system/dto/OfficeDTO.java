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
    private String orgId;

    /**
     * 部门ID
     */
    private String deptId;

    /**
     * 科室名称
     */
    private String name;

    /**
     * 科室描述
     */
    private String description;

    /**
     * 科室编码
     */
    private String officeCode;

    /**
     * 上级科室ID
     */
    private String parentId;

    /**
     * 层级,级别
     */
    private Integer level;

    /**
     * 最大层级
     */
    private Integer levelMax;

    /**
     * 排序号
     */
    private Integer sortNum;

    /**
     * 域值
     */
    private String realm;

    /**
     * 使用状态
     */
    private Integer state;

    /**
     * 创建人
     */
    private String createOperator;

}
