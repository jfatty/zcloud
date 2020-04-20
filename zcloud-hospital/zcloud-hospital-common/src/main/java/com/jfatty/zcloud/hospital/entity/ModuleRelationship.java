package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *  系统模块与菜单对应关系
 * </p>
 *
 * @author jfatty
 * @since 2020-04-17
 */
@Data
@TableName("hospital_module_relationship")
public class ModuleRelationship extends Model<ModuleRelationship> {

    private static final long serialVersionUID = 1L;

    /**
     * 模块ID
     */
    private String moduleId;

    /**
     * 菜单ID
     */
    private String menuId;



}
