package com.jfatty.zcloud.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jfatty.zcloud.system.converter.LocalDateTimeConverter;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统组织机构,组织对应表结构
 * </p>
 *
 * @author jfatty
 * @since 2019-03-25
 */
@Data
@TableName("sys_org")
public class Org extends Model<Org> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 上级组织机构ID
     */
    private String parentId;

    /**
     * 组织结构全称
     */
    private String name;

    /**
     * 组织结构简称
     */
    private String simpleName;

    /**
     * 组织机构代码
     */
    private String orgCode;

    /**
     * 法人姓名
     */
    private String legal;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 机构地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 官网
     */
    private String www;

    /**
     * 对外QQ号码
     */
    private String qq;

    /**
     * 对外微信号
     */
    private String wx;

    /**
     * 备注或者描述
     */
    private String remark;

    /**
     * 当前层级
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateOperator;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
