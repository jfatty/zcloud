package com.jfatty.zcloud.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * <p>
 * 权限数据关联表
 * </p>
 *
 * @author jfatty
 * @since 2019-03-25
 */
@Data
@TableName("sys_perm_relationship")
public class PermRelationship extends Model<PermRelationship> {

    private static final long serialVersionUID = 1L;

    /**
     * 权限ID
     */
    private String privilegeId;

    /**
     * 授权对象id
     */
    private String authId;



}
