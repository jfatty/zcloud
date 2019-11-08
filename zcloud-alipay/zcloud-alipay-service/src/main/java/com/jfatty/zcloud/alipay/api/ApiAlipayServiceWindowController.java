package com.jfatty.zcloud.alipay.api;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.jfatty.zcloud.alipay.entity.AlipayConfig;
import com.jfatty.zcloud.alipay.service.AlipayConfigService;
import com.jfatty.zcloud.alipay.service.AlipayCoreService;
import com.jfatty.zcloud.alipay.utils.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


    /**
     * @author jfatty 2017-11-4
     * 应用网关支付宝用来验证和开发者对接的门户
     * @param request
     * @param response
     * @return 返回xml数据
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value={"/alipay/{appid}/gateway"},method = RequestMethod.POST , produces = "text/xml;charset=GBK")
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
        log.info("支付宝授权请求串", params.toString());

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
                responseMsg = AlipaySignature.encryptAndSign(responseMsg,
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
                config.getPayCharset(), config.getSignType())) {
            throw new AlipayApiException("verify sign fail.");
        }
    }


}
