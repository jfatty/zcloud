package com.jfatty.zcloud.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author jfatty
 * @since 2019-03-25
 */
@Data
@TableName("sys_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 性别在这里定义的字段与微信中保持统一
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 可选字段组织机构id
     */
    private String orgId;

    /**
     * 可选字段组织机构名称
     */
    private String org;

    /**
     * 可选字段部门id
     */
    private String deptId;

    /**
     * 可选字段部门名称
     */
    private String dept;

    /**
     * 可选字段科室id
     */
    private String officeId;

    /**
     * 可选字段科室名称
     */
    private String office;

    /**
     * 个人备注
     */
    private String remark;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户身份维修员ITUSER报修员ITWORKER管理员ITMANAGER
     */
    private String identity;
    /**
     * 职务
     */
    private String post;

    /**
     * 账号类型  个人、企业、单位(机构) 关联数据字典ID
     */
    private String type;

    /**
     * 域值
     */
    private String realm;

    /**
     * 用户注册系统后是否通过认证的状态0表示尚未通过认证1表示已经通过认证
     */
    private Integer auth = 0 ;

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


    /**
     * 账号
     */
    @TableField(exist = false)
    private String userName;

    /**
     * 电话号码
     */
    @TableField(exist = false)
    private String tel;

    /**
     * 身份证号码
     */
    @TableField(exist = false)
    private String idCard;

    /**
     * 角色组
     */
    @TableField(exist = false)
    private List<String> roles ;

    /**
     * 用户组
     */
    @TableField(exist = false)
    private List<String> groups ;

}
