package com.jfatty.zcloud.wechat.utils;

import com.alibaba.fastjson.JSONObject;


import com.jfatty.zcloud.base.utils.UUIDGenerator;
import com.jfatty.zcloud.wechat.exception.WxError;
import com.jfatty.zcloud.wechat.exception.WxErrorException;
import com.jfatty.zcloud.wechat.utils.wx.*;
import com.jfatty.zcloud.wechat.entity.Account;
import com.jfatty.zcloud.wechat.entity.AccountFans;
import com.jfatty.zcloud.wechat.entity.TemplateMessage;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 描述 微信 客户端，统一处理微信相关接口
 * @author jfatty on 2019/4/7
 * @email jfatty@163.com
 */
@Slf4j
public class WxApiClient implements Serializable {

    // 获取accessToken
    public static String getAccessToken(Account account) throws WxErrorException {
        // 获取唯一的accessToken，如果是多账号，请自行处理
        AccessToken token = WxMemoryCacheClient.getAccessToken();
        if (token != null && !token.isExpires() && WxApi.getCallbackIp(token.getAccessToken())) {// 不为空，并且没有过期
            log.info("服务器缓存 accessToken == " + token.toString());
            return token.getAccessToken();
        } else {
            token = WxApi.getAccessToken(account.getAppid(), account.getAppsecret());
            if (token != null) {
                if (token.getErrcode() == null) {
                   WxMemoryCacheClient.addAccessToken(account.getAccount(), token);
                    return token.getAccessToken();
                } else {
                    throw new WxErrorException(WxError.newBuilder().setErrorCode(token.getErrcode()).setErrorMsg(token.getErrmsg()).build());
                }
            }
            return null;
        }
    }


