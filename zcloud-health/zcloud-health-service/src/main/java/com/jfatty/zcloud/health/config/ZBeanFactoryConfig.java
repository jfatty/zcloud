package com.jfatty.zcloud.health.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * 描述
 *
 * @author jfatty on 2019/12/13
 * @email jfatty@163.com
 */
@Slf4j
@Configuration
public class ZBeanFactoryConfig implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)  throws BeansException {
        //log.error("对象---[{}]---初始化开始[{}]" ,beanName, bean.getClass().getName());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //og.error("对象---[{}]---初始化成功" , beanName);
        return bean;
    }
}
