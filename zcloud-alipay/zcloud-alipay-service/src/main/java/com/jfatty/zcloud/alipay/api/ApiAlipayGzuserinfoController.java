package com.jfatty.zcloud.alipay.api;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserUserinfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserUserinfoShareResponse;
import com.jfatty.zcloud.alipay.entity.AlipayConfig;
import com.jfatty.zcloud.alipay.entity.AlipayGzuserinfo;
import com.jfatty.zcloud.alipay.interfaces.IAlipayGzuserinfo;
import com.jfatty.zcloud.alipay.req.AlipayGzuserinfoReq;
import com.jfatty.zcloud.alipay.res.AlipayGzuserinfoRes;
import com.jfatty.zcloud.alipay.service.AlipayConfigService;
import com.jfatty.zcloud.alipay.service.AlipayGzuserinfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述
 *
 * @author jfatty on 2019/11/11
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/alipayGzuserinfo"})
public class ApiAlipayGzuserinfoController extends ApiBaseAlipayController<AlipayGzuserinfo,AlipayGzuserinfoReq,AlipayGzuserinfoRes>  implements IAlipayGzuserinfo {

    private AlipayGzuserinfoService alipayGzuserinfoService ;

    @Autowired
    private AlipayConfigService alipayConfigService ;

    @Autowired
    public void setAlipayGzuserinfoService(AlipayGzuserinfoService alipayGzuserinfoService) {
        super.setBaseService(alipayGzuserinfoService);
        this.alipayGzuserinfoService = alipayGzuserinfoService;
    }

    /**
     * author2.0 授权回调测试方法
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "/userinfo",method ={RequestMethod.GET, RequestMethod.POST})
    public Object userinfo(HttpServletRequest request, HttpServletResponse response)throws Exception{
        // 支付宝用户号
        String app_id = request.getParameter("app_id");
        String authcode = request.getParameter("auth_code");
        String scope = request.getParameter("scope");
        AlipaySystemOauthTokenRequest alipayrequest = new AlipaySystemOauthTokenRequest();
        alipayrequest.setCode(authcode);
        alipayrequest.setGrantType("authorization_code");

        AlipayConfig config = alipayConfigService.getAlipayConfig(app_id);
        AlipayClient alipayClient = new DefaultAlipayClient(config.getAlipayGateway(),config.getAppid(),config.getPrivateKey(),//
                config.getAlipayFormat(),config.getSignCharset(),config.getAlipayPublicKey(),//
                config.getSignType());
        AlipaySystemOauthTokenResponse alipayresponse = alipayClient.execute(alipayrequest);
        if(null != alipayresponse && alipayresponse.isSuccess()){
            AlipayGzuserinfo userinfo = new AlipayGzuserinfo();
            if("auth_userinfo".equals(scope)){
                String token =  alipayresponse.getAccessToken();
                AlipayUserUserinfoShareRequest sharerequest = new AlipayUserUserinfoShareRequest();
                sharerequest.putOtherTextParam("auth_token", token);
                //update-begin--author:zhangjiaqiang Date:20161108 for:#1487 【开源项目】开源支付窗服务窗单公众号项目
                AlipayUserUserinfoShareResponse shareresponse = alipayClient.execute(sharerequest);
                //update-end--author:zhangjiaqiang Date:20161108 for:#1487 【开源项目】开源支付窗服务窗单公众号项目

                System.out.println("获取用户信息成功：" + shareresponse.getBody());

                userinfo.setName(shareresponse.getNickName());
                userinfo.setProvince(shareresponse.getProvince());
                userinfo.setAvatar(shareresponse.getAvatar());
                userinfo.setEmail(shareresponse.getEmail());
                userinfo.setPosition(shareresponse.getCity());
                userinfo.setGender(shareresponse.getGender());
            }
            userinfo.setUserid(alipayresponse.getUserId());
            return  userinfo ;
        }
        return "没有获取到用户系息" ;
    }
}
