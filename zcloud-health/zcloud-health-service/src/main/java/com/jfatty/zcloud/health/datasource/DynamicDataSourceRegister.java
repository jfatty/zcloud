package com.jfatty.zcloud.health.datasource;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *  动态数据源注册
 *  启动动态数据源请在启动类中 添加 @Import(DynamicDataSourceRegister.class)
 */
@Slf4j
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    // 数据源
    private DataSource defaultDataSource;
    private Map<String, DataSource> customDataSources = new HashMap<String, DataSource>();
    private static String DB_DEFAULT_VALUE = "spring.datasource";
    private static String DB_NAME = "names";

    private static String type= "type";
    /**
     * Fully qualified name of the JDBC driver. Auto-detected based on the URL by default.
     */
    private static String driverClassName = "driver-class-name";
    /**
     * JDBC URL of the database.
     */
    private static String url= "url";
    /**
     * Login username of the database.
     */
    private static String username = "username";
    /**
     * Login password of the database.
     */
    private static String password = "password";
    /**
     * 加载多数据源配置
     */
    @Override
    public void setEnvironment(Environment env) {
        initDefaultDataSource(env);
        initCustomDataSources(env);
    }

    /**
     * 1.5.8 初始化主数据源
     */
//    private void initDefaultDataSource(Environment env) {
//        // 读取主数据源
//        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, DB_DEFAULT_VALUE+".");
//        Map<String, Object> dsMap = new HashMap<>();
//        dsMap.put("type", propertyResolver.getProperty("type"));
//        dsMap.put("driver-class-name", propertyResolver.getProperty("driver-class-name"));
//        dsMap.put("url", propertyResolver.getProperty("url"));
//        dsMap.put("username", propertyResolver.getProperty("username"));
//        dsMap.put("password", propertyResolver.getProperty("password"));
//
//        defaultDataSource = buildDataSource(dsMap);
//        customDataSources.put(defaultDbname,defaultDataSource);//默认数据源放到动态数据源里
//        dataBinder(defaultDataSource, env);
//    }
    /**
     * 2.0.4 初始化主数据源
     */
    private void initDefaultDataSource(Environment env) {
        // 读取主数据源
        Map<String, Object> dsMap = new HashMap<String, Object>();
        dsMap.put(type, env.getProperty(DB_DEFAULT_VALUE + "." + type));
        dsMap.put(driverClassName, env.getProperty(DB_DEFAULT_VALUE + "." + driverClassName));
        dsMap.put(url, env.getProperty(DB_DEFAULT_VALUE + "." + url));
        dsMap.put(username, env.getProperty(DB_DEFAULT_VALUE + "." + username));
        dsMap.put(password, env.getProperty(DB_DEFAULT_VALUE + "." + password));
        defaultDataSource = buildDataSource(dsMap);
//        customDataSources.put(defaultDbname,defaultDataSource);//默认数据源放到动态数据源里
//        dataBinder(defaultDataSource, env);
    }


    /**
     * 为DataSource绑定更多数据
     *
     */
//    private void dataBinder(DataSource dataSource, Environment env) {
//        RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);
//        //dataBinder.setValidator(new LocalValidatorFactory().run(this.applicationContext));
//        dataBinder.setConversionService(conversionService);
//        dataBinder.setIgnoreNestedProperties(false);//false
//        dataBinder.setIgnoreInvalidFields(false);//false
//        dataBinder.setIgnoreUnknownFields(true);//true
//        if (dataSourcePropertyValues == null) {
//            Map<String, Object> rpr = new RelaxedPropertyResolver(env, DB_DEFAULT_VALUE).getSubProperties(".");
//            Map<String, Object> values = new HashMap<String, Object>(rpr);
//            // 排除已经设置的属性
//            values.remove("type");
//            values.remove("driver-class-name");
//            values.remove("url");
//            values.remove("username");
//            values.remove("password");
//            dataSourcePropertyValues = new MutablePropertyValues(values);
//        }
//        dataBinder.bind(dataSourcePropertyValues);
//    }

    // 初始化更多数据源
    private void initCustomDataSources(Environment env) {
        // 读取配置文件获取更多数据源，也可以通过defaultDataSource读取数据库获取更多数据源
//        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env,DB_DEFAULT_VALUE+".");
        String dsPrefixs = env.getProperty(DB_DEFAULT_VALUE + "." + DB_NAME);
        for (String dsPrefix : dsPrefixs.split(",")) {// 多个数据源
            Map<String, Object> dsMap = new HashMap<String, Object>();
            dsMap.put(type, env.getProperty(DB_DEFAULT_VALUE + "." + type)); //不单独配置数据源
            dsMap.put(driverClassName, env.getProperty(DB_DEFAULT_VALUE + "."  +  dsPrefix + "." + driverClassName));
            dsMap.put(url, env.getProperty(DB_DEFAULT_VALUE + "."  +  dsPrefix + ".url"));
            dsMap.put(username, env.getProperty(DB_DEFAULT_VALUE + "."  +  dsPrefix + "." + username));
            dsMap.put(password, env.getProperty(DB_DEFAULT_VALUE + "."  +  dsPrefix + "." + password));
            DataSource ds = buildDataSource(dsMap);
            customDataSources.put(dsPrefix, ds);
        }
    }


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        // 将主数据源添加到更多数据源中
        targetDataSources.put("dataSource", defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");
        // 添加更多数据源
        targetDataSources.putAll(customDataSources);
        for (String key : customDataSources.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }
        // 创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", targetDataSources);
        registry.registerBeanDefinition("dataSource", beanDefinition);
        log.info("Dynamic DataSource Registry");
    }

    // 创建DataSource
    @SuppressWarnings("unchecked")
    public DataSource buildDataSource(Map<String, Object> dsMap) {
        try {
            Object dataSourcePoolType = dsMap.get(type);
            Class<? extends DataSource> dataSourceType;
            dataSourceType = (Class<? extends DataSource>) Class.forName((String) dataSourcePoolType);
            DataSourceBuilder factory = DataSourceBuilder.create()
                    .driverClassName((String)dsMap.get(driverClassName))//
                    .url((String)dsMap.get(url))//
                    .username((String)dsMap.get(username))//
                    .password((String)dsMap.get(password))//
                    .type(dataSourceType);
            return factory.build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
