package com.jfatty.zcloud.auth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * 描述
 *
 * @author jfatty on 2019/12/8
 * @email jfatty@163.com
 */
@Data
@TableName("sys_account_unique")
public class UserPasswd extends Model<UserPasswd> {


    /**
     * 主键id
     */
    private String id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String phone ;

    /**
     * 密码的盐值
     */
    private String salt;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime ;

    /**
     * 更新时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public String getCredentialsSalt() {
        //return userName + salt;
        return id + salt;
    }

    /**
     * 用户角色集合
     */
    @TableField(exist = false)
    private Set<String> roles ;

    /**
     * 用户权限集合
     */
    @TableField(exist = false)
    private Set<String> perms ;

    /**
     * 用户权限控制路径集合
     */
    @TableField(exist = false)
    private Set<String> uris ;

    private Integer accEditState ;




}
