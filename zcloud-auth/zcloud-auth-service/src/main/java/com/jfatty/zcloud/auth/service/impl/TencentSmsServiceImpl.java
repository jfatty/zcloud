package com.jfatty.zcloud.auth.service.impl;


import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.jfatty.zcloud.auth.entity.AuthSmsConfig;
import com.jfatty.zcloud.auth.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 描述
 *
 * @author jfatty on 2019/12/14
 * @email jfatty@163.com
 */
@Slf4j
@Service("tencentSmsService")
public class TencentSmsServiceImpl implements SmsService {

    // 短信应用SDK AppID
    static final int appid = 1400218931; // 1400开头

    // 短信应用SDK AppKey
    static final String appkey = "6e4a1518a472697372aba21b3a895608";

    // 短信模板ID，需要在短信应用中申请
    static final int templateId = 347835; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请

    // 签名
    static final String smsSign = "龙山县中医院"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`


    @Override
    public String sendSms(String phone,String code) throws Exception {
        //静态初始化数组：方法一
        //String params[] = new String[] {code};
        //静态初始化数组：方法二
        String params[] = {code};
        //动态初始化数据
//            String books[] = new String[2];
//            books[0] = "Thinking in Java";
//            books[1] = "Effective Java";
        SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
        SmsSingleSenderResult result = ssender.sendWithParam("86", phone, templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
        log.error("========>  调用腾讯云短信平台  短信发送结果日志记录 " + result);
        log.error("========>  调用腾讯云短信平台  返回状态码 " + result.getResponse().statusCode + " 以及原因 " + result.getResponse().reason);
        int statusCode = result.getResponse().statusCode;
        if (statusCode == 200)
            return code;
        log.error("========>  调用腾讯云短信平台  短信发送失败 返回状态码 " + result.getResponse().statusCode + " 以及原因 " + result.getResponse().reason);
        return "";
    }

    @Override
    public String sendSms(AuthSmsConfig authSmsConfig, String phone, String code) throws Exception {
        //静态初始化数组：方法一
        //String params[] = new String[] {code};
        //静态初始化数组：方法二
        String params[] = {code};
        //动态初始化数据
//            String books[] = new String[2];
//            books[0] = "Thinking in Java";
//            books[1] = "Effective Java";

        SmsSingleSender ssender = new SmsSingleSender( Integer.parseInt(authSmsConfig.getAccessKeyId()), authSmsConfig.getAccessKeySecret());
        SmsSingleSenderResult result = ssender.sendWithParam("86", phone, Integer.parseInt(authSmsConfig.getTemplateId()), params, authSmsConfig.getSignName(), "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
        log.error("========>  调用腾讯云短信平台  短信发送结果日志记录 " + result);
        log.error("========>  调用腾讯云短信平台  返回状态码 " + result.getResponse().statusCode + " 以及原因 " + result.getResponse().reason);
        int statusCode = result.getResponse().statusCode;
        if (statusCode == 200)
            return code;
        log.error("========>  调用腾讯云短信平台  短信发送失败 返回状态码 " + result.getResponse().statusCode + " 以及原因 " + result.getResponse().reason);
        return "";
    }
}
