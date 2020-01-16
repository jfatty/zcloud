package com.jfatty.zcloud.hospital.annotation;


import java.lang.annotation.*;

/**
 * 描述
 *
 * @author jfatty on 2020/1/7
 * @email jfatty@163.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Documented
public @interface ServiceAspectAnnotation {



}
