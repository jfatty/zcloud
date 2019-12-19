package com.jfatty.zcloud.alipay.api;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.jfatty.zcloud.alipay.entity.AlipayAuthCode;
import com.jfatty.zcloud.alipay.entity.AlipayConfig;
import com.jfatty.zcloud.alipay.service.AlipayAuthCodeService;
import com.jfatty.zcloud.alipay.service.AlipayConfigService;
import com.jfatty.zcloud.alipay.service.AlipayCoreService;
import com.jfatty.zcloud.alipay.utils.RequestUtil;
import com.jfatty.zcloud.base.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */
@Slf4j
@Controller
@RequestMapping("/api")
public class ApiAlipayServiceWindowController {


    @Autowired
    private AlipayCoreService alipayCoreService;

    @Autowired
    private AlipayConfigService alipayConfigService ;

    @Autowired
    private AlipayAuthCodeService alipayAuthCodeService ;

    @RequestMapping(value="/alipay/OAuth", method= { RequestMethod.GET,RequestMethod.POST } )
    @ResponseBody
    public ResultUtils wxOAuth(@RequestParam(value = "code" , defaultValue = "code") String code ,
                               @RequestParam(value = "appId" , defaultValue = "appId" ) String appId ){
        log.error(" ====>  当前支付宝生活号 appId [{}] ",appId);
        try {
            AlipayAuthCode alipayAuthCode = alipayAuthCodeService.getByAuthCode(code,appId);
            log.error(" ====>  通过当支付宝生活号 appId 获取到的 alipayOpenId [{}]",alipayAuthCode.getId());
            return ResultUtils.build(200, "SUCCESS",alipayAuthCode.getId()) ;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.build(500, e.getMessage()) ;
        }
    }

    /**
     * basepath /ZFBOauth/alipayOauth.action
     * alipay/oauth
     * @author jfatty 2017-11-07
     * 支付宝  授权回调地址
     *
     * @return  认证后 页面跳转
     */
    @RequestMapping(value = { "/alipay/oauth" },method = { RequestMethod.GET , RequestMethod.POST})
    public void oauth(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 解析请求参数
        Map<String, String> params = RequestUtil.getRequestParams(request);
        // 打印本次请求日志，开发者自行决定是否需要
        log.info("支付宝授权请求串", params.toString());
        // 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        // 支付宝用户号
        String app_id = params.get("app_id");
        // 获取第三方登录授权
        String alipay_app_auth = params.get("source");
        //第三方授权code
        String app_auth_code =  params.get("app_auth_code");
        //2. 获得authCode
        String auth_code =  params.get("auth_code");
        String page =  params.get("page");

        AlipayConfig config = alipayConfigService.getAlipayConfig(app_id);
        AlipayClient alipayClient = new DefaultAlipayClient(config.getAlipayGateway(),config.getAppid(),config.getPrivateKey(),//
                config.getAlipayFormat(),config.getSignCharset(),config.getAlipayPublicKey(),//
                config.getSignType());
        AlipaySystemOauthTokenRequest alipayRequest = new AlipaySystemOauthTokenRequest();
        alipayRequest.setCode(auth_code);
        alipayRequest.setGrantType(config.getGrantType());
        try {
            //第三方授权
            //3. 利用authCode获得authToken
            AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(alipayRequest);
//			System.out.println("getAccessToken-"+oauthTokenResponse.getAccessToken());
//			System.out.println("getAlipayUserId-"+oauthTokenResponse.getAlipayUserId());
//			System.out.println("getUserId-"+oauthTokenResponse.getUserId());
            //成功获得authToken
            if( null != oauthTokenResponse && oauthTokenResponse.isSuccess()){
                //4. 利用authToken获取用户信息
                AlipayUserInfoShareRequest userinfoShareRequest = new AlipayUserInfoShareRequest();
                AlipayUserInfoShareResponse userinfoShareResponse = alipayClient
                        .execute(userinfoShareRequest, oauthTokenResponse.getAccessToken());
                //成功获得用户信息
                if (null != userinfoShareResponse && userinfoShareResponse.isSuccess()) {
                    //这里仅是简单打印， 请开发者按实际情况自行进行处理
                    System.out.println("获取用户信息成功：" + userinfoShareResponse.getBody());
                } else {
                    //这里仅是简单打印， 请开发者按实际情况自行进行处理
                    System.out.println("获取用户信息失败");
                }

                AlipayAuthCode alipayAuthCode = new AlipayAuthCode();
                alipayAuthCode.setId(oauthTokenResponse.getUserId());
                alipayAuthCode.setAuthCode(auth_code);
                alipayAuthCode.setAppid(app_id);
                alipayAuthCodeService.saveOrUpdate(alipayAuthCode);
                log.debug("accessToken  ====>" + oauthTokenResponse.getAccessToken());
                log.error(" alipayOpenId 存入当前会话 ====>"+oauthTokenResponse.getUserId());
                session.setAttribute("alipayOpenId", oauthTokenResponse.getUserId());
                log.error("支付宝认证之后重定向页面路径====>"+page);
                page = page + "?code=" + auth_code ;
                response.sendRedirect(page);
            }else {
                /**
                 * 支付宝授权认证未成功
                 * 重定向到错误页面
                 */
                page = "" ;
                log.error("authCode换取authToken失败 支付宝授权失败之后重定向页面路径====>"+page);
                response.sendRedirect(page);
            }
        } catch (AlipayApiException e) {
            //处理异常
            e.printStackTrace();
        }
    }

