package com.jfatty.zcloud.wechat.api;


import com.alibaba.fastjson.JSONObject;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.wechat.entity.Account;
import com.jfatty.zcloud.wechat.exception.WxErrorException;
import com.jfatty.zcloud.wechat.service.AccountService;
import com.jfatty.zcloud.wechat.service.WxService;
import com.jfatty.zcloud.wechat.utils.MsgXmlUtil;
import com.jfatty.zcloud.wechat.utils.WxApiClient;
import com.jfatty.zcloud.wechat.utils.wx.OAuthAccessToken;
import com.jfatty.zcloud.wechat.utils.wx.SignUtil;
import com.jfatty.zcloud.wechat.utils.wx.WxApi;
import com.jfatty.zcloud.wechat.vo.MsgRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Set;

/**
 * 描述 微信对接接口 基础API
 *
 * @author jfatty on 2019/4/10
 * @email jfatty@163.com
 */

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiWechatController {

    @Autowired
    private WxService wxService ;

    @Autowired
    private AccountService accountService ;

    /**
     * GET请求：进行URL、Tocken 认证；
     * 1. 将token、timestamp、nonce三个参数进行字典序排序
     * 2. 将三个参数字符串拼接成一个字符串进行sha1加密
     * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     */
    @RequestMapping(value = "/wx/{account}/message",  method = RequestMethod.GET)
    public @ResponseBody String doGet(HttpServletRequest request, @PathVariable String account) {
        //如果是多账号，根据url中的account参数获取对应的MpAccount处理即可
        Set<String> keySet = request.getParameterMap().keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            //如果存在，则调用next实现迭代
            String key = iterator.next();
            log.info("key: " + key + " value: " + request.getParameterMap().get(key));
        }
        //MpAccount mpAccount = WxMemoryCacheClient.getMpAccount();//获取缓存中的唯一账号
        Account mpAccount = accountService.getByAccount(account) ; //WxMemoryCacheClient.getMpAccount();//获取缓存中的唯一账号
        if(mpAccount != null){
            String token = mpAccount.getToken();//获取token，进行验证；
            String signature = request.getParameter("signature");// 微信加密签名
            String timestamp = request.getParameter("timestamp");// 时间戳
            String nonce = request.getParameter("nonce");// 随机数
            String echostr = request.getParameter("echostr");// 随机字符串
            // 校验成功返回  echostr，成功成为开发者；否则返回error，接入失败
            if (SignUtil.validSign(signature, token, timestamp, nonce)) {
                return echostr;
            }
        }
        return "error";
    }

    /**
     * POST 请求：进行消息处理；
     * */
    @RequestMapping(value = "/wx/{account}/message", method = RequestMethod.POST)
    public @ResponseBody String doPost(HttpServletRequest request, @PathVariable String account, HttpServletResponse response) {
        try {
            //处理用户和微信公众账号交互消息
            Account mpAccount = accountService.getByAccount(account) ;//MpAccount mpAccount = WxMemoryCacheClient.getMpAccount(account);
            MsgRequest msgRequest = MsgXmlUtil.parseXml(request);//获取发送的消息
            return wxService.processMsg(msgRequest,mpAccount);
        } catch (Exception e) {
            log.error("POST 请求：进行消息处理时出现异常" + e.getMessage());
            return "error";
        }
    }

    /**
     * 统计分析
     * @param start 开始时间
     * @param end 结束时间
     * @return
     * @throws WxErrorException
     */
    @RequestMapping(value = "/wx/dataCube" , method = RequestMethod.POST)
    public ResultUtils dataCube(@RequestParam(value = "type" , defaultValue = "WX") String type ,
                                @RequestParam(value = "start" , defaultValue = "2019-01-01" ) String start ,
                                @RequestParam(value = "end" , defaultValue = "201-11-11") String end) throws WxErrorException {
        //WxMemoryCacheClient.getMpAccount();//获取缓存中的唯一账号
        Account mpAccount = accountService.getActiveAccount() ;
        String accessToken = WxApiClient.getAccessToken(mpAccount);
        JSONObject result = WxApi.forDataCube(accessToken, type, start, end);
        return ResultUtils.build(200, "SUCCESS",result) ;
    }

    @RequestMapping(value="/wxOAuth", method=RequestMethod.GET)
    public ResultUtils wxOAuth(@RequestParam(value = "code" , defaultValue = "code") String code ,
                               @RequestParam(value = "appId" , defaultValue = "appId" ) String appId ){
        log.error(" ====>  当前微信公众 appId [{}] ",appId);
        Account mpAccount = accountService.getByAppId(appId);
        try {
            //获取OAuthAccessToken
            OAuthAccessToken token = WxApiClient.getDirectOAuthAccessToken(mpAccount,code) ;
            log.error(" ====>  通过当前微信公众号 appId 获取到的 wcOpenId [{}]",token.getOpenid());
            return ResultUtils.build(200, "SUCCESS",token.getOpenid()) ;
        } catch (WxErrorException e) {
            e.printStackTrace();
            return ResultUtils.build(500, e.getMessage()) ;
        }
    }

}
