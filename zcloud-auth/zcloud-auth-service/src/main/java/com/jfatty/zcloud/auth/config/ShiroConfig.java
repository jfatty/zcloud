package com.jfatty.zcloud.auth.config;

import com.jfatty.zcloud.auth.realm.PhoneRealm;
import com.jfatty.zcloud.auth.realm.UsernamePasswordRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.env.IniWebEnvironment;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * Description  : Apache Shiro 核心通过 Filter 来实现，就好像SpringMvc 通过DispachServlet 来主控制一样。
 * 既然是使用 Filter 一般也就能猜到，是通过URL规则来进行过滤和权限校验，所以我们需要定义一系列关于URL的规则和访问权限。
 */
@Configuration
public class ShiroConfig {


    private Map<String, String> filterChainDefinitionMap(){
        Map<String, String> map = new LinkedHashMap<String, String>();
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        map.put("/api/login", "anon");//API接口
        map.put("/api/kaptcha", "anon");//API接口
        map.put("/api/**/kaptcha", "anon");//API接口
        map.put("/api/logout", "anon");//API接口
        map.put("/api/authSmsLog/**", "anon");//API接口
        map.put("/api/authSmsConfig/**", "anon");//API接口
        // 其他的
        //map.put("/**", "anon");
        // swagger接口文档
        map.put("/swagger-resources/**", "anon");
        map.put("/v2/api-docs", "anon");
        map.put("/v2/api-docs-ext", "anon");
        map.put("/doc.html", "anon");
        map.put("/webjars/** ", "anon");

        map.put("/**", "authc");
        return map ;
    }

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager Filter Chain定义说明
     * 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        //shiroFilterFactoryBean.setLoginUrl();
        // 登录成功后要跳转的链接
        //shiroFilterFactoryBean.setSuccessUrl();
        // 未授权界面，不生效(详情原因看MyExceptionResolver)
        //shiroFilterFactoryBean.setUnauthorizedUrl();
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap());
        return shiroFilterFactoryBean;
    }


    @Bean
    public IniWebEnvironment iniWebEnvironment(){
        IniWebEnvironment iniWebEnvironment = new IniWebEnvironment() ;
        //iniWebEnvironment.setSecurityManager();
        //iniWebEnvironment.setWebSecurityManager((WebSecurityManager)securityManager());
        iniWebEnvironment.setWebSecurityManager((WebSecurityManager) securityManager());
        //iniWebEnvironment.setFilterChainResolver(filterChainResolver());
        return iniWebEnvironment ;
    }


    /**
     * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     */
    @Bean
    public UsernamePasswordRealm usernamePasswordRealm() {
        UsernamePasswordRealm realm = new UsernamePasswordRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }

    @Bean
    public PhoneRealm phoneRealm() {
        PhoneRealm realm = new PhoneRealm();
        return realm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realms
        securityManager.setRealms(new ArrayList<Realm>(Arrays.asList(usernamePasswordRealm(), phoneRealm())));
        // 注入记住我管理器
        securityManager.setRememberMeManager(rememberMeManager());


        List<Realm> list = (List<Realm>) securityManager.getRealms();
        list.forEach(
                realm -> {
                    System.out.println(realm.getClass().getSimpleName());
                }
        );
        System.out.println("默认认证器==========================>" + securityManager.getAuthenticator().getClass().getSimpleName());

        ModularRealmAuthenticator authenticator = (ModularRealmAuthenticator)securityManager.getAuthenticator() ;

        System.out.println("Strategy==========================>" + authenticator.getAuthenticationStrategy().getClass().getSimpleName() );
        //会话管理
        securityManager.setSessionManager(defaultWebSessionManager());
        return securityManager;
    }


    /**
     * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * 所以我们需要修改下doGetAuthenticationInfo中的代码; @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);// 散列的次数，比如散列两次，相当于md5(md5(""));
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);//表示是否存储散列后的密码为16进制，需要和生成密码时的一样，默认是base64；
        return hashedCredentialsMatcher;
    }

    /**
     * 开启shiro aop注解支持. 使用代理方式; 所以需要开启代码支持;
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * cookie对象;
     *
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        //System.out.println("ShiroConfiguration.rememberMeCookie()");
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        //simpleCookie.setHttpOnly(true);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     *
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

    //@Bean(name = "sessionManager")
    @Bean
    public DefaultWebSessionManager defaultWebSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(18000000);
        // url中是否显示session Id
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        // 删除失效的session
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionValidationInterval(18000000);
        //sessionManager.setSessionValidationScheduler(getExecutorServiceSessionValidationScheduler());
        //设置SessionIdCookie 导致认证不成功，不从新设置新的cookie,从sessionManager获取sessionIdCookie
        //sessionManager.setSessionIdCookie(simpleIdCookie());
        //sessionManager.getSessionIdCookie().setName("hfnumo-session-z-id");
        sessionManager.getSessionIdCookie().setPath("/");
        sessionManager.getSessionIdCookie().setMaxAge(60 * 60 * 24 * 7);
        return sessionManager;
    }


}
