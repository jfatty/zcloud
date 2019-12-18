package com.jfatty.zcloud.system.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 描述
 *
 * @author jfatty on 2019/12/15
 * @email jfatty@163.com
 */
@Data
public class IdentityFileDTO<T extends BaseDTO> extends BaseDTO {


    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "项目编号[添加操作可不传递,修改必传]")
    private String id;

    /**
     * 用户
     */
    @ApiModelProperty(name = "user", value = "项目名称", required = true, position = 1)
    private String user;



    /**
     * 版本
     */
    @ApiModelProperty(name = "version", value = "版本", required = true, position = 4, example = "1.0.0")
    private String version;

    /**
     * 备注或者描述
     */
    @ApiModelProperty(name = "description", value = "备注或者描述", position = 5, required = true)
    private String description;



}
