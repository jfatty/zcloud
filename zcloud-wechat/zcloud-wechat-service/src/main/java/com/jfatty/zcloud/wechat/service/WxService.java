package com.jfatty.zcloud.wechat.service;

import com.alibaba.fastjson.JSONObject;
import com.jfatty.zcloud.wechat.entity.Account;
import com.jfatty.zcloud.wechat.entity.TemplateMessage;
import com.jfatty.zcloud.wechat.exception.WxErrorException;
import com.jfatty.zcloud.wechat.vo.MsgRequest;

/**
 * 描述 我的微信服务接口，主要用于结合自己的业务和微信接口
 * @author jfatty on 2019/4/7
 * @email jfatty@163.com
 */
public interface WxService {


    //消息处理
    /**
     * 处理消息
     * 开发者可以根据用户发送的消息和自己的业务，自行返回合适的消息；
     * @param msgRequest : 接收到的消息
     * @param account ： appId
     */
    public String processMsg(MsgRequest msgRequest, Account account) throws WxErrorException;


    //获取微信公众号中当前的菜单
    public JSONObject getMenu(Account mpAccount) throws WxErrorException ;


    //发布菜单
    public JSONObject publishMenu(Account mpAccount) throws WxErrorException ;

    //删除菜单
    public JSONObject deleteMenu(Account mpAccount) throws WxErrorException ;

    //同步粉丝列表
    public boolean syncAccountFansList(Account mpAccount) throws WxErrorException ;

    /**
     * 发送模板消息
     * @param tplMsg
     * @param mpAccount 消息内容
     * @return
     */
    public JSONObject sendTemplateMessage(TemplateMessage tplMsg, Account mpAccount) throws WxErrorException ;

    //同步服务器的用户标签
    public boolean syncUserTagList(Account mpAccount) throws WxErrorException ;

    JSONObject massSendTextByOpenId(String openId, String content, Account mpAccount) throws WxErrorException ;
}