    // 根据openId获取粉丝信息
    public static AccountFans syncAccountFans(String openId, Account account) throws WxErrorException {
        String accessToken = getAccessToken(account);
        log.info("获取用户信息接口accessToken：" + accessToken);
        String url = WxApi.getFansInfoUrl(accessToken, openId);
        log.info("获取用户信息接口url：" + url);
        JSONObject jsonObj = WxApi.httpsRequest(url, "GET", null);
        if (null == jsonObj)
            return null;
        log.info("获取用户信息接口返回结果：" + jsonObj.toString());
        if (jsonObj.containsKey("errcode")) {
            throw new WxErrorException(WxError.fromJson(jsonObj));
        } else {
            AccountFans fans = new AccountFans();
            fans.setId(UUIDGenerator.uuid());
            fans.setOpenId(jsonObj.getString("openid"));// 用户的标识
            fans.setSubscribeStatus(new Integer(jsonObj.getIntValue("subscribe")));// 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
            if (jsonObj.containsKey("subscribe_time")) {
                fans.setSubscribeTime(DateUtil.timestampToDate(jsonObj.getString("subscribe_time")));// 用户关注时间
            }
            if (jsonObj.containsKey("nickname")) {// 昵称
                try {
                    String nickname = jsonObj.getString("nickname");
                    fans.setNickName(nickname.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if (jsonObj.containsKey("sex")) {// 用户的性别（1是男性，2是女性，0是未知）
                fans.setGender(jsonObj.getIntValue("sex"));
            }
            if (jsonObj.containsKey("language")) {// 用户的语言，简体中文为zh_CN
                fans.setLanguage(jsonObj.getString("language"));
            }
            if (jsonObj.containsKey("country")) {// 用户所在国家
                fans.setCountry(jsonObj.getString("country"));
            }
            if (jsonObj.containsKey("province")) {// 用户所在省份
                fans.setProvince(jsonObj.getString("province"));
            }
            if (jsonObj.containsKey("city")) {// 用户所在城市
                fans.setCity(jsonObj.getString("city"));
            }
            if (jsonObj.containsKey("headimgurl")) {// 用户头像
                fans.setHeadImgUrl(jsonObj.getString("headimgurl"));
            }
            if (jsonObj.containsKey("remark")) {
                fans.setRemark(jsonObj.getString("remark"));
            }
            fans.setState(1);
            return fans;
        }
    }

    // 获取OAuthAccessToken
    public static OAuthAccessToken getOAuthAccessToken(Account mpAccount, String code) throws WxErrorException {
        // 获取唯一的accessToken，如果是多账号，请自行处理
        OAuthAccessToken token = WxMemoryCacheClient.getOAuthAccessToken();
        if (token != null && !token.isExpires()) {// 不为空，并且没有过期
            return token;
        } else {
            token = WxApi.getOAuthAccessToken(mpAccount.getAppid(), mpAccount.getAppsecret(), code);
            if (token != null) {
                if (token.getErrcode() != null) {// 获取失败
                    throw new WxErrorException(WxError.newBuilder().setErrorCode(-1).setErrorMsg(token.getErrmsg()).build());
                } else {
                    token.setOpenid(null);// 获取OAuthAccessToken的时候设置openid为null；不同用户openid缓存
                    WxMemoryCacheClient.addOAuthAccessToken(mpAccount.getAccount(), token);
                    return token;
                }
            }
            return null;
        }
    }

    // 获取OAuthAccessToken
    public static OAuthAccessToken getDirectOAuthAccessToken(Account mpAccount, String code) throws WxErrorException {
        OAuthAccessToken token = WxApi.getOAuthAccessToken(mpAccount.getAppid(), mpAccount.getAppsecret(), code);
        if (token != null) {
            if (token.getErrcode() != null)// 获取失败
                throw new WxErrorException(WxError.newBuilder().setErrorCode(-1).setErrorMsg(token.getErrmsg()).build());
            return token;
        }
        return null;
    }

    // 获取菜单
    public static JSONObject getMenus(Account mpAccount) throws WxErrorException {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getMenuGetUrl(accessToken);
        JSONObject rstObj = WxApi.httpsRequest(url, HttpMethod.GET);
        if (WxUtil.isWxError(rstObj)) {
            throw new WxErrorException(WxError.fromJson(rstObj));
        }
        return rstObj;
    }

    // 发布菜单
    public static JSONObject publishMenus(String menus, Account mpAccount) throws WxErrorException {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getMenuCreateUrl(accessToken);
        JSONObject rstObj = WxApi.httpsRequest(url, HttpMethod.POST, menus);
        if (WxUtil.isWxError(rstObj)) {
            throw new WxErrorException(WxError.fromJson(rstObj));
        }
        return rstObj;
    }

    // 删除菜单
    public static JSONObject deleteMenu(Account mpAccount) throws WxErrorException {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getMenuDeleteUrl(accessToken);
        JSONObject rstObj =  WxApi.httpsRequest(url, HttpMethod.POST, null);
        if (WxUtil.isWxError(rstObj)) {
            throw new WxErrorException(WxError.fromJson(rstObj));
        }
        return rstObj;
    }


    /**
     * 发送模板消息
     * @param tplMsg
     * @param mpAccount 消息内容
     * @return
     */
    public static JSONObject sendTemplateMessage(TemplateMessage tplMsg, Account mpAccount) throws WxErrorException {
        if (tplMsg != null) {
            String accessToken = getAccessToken(mpAccount);
            JSONObject jsonObject = WxApi.httpsRequest(WxApi.getSendTemplateMessageUrl(accessToken), HttpMethod.POST, tplMsg.toString());
            if (WxUtil.isWxError(jsonObject)) {
                throw new WxErrorException(WxError.fromJson(jsonObject));
            }
            return jsonObject;
        }
        return null;
    }

    //创建用户标签
    public static JSONObject createUserTag(String userTags,Account mpAccount ) throws WxErrorException {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getCreateUserTag(accessToken);
        return WxApi.httpsRequest(url, HttpMethod.POST, userTags);
    }

    //删除用户标签
    public static JSONObject deleteUserTag(String tagId,Account mpAccount) throws WxErrorException {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getDeleteUserTag(accessToken);
        return WxApi.httpsRequest(url, HttpMethod.POST, tagId);
    }

    /**
     * 根据openid群发文本消息
     *
     * @param openids
     * @param content
     * @param mpAccount
     * @return
     */
    public static JSONObject massSendTextByOpenIds(List<String> openids, String content, Account mpAccount) throws WxErrorException {
        if (openids != null && openids.size() > 0) {
            if (openids.size() == 1) {// 根据openId群发，size至少为2
                openids.add("1");
            }
            String[] arr = (String[])openids.toArray(new String[openids.size()]);
            JSONObject postObj = new JSONObject();
            JSONObject text = new JSONObject();
            postObj.put("touser", arr);
            text.put("content", content);
            postObj.put("text", text);
            postObj.put("msgtype", MsgType.Text.toString());
            String accessToken = getAccessToken(mpAccount);
            JSONObject rstObj = WxApi.httpsRequest(WxApi.getMassSendUrl(accessToken), HttpMethod.POST, postObj.toString());
            if (WxUtil.isWxError(rstObj)) {
                throw new WxErrorException(WxError.fromJson(rstObj));
            }
            return rstObj;
        }
        return null;
    }

    /**
     * 给单独微信用户发发送文本消息
     * @param openId
     * @param content
     * @param mpAccount
     * @return
     * @throws WxErrorException
     */
    public static JSONObject massSendTextByOpenId(String openId, String content, Account mpAccount) throws WxErrorException {
        JSONObject postObj = new JSONObject();
        JSONObject text = new JSONObject();
        String[] arr = new String[]{openId , "1"};
        postObj.put("touser", arr);
        text.put("content", content);
        postObj.put("text", text);
        postObj.put("msgtype", MsgType.Text.toString());
        String accessToken = getAccessToken(mpAccount);
        JSONObject rstObj = WxApi.httpsRequest(WxApi.getMassSendUrl(accessToken), HttpMethod.POST, postObj.toString());
        if (WxUtil.isWxError(rstObj)) {
            throw new WxErrorException(WxError.fromJson(rstObj));
        }
        return rstObj;
    }

    //获取标签下粉丝列表
    public static JSONObject getUserListByTag(String tagId,Account mpAccount) throws WxErrorException {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getUserListByTag(accessToken);
        return WxApi.httpsRequest(url, HttpMethod.POST, tagId);
    }
}
