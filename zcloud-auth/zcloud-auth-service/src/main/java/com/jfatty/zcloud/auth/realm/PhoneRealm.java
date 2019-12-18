package com.jfatty.zcloud.auth.realm;

import com.jfatty.zcloud.auth.token.PhoneCaptchaToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 描述 通过手机验证码登录自定义 Realm
 *
 * @author jfatty on 2019/6/10
 * @email jfatty@163.com
 */
@Slf4j
public class PhoneRealm extends AuthorizingRealm {


    /**
     * 完成授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("PhoneRealm =================>doGetAuthorizationInfo ");
        return null;
    }

    /**
     * 小程序端只使用登录功能
     * 完成认证  登录时会进入
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("PhoneRealm =================>doGetAuthenticationInfo ");
        return null;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return  token instanceof PhoneCaptchaToken;
    }
}
