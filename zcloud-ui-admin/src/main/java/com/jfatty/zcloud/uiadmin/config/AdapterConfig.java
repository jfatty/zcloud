package com.jfatty.zcloud.uiadmin.config;

import com.jfatty.zcloud.uiadmin.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 描述
 *
 * @author jfatty on 2019/12/9
 * @email jfatty@163.com
 */
//@EnableWebMvc
//@Configuration
public class AdapterConfig extends WebMvcConfigurerAdapter {

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor( authInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
