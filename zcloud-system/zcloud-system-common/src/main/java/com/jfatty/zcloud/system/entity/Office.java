package com.jfatty.zcloud.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统科室
 * </p>
 *
 * @author jfatty
 * @since 2019-03-25
 */
@Data
@TableName("sys_office")
public class Office extends Model<Office> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

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

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime ;

    /**
     * 更新人
     */
    private String updateOperator;

    /**
     * 更新时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
