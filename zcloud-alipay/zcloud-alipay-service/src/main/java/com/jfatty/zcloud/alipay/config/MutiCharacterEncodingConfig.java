package com.jfatty.zcloud.alipay.config;

import com.jfatty.zcloud.alipay.filter.MutiCharacterEncodingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述 实例化 自定义EncodingFilter，实现多字符集的处理
 * @author jfatty on 2019/4/23
 * @email jfatty@163.com
 */
@Configuration
public class MutiCharacterEncodingConfig {


    //第一种字符集
    @Value(value = "${spring.http.encoding.charset}")
    private String charset;
    //是否强制应用到request
    @Value(value = "${spring.http.encoding.force-request}")
    private boolean forceRequest;
    //是否强制设置到response
    @Value(value = "${spring.http.encoding.force-response}")
    private boolean forceResponse;

    /**
     * 自定义HTTP字符集 默认使用charset字符集 在特定情况下使用第二字符集 用于欧飞回调GBK编码
     * 仅对POST中的表单参数有效 对于URI中的参数无效 只能去修改tomcat的字符集编码 应该不致于做的这么绝吧
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.http.encoding")
    @ConfigurationPropertiesBinding
    public MutiCharacterEncodingFilter mutiCharacterEncodingFilter(){
        MutiCharacterEncodingFilter encodingFilter = new MutiCharacterEncodingFilter();
        encodingFilter.setEncoding(charset);
        encodingFilter.setForceRequestEncoding(forceRequest);
        encodingFilter.setForceResponseEncoding(forceResponse);
        return encodingFilter;
    }


}
