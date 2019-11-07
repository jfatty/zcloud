package com.jfatty.zcloud.base.holder;

import com.jfatty.zcloud.base.exception.UnexpectedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 描述 以静态变量保存 Spring ApplicationContext, 可在任何代码任何地方任何时候中取出 ApplicaitonContext
 * @author jfatty on 2019/4/12
 * @email jfatty@163.com
 */
@Slf4j
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    /**
     * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationContextHolder.applicationContext == null) {
            ApplicationContextHolder.applicationContext = applicationContext ;
        }
        log.error("====================================================>    initApplicationContext");
    }

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     * 如果有多个Bean符合Class, 取出第一个.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> requiredType) {
        checkApplicationContext();
        Map<String,T> beans= applicationContext.getBeansOfType(requiredType);
        if(!beans.isEmpty()){
            return beans.values().iterator().next();
        }
        throw new UnexpectedException("spring中没有类型【"+requiredType.getName()+"】的实例");
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     * 如果有多个Bean符合Class, 取出第一个.如果没有对应的类返回null
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBeanByClassName(String clazz) {
        checkApplicationContext();
        try {
            Map<String,?> beans= applicationContext.getBeansOfType(Class.forName(clazz));
            if(!beans.isEmpty()){
                return (T)beans.values().iterator().next();
            }
            throw new UnexpectedException("spring中没有类型【"+clazz+"】的实例");
        } catch (Exception e) {
            throw new UnexpectedException(e.getMessage(),e);
        }
    }

    /**
     * 清除applicationContext静态变量.
     */
    public static void cleanApplicationContext(){
        applicationContext = null;
    }

    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
        }
    }
}
