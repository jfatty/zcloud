package com.jfatty.zcloud.hospital.section;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2020/1/7
 * @email jfatty@163.com
 */
@Slf4j
@Aspect
@Component
@Order(-1) // 保证该AOP在@Transactional之前执行
public class ServiceAspect {

    /**
     * execution(* com.jfatty.zcloud.hospital.service.impl.*.*(..)) && @annotation(com.jfatty.zcloud.hospital.annotation.ServiceAspectAnnotation)
     *  "execution(public * com.example.demo.controller.*.*(..)) && @annotation(com.example.demo.controller.MyAnnotation)"
     * "execution(public * com.example.demo.controller.HelloController.add*(..))"
     * 定义切点
     */
    @Pointcut("execution(* com.jfatty.zcloud.hospital.service.impl.*.*(..)) && @annotation(com.jfatty.zcloud.hospital.annotation.ServiceAspectAnnotation)")
    public void addAdvice(){

    }

    @Before("addAdvice()")
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName+"方法的前置通知");


    }

    @Around("addAdvice()")
    public Object doAround(ProceedingJoinPoint pjp) {

        String methodName = pjp.getSignature().getName();
        String clazzName = pjp.getTarget().getClass().getSimpleName();
        System.out.println("@Around：执行目标方法之前..."+clazzName);
        //Field[] fields = pjp.getTarget().getClass().getDeclaredFields();
        //System.out.println("fields "+fields.length);
        Method[] methods = pjp.getTarget().getClass().getDeclaredMethods();
        for ( Method method : methods ){
            System.out.println("method name"+method.getName());

            TargetDataSource targetDataSource = method.getAnnotation(TargetDataSource.class);
            if ( targetDataSource == null)
                continue;
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(targetDataSource);
            try {
                Field memberField = invocationHandler.getClass().getDeclaredField("memberValues");
                memberField.setAccessible(true);
                Map<String, Object> memberValues = (Map<String, Object>) memberField.get(invocationHandler);
                String name = (String) memberValues.get("name");
                System.out.println("改变前：" + name);
                name = "lsxzyy";
                memberValues.put("name", name);
                System.out.println("改变后：" + targetDataSource.name());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Object result = null;
        try {
            result = pjp.proceed();
            System.out.println("@Around：执行目标方法之后...");
            System.out.println("@Around：被织入的目标对象为：" + pjp.getTarget());
            System.out.println( "@Around：原返回值：" + result + "，这是返回结果的后缀");
        } catch (Throwable throwable) {
            log.error("业务对象 [{}] 在执行业务方法 [{}] 时 出现异常 [{}]",clazzName,methodName,throwable.getMessage());
            throwable.printStackTrace();
        }
        return result;
    }

}
