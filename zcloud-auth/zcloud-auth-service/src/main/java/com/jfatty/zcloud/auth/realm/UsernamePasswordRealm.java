package com.jfatty.zcloud.auth.realm;

import com.jfatty.zcloud.auth.entity.UserPasswd;
import com.jfatty.zcloud.auth.service.UserPasswdService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * 描述 身份校验核心类
 * @author jfatty on 2019/2/17
 * @email jfatty@163.com
 */
@Slf4j
public class UsernamePasswordRealm extends AuthorizingRealm {

    @Autowired
    private UserPasswdService userPasswdService ;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    /**
     * 完成授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.debug("UsernamePasswordRealm =================>doGetAuthorizationInfo ");
        return null;
    }

    /**
     * 小程序端只使用登录功能
     * 完成认证  登录时会进入
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;

        //获取用户的输入的账号.
        String account = (String) usernamePasswordToken.getPrincipal();
        char[] password = (char[]) usernamePasswordToken.getCredentials();
        log.error("UsernamePasswordRealm =================>doGetAuthenticationInfo account [{}] ====> passwd [{}]" ,account, new String(password)  );

        UserPasswd userPasswd = userPasswdService.getUserPasswd(account) ;

        //redisCacheTemplate.opsForValue().set(String.valueOf(userPasswd.getId()), userPasswd);

        //redisCacheTemplate.opsForValue().set("code",123412);

        //Serializable code = redisCacheTemplate.opsForValue().get("code");

        //System.out.println(code);
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                account, //用户名  //用户
                userPasswd.getPassword(), //密码
                ByteSource.Util.bytes(userPasswd.getCredentialsSalt()),//salt=id + salt;
                getName()  //realm name
        );
        return authenticationInfo;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return  token instanceof UsernamePasswordToken;
    }
}
