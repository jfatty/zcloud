package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import lombok.Data;

/**
 * 描述 系统模块与菜单对应关系
 *
 * @author jfatty on 2020/4/17
 * @email jfatty@163.com
 */
@Data
public class ModuleRelationshipDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 模块ID
     */
    private String moduleId;

    /**
     * 菜单ID
     */
    private String menuId;

}
