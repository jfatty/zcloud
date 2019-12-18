package com.jfatty.zcloud.auth.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/12/7
 * @email jfatty@163.com
 */
@Data
public class LoginVo implements Serializable {


    /**
     * 账号
     */
    private String account;

    /**
     * 密码 校验验证码
     */
    private String password;

    /**
     * 源自哪里
     */
    private String source ;

    /**
     * 回调地址
     */
    private String callback ;



}
