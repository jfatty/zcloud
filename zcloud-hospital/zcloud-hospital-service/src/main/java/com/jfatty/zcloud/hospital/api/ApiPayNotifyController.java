package com.jfatty.zcloud.hospital.api;

import com.jfatty.zcloud.base.utils.WePayUtil;
import com.jfatty.zcloud.hospital.entity.WepayConfig;
import com.jfatty.zcloud.hospital.service.ComplexPayService;
import com.jfatty.zcloud.hospital.service.WepayConfigService;
import com.jfatty.zcloud.hospital.vo.ComplexPay;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/19
 * @email jfatty@163.com
 */
@Api(tags = "支付平台异步通知API" ,value = "支付平台异步通知")
@Slf4j
@Controller
@RequestMapping("/api/payNotify")
public class ApiPayNotifyController {

    @Autowired
    private ComplexPayService complexPayService ;

    @Autowired
    private WepayConfigService wepayConfigService ;

    /**
     * @Description 微信支付回调接口
     * @author LiaoYun 2017年10月31日
     * @param request
     * @param response
     * @return void
     */
    @ApiOperation(value="001***微信支付回调接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wx4712402349f957a4")
    })
    @ResponseBody
    @RequestMapping(value="/wechatPayNotify/{appId}", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
    public String wechatPayNotify(HttpServletRequest request, HttpServletResponse response, @PathVariable(name = "appId" ,required = true) String  appId){
        try {
            BufferedReader reader = request.getReader();
            StringBuffer inputString = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                inputString.append(line);
            }
            log.debug("====> 微信支付回调  " + inputString.toString());
            Map<String, String> resultMap = WePayUtil.doXMLParse(inputString.toString());
            String return_code = resultMap.get("return_code");                      //此字段是通信标识
            if(return_code != null && return_code.equalsIgnoreCase("SUCCESS")){
                WepayConfig wepayConfig = wepayConfigService.getByAppId(appId);
                //根据返回的参数生成签名，且必须去除掉返回参数中的sign
                String signs = WePayUtil.getSign(resultMap, wepayConfig.getPayKey(), request, response);
                String sign = resultMap.get("sign");
                if(!sign.equals(signs)){                                            //签名校验失败
                    log.error("====> 微信支付回调, 签名校验失败!  =====================");
                    Map<String, String> resMap = new HashMap<String, String>();
                    resMap.put("return_code", "FAIL");
                    resMap.put("return_msg", "");
                    String xml = WePayUtil.mapToXml(resMap);
                    return xml;
                }
                String result_code = resultMap.get("result_code");                  //支付状态 SUCCESS/FAIL
                String transaction_id = resultMap.get("transaction_id");            //微信支付订单号
                String out_trade_no = resultMap.get("out_trade_no");                //订单编号
                String time_end = resultMap.get("time_end");
                ComplexPay complexPayOrder = complexPayService.getPayRecordByOutTradeNo(out_trade_no);
                complexPayOrder.setTradeNo(transaction_id);
                complexPayOrder.setAsync(ComplexPay.PAY_SYNC_YES);
                complexPayOrder.setAsyncTime(WePayUtil.getTimeStandard(time_end));
                if(result_code.equalsIgnoreCase("SUCCESS")){
                    complexPayOrder.setPayState(ComplexPay.PAY_STATE_SUCCESS);
                } else if (result_code.equalsIgnoreCase("FAIL")) {
                    complexPayOrder.setPayState(ComplexPay.PAY_STATE_FAILD);
                } else {
                    complexPayOrder.setPayState(ComplexPay.PAY_STATE_UNNKNOWN);
                }
                //异步到本地系统
                complexPayService.payAsync(complexPayOrder);              //异步通知，改变状态
                /**========================通知HIS系统支付成功=========================*/
                //支付成功回调  判断是否已经同步过HIS了 没同步则需要进行同步操作
                if(result_code.equalsIgnoreCase("SUCCESS") && complexPayOrder.getPayState() == ComplexPay.PAY_STATE_SUCCESS && complexPayOrder.getHisAsync() == ComplexPay.HIS_SYNC_NO )
                    complexPayService.confirmAsyncStatus(complexPayOrder.getOpenId(),complexPayOrder.getCreatedType(),complexPayOrder);
                Map<String, String> resMap = new HashMap<String, String>();
                resMap.put("return_code", "SUCCESS");
                resMap.put("return_msg", "支付成功");
                String xml = WePayUtil.mapToXml(resMap);
                return xml ;
            } else if (return_code != null && return_code.equalsIgnoreCase("FAIL")) {
                log.error("====ELSE=====IF=======> 微信支付回调通信失败! ===return_code===[{}]",return_code);
                Map<String, String> resMap = new HashMap<String, String>();
                resMap.put("return_code", "FAIL");
                resMap.put("return_msg", "网络异常,请稍后重试!");
                String xml = WePayUtil.mapToXml(resMap);
                return xml;
            } else {
                log.error("================> 微信支付回调通信失败! ===================");
                Map<String, String> resMap = new HashMap<String, String>();
                resMap.put("return_code", "FAIL");
                resMap.put("return_msg", "网络异常,请稍后重试!");
                String xml = WePayUtil.mapToXml(resMap);
                return xml;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("====> 微信支付回调 出现异常: " + e.getMessage());
            Map<String, String> resMap = new HashMap<String, String>();
            resMap.put("return_code", "FAIL");
            resMap.put("return_msg", "网络异常,请稍后重试!E");
            String xml = WePayUtil.mapToXml(resMap);
            return xml;
        }
    }

    /**
     * 支付宝服务器异步通知
     * @author jfatty 2017-11-7
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value="002***支付宝服务器异步通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wx4712402349f957a4")
    })
    @ResponseBody
    @RequestMapping(value = "/alipayNotifyUrl/{appId}" , method= { RequestMethod.POST , RequestMethod.GET })
    public Object alipayNotifyUrl(HttpServletRequest request,HttpServletResponse response, @PathVariable(name = "appId" ,required = true) String  appId){
        return "success" ;
    }

}
