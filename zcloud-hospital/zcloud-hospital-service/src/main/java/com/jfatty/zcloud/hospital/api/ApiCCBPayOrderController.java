package com.jfatty.zcloud.hospital.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.base.utils.WePayUtil;
import com.jfatty.zcloud.hospital.constants.CCBConstants;
import com.jfatty.zcloud.hospital.entity.CcbConfig;
import com.jfatty.zcloud.hospital.req.CCBPayOrderCreateReq;
import com.jfatty.zcloud.hospital.res.CCBPayOrderCreateRes;
import com.jfatty.zcloud.hospital.res.CCBQrPayOrderCreateRes;
import com.jfatty.zcloud.hospital.service.CcbConfigService;
import com.jfatty.zcloud.hospital.service.ComplexPayService;
import com.jfatty.zcloud.hospital.utils.HttpClientUtil;
import com.jfatty.zcloud.hospital.utils.MD5Utils;
import com.jfatty.zcloud.hospital.vo.ComplexPay;
import com.jfatty.zcloud.hospital.vo.InHospitalInfo;
import com.jfatty.zcloud.hospital.vo.TotalUnPayOutpatient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * 描述 建行支付订单
 *
 * @author jfatty on 2020/7/22
 * @email jfatty@163.com
 */
@Api(tags = "建行支付订单API" ,value = "建行支付订单")
@Slf4j
@RestController
@RequestMapping("/api/payOrder")
public class ApiCCBPayOrderController {

    @Autowired
    private ComplexPayService complexPayService ;

    @Autowired
    private CcbConfigService ccbConfigService ;

