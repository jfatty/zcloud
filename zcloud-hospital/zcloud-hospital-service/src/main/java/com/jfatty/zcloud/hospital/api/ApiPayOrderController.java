package com.jfatty.zcloud.hospital.api;

import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.base.utils.WePayUtil;
import com.jfatty.zcloud.hospital.entity.WepayConfig;
import com.jfatty.zcloud.hospital.req.PayOrderCreateReq;
import com.jfatty.zcloud.hospital.service.ComplexPayService;
import com.jfatty.zcloud.hospital.service.WepayConfigService;
import com.jfatty.zcloud.hospital.utils.IPUtil;
import com.jfatty.zcloud.hospital.vo.ComplexPay;
import com.jfatty.zcloud.hospital.vo.InHospitalInfo;
import com.jfatty.zcloud.hospital.vo.TotalUnPayOutpatient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.*;

@Api(tags = "支付订单API" ,value = "支付订单")
@Slf4j
@RestController
@RequestMapping("/api/payOrder")
public class ApiPayOrderController {

    @Autowired
    private ComplexPayService complexPayService ;

    @Autowired
    private WepayConfigService wepayConfigService ;


    //创建支付订单
    @ApiOperation(value="001******创建支付订单")
    @RequestMapping(value = {"/createPayOrder"} ,method = RequestMethod.POST)
    public RETResultUtils<Map<String,Object>> createPayOrder(@RequestBody PayOrderCreateReq payOrderCreateReq , HttpServletRequest request , HttpServletResponse response){
        String openId = payOrderCreateReq.getOpenId() ;
        Integer openIdType = payOrderCreateReq.getOpenIdType() ;
        String appId = payOrderCreateReq.getAppId();
        String djh = payOrderCreateReq.getHisNo() ;
        String brid = payOrderCreateReq.getBrid() ;
        String jzh = payOrderCreateReq.getJzh();                                                //获取就诊号
        /**===============判断支付类型，根据不同的支付类型来查询对应的订单详情====================*/
        String feeAmountStr = "";                                                               //费用金额
        String feeName = "";                                                                    //费用名称
        int feeType = payOrderCreateReq.getFeeType();                                           //费用类型 如 门诊缴费、挂号缴费、住院预缴
        boolean isHisPay = false;                                                               //HIS系统中的支付状态， 是否已经支付过了
        String sfh = "" ;                                                                       //his系统中的收费号
        String long_djh = "" ;                                                                  //本地拼接的流水号 存在逗号拼接的情况 费用单号
        if(feeType == ComplexPay.FEE_TYPE_MZ){
            log.debug("====> getPrepareId 门诊缴费!");
            TotalUnPayOutpatient totalUnPayOutpatient = complexPayService.getMZPay(openId, openIdType,djh,brid);
            log.error("====> 查询订单信息! brid = " + brid + " 流水号djh=" + djh + "msg=his系统中未查到该订单");
            if(totalUnPayOutpatient == null )
                return RETResultUtils._506("his系统中未查到该订单");
            //获取费用单号
            long_djh = totalUnPayOutpatient.getFydh();                                           //流水号 住院号 逗号拼接
            if (StringUtils.isNotEmptyAndBlank( totalUnPayOutpatient.getSfh() )) {               //收费号,当收费号不为空时， 表明已经支付过了
                isHisPay = true;
                sfh = totalUnPayOutpatient.getSfh();
            }
            feeAmountStr = String.valueOf(totalUnPayOutpatient.getZfje()) ;                     //拿到支付金额
            feeName = "门诊缴费";
        } else if(feeType == ComplexPay.FEE_TYPE_GH){
            //--------挂号
        } else if(feeType == ComplexPay.FEE_TYPE_ZY){
            feeAmountStr = payOrderCreateReq.getFeeAmount();                                     //费用为用户手动输入
            log.debug("====> 住院预缴! 用户输入金额====> [{}]",feeAmountStr);
            String cf = WePayUtil.checkFee(feeAmountStr) ;
            if( cf != null )
                return RETResultUtils._509(cf);
            DecimalFormat df = new DecimalFormat("#.00");                                       //保留两位小数
            feeAmountStr = "" + df.format(Double.valueOf(feeAmountStr));
            if(Double.valueOf(feeAmountStr) < 1)
                feeAmountStr = "0" + feeAmountStr ;
            log.debug("====> 住院预缴! 用户输入金额 保留两位小数 ====>[{}]",feeAmountStr);
            //1.从his拿数据
            InHospitalInfo inHospitalInfo =  complexPayService.getZYPre(openId, openIdType,djh);
            long_djh = inHospitalInfo.getZybh();
            log.debug("====> brid [{}] 流水号djh [{}] 住院编号为 [{}] ", brid , djh ,long_djh);
            if (StringUtils.isEmptyOrBlank(long_djh))
                return RETResultUtils._506("住院编号为空,不能进行预缴!");
            feeName = "住院预缴";
            isHisPay = false;
        } else{
            return RETResultUtils._509("缴费类型不存在!");
        }
        if(isHisPay)
            return RETResultUtils.success("该订单已经支付过了");
        /**============================判断支付类型 完成=================================*/
        /**=====根据His系统中的费用单号 和 费用类型查询本地记录的支付状态==========================*/
        ComplexPay lastPayOrder = null;                                                                //最后一次支付记录
        if(StringUtils.isNotEmptyAndBlank(long_djh))
            lastPayOrder = complexPayService.getLatestPayRecord(long_djh,feeType,brid,ComplexPay.PAY_WAY_WECHAT);
        if(lastPayOrder != null && lastPayOrder.getPayState() == ComplexPay.PAY_STATE_SUCCESS && lastPayOrder.getHisAsync() == ComplexPay.HIS_SYNC_NO ) {  //如果本地系统支付成功
            log.error("====> His系统中没有支付成功, 本地系统支付成功=====================" + lastPayOrder);
            try {
                complexPayService.confirmAsyncStatus(openId,openIdType,lastPayOrder);
            } catch (Exception e) {
                log.error("====> 同步支付状态到 HIS系统， 用异步方式 的过程中出现异常! [{}]",e.getMessage());
            }
            if(lastPayOrder.getFeeType() == ComplexPay.FEE_TYPE_MZ)
                return RETResultUtils._506("该订单已支付!");
        }
        if(lastPayOrder != null){
            String createdTime = lastPayOrder.getCreatedTime();                                //该订单生成的时间
            if(WePayUtil.orderLessThan10min(createdTime)){                                     //如果订单生成的时间小于10分钟，则可以用该订单号继续支付
                try {
                    Map<String, String> payParamMap = WePayUtil.jsonStringToMap(lastPayOrder.getPayParam());
                    Map<String,Object> data = new HashMap<String, Object>();
                    data.put("payData",payParamMap);
                    data.put("outTradeNo",lastPayOrder.getOutTradeNo());
                    log.debug("====>  订单map包含的相关信息====> [{}]" ,payParamMap.toString());
                    if(lastPayOrder.getFeeType() == ComplexPay.FEE_TYPE_MZ)                     //是门诊缴费的情况下才返回到H5进行支付
                        return new RETResultUtils(data);                                        //返回订单支付信息
                } catch (Exception e) {
                    log.error("====>  订单生成的时间小于10分钟, 且转成Map的过程中出现异常! [{}]",e.getMessage());
                    return RETResultUtils.faild("网络延时,请稍后重试!");
                }
            }
        }

        /**=====根据His系统中的费用单号 和 费用类型查询本地记录的支付状态 完成======================*/
        /**=============================生成订单号====================================*/
        String outTradeNo = WePayUtil.getOutTradeNo("WC");  //生成商户订单号
        String nonceStr = WePayUtil.getNonceStr();
        log.error("====> 支付 元转分之前金额为 = " + feeAmountStr );
        Integer feeAmountFen = WePayUtil.yuan2fen(feeAmountStr);                   //商品金额， 元转换为 分
        log.error("====> 支付 元转分之后金额为 = " + feeAmountFen );

        WepayConfig wepayConfig = wepayConfigService.getByAppId(appId);
        SortedMap<String, String> sortedMap = createMap(wepayConfig,openId,nonceStr,outTradeNo,feeName,feeAmountFen,request,response);
        String xmlBody = WePayUtil.mapToXml(sortedMap);
        String prepayid = null;                                                     //获取prepayId
        try {
            prepayid = WePayUtil.getPrepayId(wepayConfig.getGateWay(), xmlBody);
        } catch (JDOMException e) {
            log.error("====> 支付 获取支付 prepayid 错误! " + e.getMessage());
        }
        if(StringUtils.isEmptyOrBlank(prepayid))//如果没有获取到订单
            return RETResultUtils.faild("获取微信支付订单错误!");
        /**===============================生成订单号完成==============================*/
        /**===============================生成页面支付信息============================*/
        SortedMap<String, String> sMap = createPageOrderInfo(wepayConfig,nonceStr,prepayid,request,response);
        /**==========================生成页面支付信息完成================================*/
        ComplexPay newComplexPayOrder = new ComplexPay().setOpenId(openId).setPatientId(Long.valueOf(brid)).setJzh(jzh).setHisNo(sfh)//
                .setDjh(long_djh).setFeeName(feeName).setFeeType(feeType).setFeeAmount(feeAmountStr)//
                .setPayWay(ComplexPay.PAY_WAY_WECHAT).setOutTradeNo(outTradeNo).setPayOrientation(ComplexPay.PAY_ORIENTATION_FRONT)//
                .setAsync(ComplexPay.PAY_SYNC_NO).setHisAsync(ComplexPay.HIS_SYNC_NO).setPayState(ComplexPay.PAY_STATE_UNNKNOWN).setRemark("prepay_id=" + prepayid)//
                .setPayParam(WePayUtil.objectToString(sMap));
        try {
            complexPayService.saveOrderRecord(newComplexPayOrder);         //将订单信息保存到数据库中
        } catch (Exception e) {
            log.error("将订单信息保存到数据库中出现异常 异常信息为:[{}]" , e.getMessage());
            return RETResultUtils.faild("网络延时,请稍后重试COERO");
        }
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("payData",sMap);
        data.put("outTradeNo",outTradeNo);
        return  new RETResultUtils(data);

    }


