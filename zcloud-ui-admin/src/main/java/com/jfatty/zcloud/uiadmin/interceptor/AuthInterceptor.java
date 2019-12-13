package com.jfatty.zcloud.uiadmin.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述
 *
 * @author jfatty on 2019/12/9
 * @email jfatty@163.com
 */
@RefreshScope
public class AuthInterceptor implements  HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取访问URL
        String url = request.getRequestURL().toString();
        String token = request.getHeader("token");
        if(url.contains("login"))
            return true ;
        if (StringUtils.isBlank(token)) {
            response.sendRedirect("login");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
