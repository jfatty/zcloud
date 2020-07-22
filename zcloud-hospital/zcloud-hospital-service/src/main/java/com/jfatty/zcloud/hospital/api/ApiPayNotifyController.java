package com.jfatty.zcloud.hospital.api;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.base.utils.WePayUtil;
import com.jfatty.zcloud.hospital.constants.CCBConstants;
import com.jfatty.zcloud.hospital.entity.AlipayConfig;
import com.jfatty.zcloud.hospital.entity.WepayConfig;
import com.jfatty.zcloud.hospital.res.NumoPatientDeatilRes;
import com.jfatty.zcloud.hospital.service.AlipayConfigService;
import com.jfatty.zcloud.hospital.service.ComplexPatientService;
import com.jfatty.zcloud.hospital.service.ComplexPayService;
import com.jfatty.zcloud.hospital.service.WepayConfigService;
import com.jfatty.zcloud.hospital.utils.RSASig;
import com.jfatty.zcloud.hospital.vo.ComplexPay;
import com.jfatty.zcloud.wechat.feign.WechatFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    @Autowired
    private AlipayConfigService alipayConfigService ;

    @Autowired
    private ComplexPatientService complexPatientService ;

    @Autowired
    private WechatFeignClient wechatFeignClient ;

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
            log.error("====> 微信支付回调  " + inputString.toString());
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
                String openId = complexPayOrder.getOpenId() ;
                complexPayOrder.setTradeNo(transaction_id);
                complexPayOrder.setAsyncTime(WePayUtil.getTimeStandard(time_end));
                //如果微信回调
                if(result_code.equalsIgnoreCase("SUCCESS") && complexPayOrder.getAsync() != ComplexPay.PAY_SYNC_YES ){
                    /**========================通知微信微服务系统支付成功发送文字消息和模板消息=========================*/
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dateStr = sdf.format(new Date());
                    String content = "尊敬的用户,您于" + dateStr + "完成了一笔" +complexPayOrder.getFeeName()+"交易.您的就诊号为:" + complexPayOrder.getJzh() + "当前交易订单编号为:" + out_trade_no + "。您可以直接到相关科室检查或者药房取药,出示 缴费记录 中 我的缴费凭证条码,就可以了。" ;
                    wechatFeignClient.massSendTextByOpenId(appId,openId,content);
                    //String [] params = Stream.of("hello", "world", "ok").toArray(String[]::new);
                    String url = wepayConfig.getPaySuccessTplUrl() + out_trade_no;
                    String brid = String.valueOf(complexPayOrder.getPatientId()) ;
                    NumoPatientDeatilRes numoPatientDeatilRes = complexPatientService.getNumoPatientInfo(openId,brid);
                    String first = complexPayOrder.getFeeName() +"，已缴费成功。就诊号:"+complexPayOrder.getJzh() ;
                    String keyword1 = numoPatientDeatilRes.getName() ;
                    String keyword2 = out_trade_no ;
                    String keyword3 = complexPayOrder.getFeeAmount()  +"元" ;
                    String keyword4 = dateStr ;
                    String remark = wepayConfig.getSignName();
                    wechatFeignClient.sendTemplateMessage(appId,openId,wepayConfig.getTplId(),url,first,keyword1,keyword2,keyword3,keyword4,remark);
                }
                complexPayOrder.setAsync(ComplexPay.PAY_SYNC_YES);
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
                    complexPayService.confirmAsyncStatus(openId,2,complexPayOrder);
                Map<String, String> resMap = new HashMap<String, String>();
                resMap.put("return_code", "SUCCESS");
                resMap.put("return_msg", "支付成功");
                String xml = WePayUtil.mapToXml(resMap);
                log.error("================> 微信支付回调成功! 系统返回 [{}]===================",xml);
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
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "2018110261977161")
    })
    @ResponseBody
    @RequestMapping(value = "/alipayNotifyUrl/{appId}" , method= { RequestMethod.POST , RequestMethod.GET })
    public Object alipayNotifyUrl(HttpServletRequest request,HttpServletResponse response, @PathVariable(name = "appId" ,required = true) String  appId){
        // 1. 解析请求参数
        //获取支付宝POST过来反馈信息
        Map<String,String> params = getRequestParams(request);
        log.debug("=======>  支付宝  支付后的回调 数据 "+params.toString());
        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        //商户订单号
        String out_trade_no = params.get("out_trade_no") ;
        //支付宝交易号
        String trade_no =  params.get("trade_no") ;
        //异步通知时间
        String time_end = params.get("notify_time") ;
        //交易状态
        String trade_status = params.get("trade_status") ;
        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
        //计算得出通知验证结果
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean verify_result = false;
        try {
            AlipayConfig alipayConfig = alipayConfigService.getByAppId(appId);
            verify_result = AlipaySignature.rsaCheckV1(params,alipayConfig.getAlipayPublicKey(), alipayConfig.getPayCharset(), alipayConfig.getSignType());
            log.info("rsaCheckV1  验证结果 [{}]" , verify_result);
            if(!verify_result){
                verify_result = AlipaySignature.rsaCheckV2(params,alipayConfig.getAlipayPublicKey(), alipayConfig.getPayCharset(),alipayConfig.getSignType());
                log.info("rsaCheckV2  验证结果 [{}]" , verify_result);
            }
            if(verify_result){//验证成功
                //////////////////////////////////////////////////////////////////////////////////////////
                //请在这里加上商户的业务逻辑程序代码
                //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
                if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
                    //判断该笔订单是否在商户网站中已经做过处理
                    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                    //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                    //如果有做过处理，不执行商户的业务程序
                    //System.out.println("TRADE_FINISHED");
                    //注意：
                    //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                    //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
                    //} else if (trade_status.equals("TRADE_SUCCESS")){
                    //判断该笔订单是否在商户网站中已经做过处理
                    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                    //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                    //如果有做过处理，不执行商户的业务程序
                    //根据out_trade_no获取交易数据 从数据库中获取
                    ComplexPay complexPayOrder = complexPayService.getPayRecordByOutTradeNo(out_trade_no);
                    complexPayOrder.setTradeNo(trade_no);//未支付成功之前设置为空字符串
                    //需要异步同步his系统中的支付状态
                    complexPayOrder.setAsync(ComplexPay.PAY_SYNC_YES); //已同步
                    complexPayOrder.setPayState(ComplexPay.PAY_STATE_SUCCESS);  //支付状态  成功
                    complexPayOrder.setRemark("本次交易已经成功完成!");
                    complexPayOrder.setPayParam(""); //将页面要用到的支付信息从数据库中清除
                    complexPayOrder.setAsyncTime(time_end);
                    log.error("=====通知HIS系统支付成功============支付宝=======查询本地数据的支付信息====="+complexPayOrder);
                    /**
                     * 通知 HIS 系统 支付结果(这是一个异步方法) jfatty 2017-11-17
                     * @param outTradeNo 本地系统唯一订单号
                     * @param feeType 费用类型 门诊支付、住院预付、挂号付款
                     * @param brid  病人id  HIS系统中的病人id
                     * @param fydh  费用订单   HIS系统中的费用单号
                     * @param fkfs  付款方式   支付宝、微信
                     * @param rq    日期   异步通知的时间
                     * @param ssje  实收金额（元）
                     * @param fkzt  付款状态（为1时表示付款成功）
                     * @param zybh  住院编号
                     * @return
                     */
                    try {
                        complexPayService.payAsync(complexPayOrder);                                         //异步通知，改变状态
                    } catch (Exception e) {
                        log.error("支付宝 支付成功 异步通知，改变状态 出现异常 商户订单号为:[{}] 异常信息:[{}]" , out_trade_no ,e.getMessage());
                    }
                    /**=====通知HIS系统支付成功============================================*/
                    //支付成功回调  判断是否已经同步过HIS了 没同步则需要进行同步操作
                    if(complexPayOrder.getPayState() == ComplexPay.PAY_STATE_SUCCESS && complexPayOrder.getHisAsync() == ComplexPay.HIS_SYNC_NO)
                        complexPayService.confirmAsyncStatus(complexPayOrder.getOpenId(),1,complexPayOrder);
                    //注意：
                    //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
                }
                //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
                //out.clear();
                //out.println("success");	//请不要修改或删除
                return "success" ;
                //////////////////////////////////////////////////////////////////////////////////////////
            }else{//验证失败
                //out.println("fail");
                log.error("支付宝验证失败 商户订单号[{}]",out_trade_no);
                return "fail" ;
            }
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            //支付宝验证出错
            e.printStackTrace();
            log.error("支付宝验证出错 [{}]",e.getErrMsg());
        } catch ( Exception e) {
            log.error("支付宝支付异步通知时 同步HIS操作出现异常 [{}]",e.getMessage());
        }
        return "fail" ;
    }

    /**
     * 获取所有request请求参数key-value
     * @param request
     * @return
     */
    private Map<String, String> getRequestParams(HttpServletRequest request){
        Map<String, String> params = new HashMap<String, String>();
        if(null != request){
            Set<String> paramsKey = request.getParameterMap().keySet();
            for(String key : paramsKey){
                params.put(key, request.getParameter(key));
            }
        }
        return params;
    }

    @ApiOperation(value="003*** 手动异步通知HIS系统订单支付成功")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "outTradeNo", value = "交易订单号",dataType = "String",defaultValue = "WC201909261150360002"),
            @ApiImplicitParam(name = "openIdType", value = "微信 2 支付宝 1 APP 3 openId 类型",dataType = "Integer",defaultValue = "2")
    })
    @RequestMapping(value="/asyncLocalTrade2HIS", method=RequestMethod.GET)
    @ResponseBody
    public RETResultUtils<Boolean> asyncLocalTrade2HIS(@RequestParam(value = "outTradeNo" , defaultValue = "WC201909216150360002") String outTradeNo , @RequestParam(value = "openIdType" , defaultValue = "2") Integer openIdType){
        if(StringUtils.isEmptyOrBlank(outTradeNo))
            return RETResultUtils._509("交易订单号不能为空!");
        ComplexPay complexPayOrder = complexPayService.getPayRecordByOutTradeNo(outTradeNo);
        try {
            if (complexPayOrder != null){
                if(complexPayOrder.getPayState() == ComplexPay.PAY_STATE_SUCCESS && complexPayOrder.getHisAsync() == ComplexPay.HIS_SYNC_NO)
                    complexPayService.confirmAsyncStatus(complexPayOrder.getOpenId(),openIdType,complexPayOrder);
                return new RETResultUtils(true);
            }
            return RETResultUtils._506("未查询到对应交易订单");
        } catch (Exception e) {
            e.printStackTrace();
            return RETResultUtils._506(e.getMessage());
        }
    }


    /**
     * http://weixin.hnlsxzyy.com/
     * 建行服务器异步通知
     * @author jfatty 2020-07-20
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value="004***建行服务器异步通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mchId", value = "建行对应的商户ID mchId",dataType = "String",defaultValue = "105000080621818")
    })
    @RequestMapping(value = "/ccbNotifyUrl/{mchId}" , method= { RequestMethod.POST , RequestMethod.GET })
    public void ccbNotifyUrl(HttpServletRequest request,HttpServletResponse response, @PathVariable(name = "mchId" ,required = true) String  mchId){
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuilder data = new StringBuilder();
        while (parameterNames.hasMoreElements()) {
            String name = (String) parameterNames.nextElement();
            String value = request.getParameter(name);
            map.put(name, value);
            data.append(name).append("=").append(value).append("&");
        }
        log.error(" ccbNotifyUrl 建行返回调原数据:[{}]",data.toString());
        StringBuilder sb = new StringBuilder();
        //POSID=000000000&BRANCHID=110000000&ORDERID=19991101234&PAYMENT=500.00&CURCODE=01&REMARK1=&REMARK2=&
        // ACC_TYPE=12&SUCCESS=Y&TYPE=1&REFERER=http://www.ccb.com/index.jsp&CLIENTIP=172.0.0.1&
        // ACCDATE=20100907&USRMSG=T4NJx%2FVgocRsLyQnrMZLyuQQkFzMAxQjdqyzf6pM%2Fcg%3D&
        // USRINFO= T4NJx%2FVgocRsLyQnrMZLyuQQkFzMAxQjdqyzf6pM%2Fcg%3D&PAYTYPE= ALIPAY&SIGN=
        // 以下字段只有在满足条件的情况下才参与签名。
        //TYPE、REFERER、CLIENTIP 、ACC_TYPE、ACCDATE、USRMSG、USRINFO、PAYTYPE
        sb.append("POSID=").append(map.get("POSID")).append("&BRANCHID=").append(map.get("BRANCHID"))
                .append("&ORDERID=").append(map.get("ORDERID")).append("&PAYMENT=").append(map.get("PAYMENT"))
                .append("&CURCODE=").append(map.get("CURCODE")).append("&REMARK1=").append(map.get("REMARK1"))
                .append("&REMARK2=").append(map.get("REMARK2"));
        if (StringUtils.isNotEmptyAndBlank(map.get("ACC_TYPE"))){
            sb.append("&ACC_TYPE=").append(map.get("ACC_TYPE")) ;
        }
        sb.append("&SUCCESS=").append(map.get("SUCCESS")) ;
        if (StringUtils.isNotEmptyAndBlank(map.get("TYPE"))){
            sb.append("&TYPE=").append(map.get("TYPE")) ;
        }
        if (StringUtils.isNotEmptyAndBlank(map.get("REFERER"))){
            sb.append("&REFERER=").append(map.get("REFERER"));
        }
        if (StringUtils.isNotEmptyAndBlank(map.get("CLIENTIP"))){
            sb.append("&CLIENTIP=").append(map.get("CLIENTIP"));
        }
        if (StringUtils.isNotEmptyAndBlank(map.get("ACCDATE"))){
            sb.append("&ACCDATE=").append(map.get("ACCDATE"));
        }
        if (StringUtils.isNotEmptyAndBlank(map.get("USRMSG"))){
            sb.append("&USRMSG=").append(map.get("USRMSG"));
        }
        if (StringUtils.isNotEmptyAndBlank(map.get("USRINFO"))){
            sb.append("&USRINFO=").append(map.get("USRINFO"));
        }
        if (StringUtils.isNotEmptyAndBlank(map.get("PAYTYPE"))){
            sb.append("&PAYTYPE=").append(map.get("PAYTYPE"));
        }
        RSASig rsaSig = new RSASig();
        rsaSig.setPublicKey(CCBConstants.PUBLICKEY);// 公钥
        boolean flag = rsaSig.verifySigature(map.get("SIGN"), sb.toString());

        log.error("===> verifySigature 签名验证是否成功 [{}]",flag);
        //获取交易订单ID
        String orderId = map.get("ORDERID") ;
        String SUCCESS = map.get("SUCCESS") ;
        String ACCDATE = map.get("ACCDATE") ;

        //生成同步时间
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter fmt24 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String asyncTime = dateTime.format(fmt24);

        if ( "Y".equals(SUCCESS) && flag ) {
            ComplexPay complexPayOrder = complexPayService.getPayRecordByOutTradeNo(orderId);
            String openId = complexPayOrder.getOpenId() ;
            Integer payWay = complexPayOrder.getPayWay();

            complexPayOrder.setTradeNo(orderId);//未支付成功之前设置为空字符串
            //需要异步同步his系统中的支付状态
            complexPayOrder.setAsync(ComplexPay.PAY_SYNC_YES); //已同步
            complexPayOrder.setPayState(ComplexPay.PAY_STATE_SUCCESS);  //支付状态  成功

            if (StringUtils.isNotEmptyAndBlank(ACCDATE)) {
                complexPayOrder.setRemark(ACCDATE);
            } else {
                complexPayOrder.setRemark("建行支付本次交易已经成功完成!");
            }

            //complexPayOrder.setPayParam(""); //将页面要用到的支付信息从数据库中清除
            complexPayOrder.setAsyncTime(asyncTime);
            log.error("=====通知HIS系统支付成功============建行=======查询本地数据的支付信息====="+complexPayOrder);
            /**
             * 通知 HIS 系统 支付结果(这是一个异步方法) jfatty 2017-11-17
             * @param outTradeNo 本地系统唯一订单号
             * @param feeType 费用类型 门诊支付、住院预付、挂号付款
             * @param brid  病人id  HIS系统中的病人id
             * @param fydh  费用订单   HIS系统中的费用单号
             * @param fkfs  付款方式   支付宝、微信
             * @param rq    日期   异步通知的时间
             * @param ssje  实收金额（元）
             * @param fkzt  付款状态（为1时表示付款成功）
             * @param zybh  住院编号
             * @return
             */
            try {
                complexPayService.payAsync(complexPayOrder);                                         //异步通知，改变状态
            } catch (Exception e) {
                log.error("建行 支付成功 异步通知，改变状态 出现异常 商户订单号为:[{}] 异常信息:[{}]" , orderId ,e.getMessage());
            }

            if (payWay == ComplexPay.PAY_WAY_WECHAT ) { //微信支付要发模板消息
                WepayConfig wepayConfig = wepayConfigService.getByAppId(CCBConstants.WX_APPID);

                /**========================通知微信微服务系统支付成功发送文字消息和模板消息=========================*/
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateStr = sdf.format(new Date());
                String content = "尊敬的用户,您于" + dateStr + "完成了一笔" +complexPayOrder.getFeeName()+"交易.您的就诊号为:" + complexPayOrder.getJzh() + "当前交易订单编号为:" + orderId + "。您可以直接到相关科室检查或者药房取药,出示 缴费记录 中 我的缴费凭证条码,就可以了。" ;
                wechatFeignClient.massSendTextByOpenId(CCBConstants.WX_APPID,openId,content);
                //String [] params = Stream.of("hello", "world", "ok").toArray(String[]::new);
                String url = wepayConfig.getPaySuccessTplUrl() + orderId;
                String brid = String.valueOf(complexPayOrder.getPatientId()) ;
                NumoPatientDeatilRes numoPatientDeatilRes = complexPatientService.getNumoPatientInfo(openId,brid);
                String first = complexPayOrder.getFeeName() +"，已缴费成功。就诊号:"+complexPayOrder.getJzh() ;
                String keyword1 = numoPatientDeatilRes.getName() ;
                String keyword2 = orderId ;
                String keyword3 = complexPayOrder.getFeeAmount()  +"元" ;
                String keyword4 = dateStr ;
                String remark = wepayConfig.getSignName();
                wechatFeignClient.sendTemplateMessage(CCBConstants.WX_APPID,openId,wepayConfig.getTplId(),url,first,keyword1,keyword2,keyword3,keyword4,remark);

            }
            /**=====通知HIS系统支付成功============================================*/
            //支付成功回调  判断是否已经同步过HIS了 没同步则需要进行同步操作
            if(complexPayOrder.getPayState() == ComplexPay.PAY_STATE_SUCCESS && complexPayOrder.getHisAsync() == ComplexPay.HIS_SYNC_NO) {
                try {
                    if (payWay == ComplexPay.PAY_WAY_ZFB) {
                        complexPayService.confirmAsyncStatus(complexPayOrder.getOpenId(),1,complexPayOrder);
                    }
                    if (payWay == ComplexPay.PAY_WAY_WECHAT ) {
                        complexPayService.confirmAsyncStatus(complexPayOrder.getOpenId(),2,complexPayOrder);
                    }
                } catch (Exception e) {
                    log.error("通知HIS系统支付成功===>出现异常[{}]",e.getMessage());
                }
            }
        }

        //最后重定向到订单详情页面
        try {
            //WC202007211432190004
            response.sendRedirect("http://weixin.hnlsxzyy.com/payResult?outTradeNo="+orderId);
        } catch (IOException e) {
            log.error("返回建行页面通知时,重定向页面跳转异常 [{}]",e.getMessage());
        }

    }

}