    private SortedMap<String, String> createPageOrderInfo(WepayConfig wepayConfig , String nonceStr , String prepayid , HttpServletRequest request,HttpServletResponse response ){
        SortedMap<String, String> map = new TreeMap<String, String>();
        String timestamp = WePayUtil.getTimeStamp();
        map.put("appId",wepayConfig.getAppid());
        map.put("timeStamp", timestamp);
        map.put("nonceStr", nonceStr);
        map.put("package", "prepay_id=" + prepayid);
        map.put("signType",wepayConfig.getSignType() );
        String sgn = WePayUtil.createSign(wepayConfig.getPayKey() , map, request, response);
        map.put("paySign", sgn);
        return map ;
    }

    protected SortedMap<String, String> createMap(WepayConfig wepayConfig,String openId , String nonceStr ,String outTradeNo ,String feeName ,Integer feeAmountFen , HttpServletRequest request,HttpServletResponse response){
        SortedMap<String, String> map = new TreeMap<String, String>();        //可排序的数组
        map.put("notify_url", wepayConfig.getPayNotifyUrl());//接收财付通通知的URL
        map.put("body", feeName);                                             //商品描述
        map.put("out_trade_no", outTradeNo); 							        //商家订单号
        map.put("total_fee",""+feeAmountFen); 				                //商品金额,以分为单位
        map.put("spbill_create_ip",IPUtil.getRealIp(request)); 	            //订单生成的机器IP，指用户浏览器端IP
        map.put("fee_type", wepayConfig.getFeeFype()); 				        //币种，1人民币   66
        map.put("appid",wepayConfig.getAppid());						    //app唯一标识
        map.put("mch_id", wepayConfig.getMchId());				     	    //商户号
        map.put("nonce_str", nonceStr);				                        //随机字符串
        map.put("trade_type", wepayConfig.getTradeType() );		     	    //支付方式,此处为微信支付
        map.put("sign_type",wepayConfig.getSignType() );			  	    //签名方式
        map.put("openid", openId);                                            //微信用户在商户对应appid下的唯一标识
        //生成获取预支付签名
        String sign = WePayUtil.createSign( wepayConfig.getPayKey(), map, request, response);
        map.put("sign", sign);
        return map ;
    }




}
