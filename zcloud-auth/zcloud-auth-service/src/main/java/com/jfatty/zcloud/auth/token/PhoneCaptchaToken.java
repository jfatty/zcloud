package com.jfatty.zcloud.auth.token;

import lombok.Data;
import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;

import java.io.Serializable;

/**
 * 描述 手机验证码登录校验 token
 *
 * @author jfatty on 2019/6/10
 * @email jfatty@163.com
 */
@Data
public class PhoneCaptchaToken implements HostAuthenticationToken, RememberMeAuthenticationToken, Serializable {


    private String phone; // 手机号码
    private String captcha ;//验证码
    private boolean rememberMe;
    private String host;


    @Override
    public String getHost() {
        return host;
    }

    @Override
    public boolean isRememberMe() {
        return rememberMe;
    }

    @Override
    public Object getPrincipal() {
        return phone;
    }

    @Override
    public Object getCredentials() {
        return captcha;
    }


    public PhoneCaptchaToken() { this.rememberMe = false; }

    public PhoneCaptchaToken(String phone) { this(phone, false, null); }

    public PhoneCaptchaToken(String phone, String captcha) {
        this(phone,captcha, false, null);
    }

    public PhoneCaptchaToken(String phone, boolean rememberMe) { this(phone, rememberMe, null); }

    public PhoneCaptchaToken(String phone, boolean rememberMe, String host) {
        this.phone = phone;
        this.rememberMe = rememberMe;
        this.host = host;
    }

    public PhoneCaptchaToken(String phone, String captcha, boolean rememberMe, String host) {
        this.phone = phone;
        this.captcha = captcha;
        this.rememberMe = rememberMe;
        this.host = host;
    }
}
