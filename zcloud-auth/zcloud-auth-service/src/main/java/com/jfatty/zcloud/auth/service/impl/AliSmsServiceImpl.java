package com.jfatty.zcloud.auth.service.impl;


import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.exceptions.ClientException;
import com.jfatty.zcloud.auth.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * 描述
 *
 * @author jfatty on 2019/12/14
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class AliSmsServiceImpl implements SmsService {

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIbVXcCV7BPdgu";
    static final String accessKeySecret = "pKHTygWtkXqCuK10L33Q5zXZYZWnU5";


    @Override
    public String sendSms(String phone,String code) throws Exception {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化acsClient,暂不支持region化
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        //DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象-具体描述见控制台-文档部分内容
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //必填:待发送手机号
        request.putQueryParameter("PhoneNumbers", phone);
        //必填:短信签名-可在短信控制台中找到
        request.putQueryParameter("SignName", "鹤峰县中心医院");
        //必填:短信模板-可在短信控制台中找到
        request.putQueryParameter("TemplateCode", "SMS_130914739");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.putQueryParameter("OutId", "hfxzxyy");
        try {
            //hint 此处可能会抛出异常，注意catch
            CommonResponse response = acsClient.getCommonResponse(request);
            log.info("阿里云短信发送返回类容  " +  response.getData() );
            return response.getData() ;
        } catch (ServerException e) {
            log.info("阿里云短信发送出错  阿里云异常 [{}]" , e.getMessage() );
            return e.getMessage();
        } catch (ClientException e) {
            log.info("阿里云短信发送出错  客户端异常 [{}]" , e.getMessage() );
            return e.getMessage();
        }


    }
}