    //建行聚合支付支付订单
    @ApiOperation(value="001******建行聚合支付支付订单")
    @RequestMapping(value = {"/createCCBQrPayOrder"} ,method = RequestMethod.POST)
    public RETResultUtils<CCBQrPayOrderCreateRes> createCCBQrPayOrder(@RequestBody CCBPayOrderCreateReq ccbPayOrderCreateReq , HttpServletRequest request , HttpServletResponse response){
        String openId = ccbPayOrderCreateReq.getOpenId() ;
        Integer openIdType = ccbPayOrderCreateReq.getOpenIdType() ;
        String mchId = ccbPayOrderCreateReq.getMchId() ;                                          //商户ID
        String djh = ccbPayOrderCreateReq.getHisNo() ;
        String brid = ccbPayOrderCreateReq.getBrid() ;
        String scene = "" ;                                                                     //用卡环节
        String jzh = ccbPayOrderCreateReq.getJzh();                                                //获取就诊号
        /**===============判断支付类型，根据不同的支付类型来查询对应的订单详情====================*/
        String feeAmountStr = "";                                                               //费用金额
        String feeName = "";                                                                    //费用名称
        int feeType = ccbPayOrderCreateReq.getFeeType();                                           //费用类型 如 门诊缴费、挂号缴费、住院预缴
        boolean isHisPay = false;                                                               //HIS系统中的支付状态， 是否已经支付过了
        String sfh = "" ;                                                                       //his系统中的收费号
        String long_djh = "" ;                                                                  //本地拼接的流水号 存在逗号拼接的情况 费用单号

        CcbConfig ccbConfig = ccbConfigService.getByMchId(mchId) ;
        if ( ccbConfig == null){
            return RETResultUtils._509("商户ID不正确!");
        }
        if(feeType == ComplexPay.FEE_TYPE_MZ){
            log.debug("====> getPrepareId 门诊缴费!");
            TotalUnPayOutpatient totalUnPayOutpatient = complexPayService.getMZPay(openId, openIdType,jzh,brid);
            if(totalUnPayOutpatient == null ){
                log.error("====> 查询订单信息! brid = " + brid + " 流水号djh=" + djh + "msg=his系统中未查到该订单");
                return RETResultUtils._506("his系统中未查到该订单");
            }
            //获取费用单号
            long_djh = totalUnPayOutpatient.getFydh();                                           //流水号 住院号 逗号拼接
            if (StringUtils.isNotEmptyAndBlank( totalUnPayOutpatient.getSfh() )) {               //收费号,当收费号不为空时， 表明已经支付过了
                isHisPay = true;
                sfh = totalUnPayOutpatient.getSfh();
            }
            feeAmountStr = String.valueOf(totalUnPayOutpatient.getZfje()) ;                     //拿到支付金额
            feeName = "门诊缴费";
            scene = "0101051";                                                                  //门诊缴费
        } else if(feeType == ComplexPay.FEE_TYPE_GH){
            //--------挂号
        } else if(feeType == ComplexPay.FEE_TYPE_ZY){
            feeAmountStr = ccbPayOrderCreateReq.getFeeAmount();                                     //费用为用户手动输入
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
            scene = "0101053";                                                                  //住院缴费
        } else{
            return RETResultUtils._509("缴费类型不存在!");
        }
        //数据上报电子健康卡平台
        //reportHISData(brid,null,scene,feeName,"","0100");
        if(isHisPay)
            return RETResultUtils.success("该订单已经支付过了");
        /**============================判断支付类型 完成=================================*/
        /**=====根据His系统中的费用单号 和 费用类型查询本地记录的支付状态==========================*/
        ComplexPay lastPayOrder = null;                                                                //最后一次支付记录
        if(StringUtils.isNotEmptyAndBlank(long_djh)){
            if( openIdType == 2 ){//微信支付
                lastPayOrder = complexPayService.getLatestPayRecord(long_djh,feeType,brid,ComplexPay.PAY_WAY_WECHAT,ComplexPay.PAY_CHANNEL_CCB_QR);
            }
            if( openIdType == 1 ){//支付宝支付
                lastPayOrder = complexPayService.getLatestPayRecord(long_djh,feeType,brid,ComplexPay.PAY_WAY_ZFB,ComplexPay.PAY_CHANNEL_CCB_QR);
            }
        }
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

        //判断是否为最近一笔订单且没有支付

        if(lastPayOrder != null){
            String createdTime = lastPayOrder.getCreatedTime();                                //该订单生成的时间
            if(WePayUtil.orderLessThan10min(createdTime)){                                     //如果订单生成的时间小于10分钟，则可以用该订单号继续支付
                if(lastPayOrder.getFeeType() == ComplexPay.FEE_TYPE_MZ){                      //是门诊缴费的情况下才返回到H5进行支付
                    CCBQrPayOrderCreateRes ccbQrPayOrderCreateRes = new CCBQrPayOrderCreateRes() ;
                    ccbQrPayOrderCreateRes.setOrderId(lastPayOrder.getOutTradeNo());
                    ccbQrPayOrderCreateRes.setQrUrl(lastPayOrder.getPayParam());
                    return new RETResultUtils(ccbQrPayOrderCreateRes);                                        //返回订单支付信息
                }
            }
        }

        String outTradeNo = WePayUtil.getOutTradeNo("CCB");  //生成商户订单号
        //生成建行聚合支付订单信息
        HashMap<String, String> orderMap = new HashMap<String, String>();
        orderMap.put("CCB_IBSVersion", "V6");
        orderMap.put("MERCHANTID", ccbConfig.getMerchantId());
        orderMap.put("POSID", ccbConfig.getPosId());
        orderMap.put("BRANCHID", ccbConfig.getBranchId());
        orderMap.put("ORDERID", outTradeNo);
        orderMap.put("PAYMENT", feeAmountStr);
        orderMap.put("CURCODE", ccbConfig.getCurCode());
        orderMap.put("REMARK1", "");
        orderMap.put("REMARK2", "");
        orderMap.put("TXCODE", ccbConfig.getTxCode());
        orderMap.put("RETURNTYPE", ccbConfig.getReturnType());
        orderMap.put("TIMEOUT", "");
        // MD5加密
        StringBuilder sb = new StringBuilder();
        sb.append("MERCHANTID=").append(ccbConfig.getMerchantId()).append("&POSID=").append(ccbConfig.getPosId())
                .append("&BRANCHID=").append(ccbConfig.getBranchId()).append("&ORDERID=")
                .append(outTradeNo).append("&PAYMENT=").append(feeAmountStr)
                .append("&CURCODE=").append(ccbConfig.getCurCode()).append("&TXCODE=").append(ccbConfig.getTxCode())
                .append("&REMARK1=").append("").append("&REMARK2=").append("")
                .append("&RETURNTYPE=").append(ccbConfig.getReturnType()).append("&TIMEOUT=").append("")
                .append("&PUB=").append(ccbConfig.getPub());
        log.error("===>MD5加密前的拼接字符串[{}]",sb.toString());
        String sign = MD5Utils.MD5Encode(sb.toString(), "UTF-8").toLowerCase();
        log.error("===>MD5加密后的签名串[{}]",sign);
        orderMap.put("MAC", sign);

        //1.向建行提交请求参数
        String urlData = HttpClientUtil.doPost(CCBConstants.CCB_CREATE_ORDER_URL, orderMap);
        if ( StringUtils.isEmptyOrBlank(urlData) ) {
            log.error("1.向建行提交请求参数 获取失败 排查请求异常信息 [{}]",urlData);
            return RETResultUtils.faild("网络延时,请稍后重试!");
        }
        //解析建行返回的数据
        JSONObject parseObject = JSON.parseObject(urlData);
        boolean isSuccess = parseObject.getBoolean("SUCCESS") ;
        if ( !isSuccess ) { //调用失败进行处理
            log.error("解析建行返回的数据后 没有返回预期成功信息 查看具体返回数据 [{}]",urlData);
            return RETResultUtils.faild("网络延时,请稍后重试!");
        }
        //2.向建行提交PAYURL
        String payUrlRes = HttpClientUtil.doPost(parseObject.getString("PAYURL"), null);
        if ( StringUtils.isEmptyOrBlank(urlData) ) {
            log.error("2.向建行提交PAYURL 失败 排查请求异常信息 [{}]",payUrlRes);
            return RETResultUtils.faild("网络延时,请稍后重试!");
        }
        JSONObject payUrlObject = JSON.parseObject(payUrlRes);
        boolean isOk = payUrlObject.getBoolean("SUCCESS") ;
        if ( !isOk ) { //调用返回失败
            log.error("2.向建行提交PAYURL 有返回结果失败 排查请求异常信息 [{}]",payUrlRes);
            return RETResultUtils.faild("网络延时,请稍后重试!");
        }
        String errcode = payUrlObject.getString("ERRCODE") ;
        String errmsg = payUrlObject.getString("ERRMSG") ;
        if ( StringUtils.isNotEmptyAndBlank(errcode) ) { //提交成功返回失败信息
            log.error("2.向建行提交PAYURL 有返回结果失败 ERRCODE [{}] ERRMSG [{}]",errcode,errmsg);
            return RETResultUtils.faild("网络延时,请稍后重试!");
        }
        //得到聚合支付需要的qrUrl
        String qrUrl = payUrlObject.getString("QRURL") ;
        String payParam =  CCBConstants.CCB_QR_ORDER_URL_PREFIX + qrUrl ;

        ComplexPay newComplexPayOrder = new ComplexPay().setOpenId(openId).setPatientId(Long.valueOf(brid)).setJzh(jzh).setHisNo(sfh)//
                .setDjh(long_djh).setFeeName(feeName).setFeeType(feeType).setFeeAmount(feeAmountStr)//
                .setOutTradeNo(outTradeNo).setPayOrientation(ComplexPay.PAY_ORIENTATION_FRONT)//
                .setAsync(ComplexPay.PAY_SYNC_NO).setHisAsync(ComplexPay.HIS_SYNC_NO).setPayState(ComplexPay.PAY_STATE_UNNKNOWN).setRemark("qrUrl=" + qrUrl)//
                .setPayParam(payParam).setPayChannel(ComplexPay.PAY_CHANNEL_CCB_QR);

        if( openIdType == 2 ){//微信支付
            newComplexPayOrder.setPayWay(ComplexPay.PAY_WAY_WECHAT) ;
        }
        if( openIdType == 1 ){//支付宝支付
            newComplexPayOrder.setPayWay(ComplexPay.PAY_WAY_ZFB);
        }
        try {
            complexPayService.saveOrderRecord(newComplexPayOrder);         //将订单信息保存到数据库中
        } catch (Exception e) {
            log.error("将订单信息保存到数据库中出现异常 异常信息为:[{}]" , e.getMessage());
            return RETResultUtils.faild("网络延时,请稍后重试COEROW");
        }
        CCBQrPayOrderCreateRes ccbQrPayOrderCreateRes = new CCBQrPayOrderCreateRes() ;
        ccbQrPayOrderCreateRes.setOrderId(outTradeNo);
        ccbQrPayOrderCreateRes.setQrUrl(payParam);
        return  new RETResultUtils(ccbQrPayOrderCreateRes);
    }


