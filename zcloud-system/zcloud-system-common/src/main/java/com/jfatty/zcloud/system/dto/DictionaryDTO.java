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
public class DictionaryDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 字典值
     */
    @ApiModelProperty(name = "dicValue", position = 2 , value = "字典值" ,example = "门诊号")
    private String dicValue;

    /**
     * 字典值编码
     */
    @ApiModelProperty(name = "dicCode", position = 2 , value = "字典值编码" , example = "MZH")
    private String dicCode;



}