    /**
     * @author jfatty 2017-11-4
     * 应用网关支付宝用来验证和开发者对接的门户
     * @param request
     * @param response
     * @return 返回xml数据
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value={"/alipay/gateway/{appid}"},method = RequestMethod.POST , produces = "text/xml;charset=GBK")
    @ResponseBody
    public String gateway(HttpServletRequest request, HttpServletResponse response,@PathVariable String appid) throws ServletException,IOException {
        //支付宝响应消息
        String responseMsg = "";
        //动态初始化支付宝服务窗参数，包括APPID,PUBLIC_KEY,ALIPAY_PUBLIC_KEY
        AlipayConfig config = alipayConfigService.getAlipayConfig(appid);
        if(config == null){
            Exception e = new Exception("未获取到账号配置信息");
            e.printStackTrace();
            return responseMsg ;
        }
        //1. 解析请求参数
        Map<String, String> params = RequestUtil.getRequestParams(request);
        // 打印本次请求日志，开发者自行决定是否需要
        log.info("支付宝授权请求串" + params.toString());

        try {
            //2. 验证签名
            this.verifySign(params,config);
            //3. 获取业务执行器   根据请求中的 service, msgType, eventType, actionParam 确定执行器
            responseMsg = alipayCoreService.excute(params,config) ;
            if(responseMsg == null){
                responseMsg = "";
            }
        } catch (AlipayApiException e) {
            //开发者可以根据异常自行进行处理
            e.printStackTrace();
        } catch (Exception e) {
            //开发者可以根据异常自行进行处理
            e.printStackTrace();
        } finally {
            //5. 响应结果加签及返回
            try {
                //对响应内容加签
                responseMsg = encryptAndSign(responseMsg,
                        config.getAlipayPublicKey(),
                        config.getPrivateKey() ,config.getSignCharset(),
                        false, true,config.getSignType());
                //开发者自行决定是否要记录，视自己需求
                log.info("开发者响应串" + responseMsg);
                return responseMsg ;
            } catch (AlipayApiException e) {
                //开发者可以根据异常自行进行处理
                e.printStackTrace();
            }
        }
        return responseMsg ;
    }


    /**
     * 验签
     * @author jfatty 2017-11-4
     * @param params
     * @param config
     * @return
     */
    private void verifySign(Map<String, String> params, AlipayConfig config) throws AlipayApiException {
        if (!AlipaySignature.rsaCheckV2(params, config.getAlipayPublicKey(),
                config.getSignCharset(), config.getSignType())) {
            throw new AlipayApiException("verify sign fail.");
        }
    }
    /**
     * 数据加解操作
     * @author jfatty 2017-11-4
     * @param bizContent
     * @param alipayPublicKey
     * @param cusPrivateKey
     * @param charset
     * @param isEncrypt
     * @param isSign
     * @param signType
     * @return
     * @throws AlipayApiException
     */
    public static String encryptAndSign(String bizContent, String alipayPublicKey, String cusPrivateKey, String charset,
                                        boolean isEncrypt, boolean isSign, String signType) throws AlipayApiException {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isEmpty(charset)) {
            charset = AlipayConstants.CHARSET_GBK;
        }
        sb.append("<?xml version=\"1.0\" encoding=\"" + charset + "\"?>");
        if (isEncrypt) {// 加密
            sb.append("<alipay>");
            String encrypted = AlipaySignature.rsaEncrypt(bizContent, alipayPublicKey, charset);
            sb.append("<response>" + encrypted + "</response>");
            sb.append("<encryption_type>AES</encryption_type>");
            if (isSign) {
                String sign = AlipaySignature.rsaSign(encrypted, cusPrivateKey, charset, signType);
                sb.append("<sign>" + sign + "</sign>");
                sb.append("<sign_type>");
                sb.append(signType);
                sb.append("</sign_type>");
            }
            sb.append("</alipay>");
        } else if (isSign) {// 不加密，但需要签名
            sb.append("<alipay>");
            sb.append("<response>" + bizContent + "</response>");
            String sign = AlipaySignature.rsaSign(bizContent, cusPrivateKey, charset, signType);
            sb.append("<sign>" + sign + "</sign>");
            sb.append("<sign_type>");
            sb.append(signType);
            sb.append("</sign_type>");
            sb.append("</alipay>");
        } else {// 不加密，不加签
            sb.append(bizContent);
        }
        return sb.toString();
    }



}