    //建行账号(龙)支付订单
    @ApiOperation(value="002******建行账号(龙)支付订单")
    @RequestMapping(value = {"/createCCBPayOrder"} ,method = RequestMethod.POST)
    public RETResultUtils<CCBPayOrderCreateRes> createCCBPayOrder(@RequestBody CCBPayOrderCreateReq ccbPayOrderCreateReq , HttpServletRequest request , HttpServletResponse response){
        String openId = ccbPayOrderCreateReq.getOpenId() ;
        Integer openIdType = ccbPayOrderCreateReq.getOpenIdType() ;
        String mchId = ccbPayOrderCreateReq.getMchId() ;                                          //商户ID
        String djh = ccbPayOrderCreateReq.getHisNo() ;
        String brid = ccbPayOrderCreateReq.getBrid() ;
        String scene = "" ;                                                                     //用卡环节
        String jzh = ccbPayOrderCreateReq.getJzh();                                                //获取就诊号
        /**===============判断支付类型，根据不同的支付类型来查询对应的订单详情====================*/
        String feeAmountStr = "";                                                               //费用金额
        String feeName = "";                                                                    //费用名称
        int feeType = ccbPayOrderCreateReq.getFeeType();                                           //费用类型 如 门诊缴费、挂号缴费、住院预缴
        boolean isHisPay = false;                                                               //HIS系统中的支付状态， 是否已经支付过了
        String sfh = "" ;                                                                       //his系统中的收费号
        String long_djh = "" ;                                                                  //本地拼接的流水号 存在逗号拼接的情况 费用单号
        CcbConfig ccbConfig = ccbConfigService.getByMchId(mchId) ;
        if ( ccbConfig == null){
            return RETResultUtils._509("商户ID不正确!");
        }
        if(feeType == ComplexPay.FEE_TYPE_MZ){
            log.debug("====> getPrepareId 门诊缴费!");
            TotalUnPayOutpatient totalUnPayOutpatient = complexPayService.getMZPay(openId, openIdType,jzh,brid);
            if(totalUnPayOutpatient == null ){
                log.error("====> 查询订单信息! brid = " + brid + " 流水号djh=" + djh + "msg=his系统中未查到该订单");
                return RETResultUtils._506("his系统中未查到该订单");
            }
            //获取费用单号
            long_djh = totalUnPayOutpatient.getFydh();                                           //流水号 住院号 逗号拼接
            if (StringUtils.isNotEmptyAndBlank( totalUnPayOutpatient.getSfh() )) {               //收费号,当收费号不为空时， 表明已经支付过了
                isHisPay = true;
                sfh = totalUnPayOutpatient.getSfh();
            }
            feeAmountStr = String.valueOf(totalUnPayOutpatient.getZfje()) ;                     //拿到支付金额
            feeName = "门诊缴费";
            scene = "0101051";                                                                  //门诊缴费
        } else if(feeType == ComplexPay.FEE_TYPE_GH){
            //--------挂号
        } else if(feeType == ComplexPay.FEE_TYPE_ZY){
            feeAmountStr = ccbPayOrderCreateReq.getFeeAmount();                                     //费用为用户手动输入
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
            scene = "0101053";                                                                  //住院缴费
        } else{
            return RETResultUtils._509("缴费类型不存在!");
        }
        //数据上报电子健康卡平台
        //reportHISData(brid,null,scene,feeName,"","0100");
        if(isHisPay)
            return RETResultUtils.success("该订单已经支付过了");
        /**============================判断支付类型 完成=================================*/
        /**=====根据His系统中的费用单号 和 费用类型查询本地记录的支付状态==========================*/
        ComplexPay lastPayOrder = null;                                                                //最后一次支付记录
        if(StringUtils.isNotEmptyAndBlank(long_djh)){
            if( openIdType == 2 ){//微信支付
                lastPayOrder = complexPayService.getLatestPayRecord(long_djh,feeType,brid,ComplexPay.PAY_WAY_WECHAT,ComplexPay.PAY_CHANNEL_CCB);
            }
            if( openIdType == 1 ){//支付宝支付
                lastPayOrder = complexPayService.getLatestPayRecord(long_djh,feeType,brid,ComplexPay.PAY_WAY_ZFB,ComplexPay.PAY_CHANNEL_CCB);
            }
        }
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

        CCBPayOrderCreateRes ccbPayOrderCreateRes = new CCBPayOrderCreateRes() ;
        ccbPayOrderCreateRes.setMerchantId(ccbConfig.getMerchantId());
        ccbPayOrderCreateRes.setPosId(ccbConfig.getPosId());
        ccbPayOrderCreateRes.setBranchId(ccbConfig.getBranchId());
        ccbPayOrderCreateRes.setPub(ccbConfig.getPub());

        //判断是否为最近一笔订单且没有支付

        if(lastPayOrder != null){
            String createdTime = lastPayOrder.getCreatedTime();                                //该订单生成的时间
            if(WePayUtil.orderLessThan10min(createdTime)){                                     //如果订单生成的时间小于10分钟，则可以用该订单号继续支付
                if(lastPayOrder.getFeeType() == ComplexPay.FEE_TYPE_MZ){                      //是门诊缴费的情况下才返回到H5进行支付

                    ccbPayOrderCreateRes.setOrderId(lastPayOrder.getOutTradeNo());
                    ccbPayOrderCreateRes.setPayMent(lastPayOrder.getFeeAmount());

                    return new RETResultUtils(ccbPayOrderCreateRes);                                        //返回订单支付信息
                }
            }
        }

        String outTradeNo = WePayUtil.getOutTradeNo("CCB");  //生成商户订单号

        ComplexPay newComplexPayOrder = new ComplexPay().setOpenId(openId).setPatientId(Long.valueOf(brid)).setJzh(jzh).setHisNo(sfh)//
                .setDjh(long_djh).setFeeName(feeName).setFeeType(feeType).setFeeAmount(feeAmountStr)//
                .setOutTradeNo(outTradeNo).setPayOrientation(ComplexPay.PAY_ORIENTATION_FRONT)//
                .setAsync(ComplexPay.PAY_SYNC_NO).setHisAsync(ComplexPay.HIS_SYNC_NO).setPayState(ComplexPay.PAY_STATE_UNNKNOWN).setRemark("outTradeNo=" + outTradeNo)//
                .setPayParam("本笔订单为建行账号(龙)支付订单").setPayChannel(ComplexPay.PAY_CHANNEL_CCB);

        if( openIdType == 2 ){//微信支付
            newComplexPayOrder.setPayWay(ComplexPay.PAY_WAY_WECHAT) ;
        }
        if( openIdType == 1 ){//支付宝支付
            newComplexPayOrder.setPayWay(ComplexPay.PAY_WAY_ZFB);
        }
        try {
            complexPayService.saveOrderRecord(newComplexPayOrder);         //将订单信息保存到数据库中
        } catch (Exception e) {
            log.error("将订单信息保存到数据库中出现异常 异常信息为:[{}]" , e.getMessage());
            return RETResultUtils.faild("网络延时,请稍后重试COEROW");
        }
        ccbPayOrderCreateRes.setOrderId(outTradeNo);
        ccbPayOrderCreateRes.setPayMent(feeAmountStr);
        return  new RETResultUtils(ccbPayOrderCreateRes);
    }

}
