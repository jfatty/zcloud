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
public class PermRelationshipDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 权限ID
     */
    private String privilegeId;

    /**
     * 授权对象id
     */
    private String authId;
}
