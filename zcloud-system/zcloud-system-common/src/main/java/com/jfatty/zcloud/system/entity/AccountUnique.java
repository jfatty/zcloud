package com.jfatty.zcloud.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统账号信息表
 * </p>
 *
 * @author jfatty
 * @since 2019-03-25
 */
@Data
@TableName("sys_account_unique")
public class AccountUnique extends Model<AccountUnique> {

    private static final long serialVersionUID = 1L;


    public static final String KEY = "SESSION_USER" ;

    public static final String SHIORO_KEY = "SHIORO_USER" ;

    /**
     * 主键id
     */
    private String id;

    /**
     * 账号
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码的盐值
     */
    private String salt;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 域值
     */
    private String realm;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public AccountUnique() {
    }

    public AccountUnique(String id, String userName, String tel, String idCard) {
        this.id = id ;
        this.userName = userName ;
        this.tel = tel ;
        this.idCard = idCard ;
    }


    public String getCredentialsSalt() {
        //return userName + salt;
        return id + salt;
    }


}
