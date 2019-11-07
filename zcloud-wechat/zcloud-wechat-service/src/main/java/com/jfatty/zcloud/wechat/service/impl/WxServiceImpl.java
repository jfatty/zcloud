package com.jfatty.zcloud.wechat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.jfatty.zcloud.wechat.entity.*;
import com.jfatty.zcloud.wechat.exception.WxErrorException;
import com.jfatty.zcloud.wechat.mapper.*;
import com.jfatty.zcloud.wechat.service.WxService;
import com.jfatty.zcloud.wechat.utils.*;
import com.jfatty.zcloud.wechat.utils.wx.HttpMethod;
import com.jfatty.zcloud.wechat.utils.wx.WxApi;
import com.jfatty.zcloud.wechat.utils.wx.WxUtil;
import com.jfatty.zcloud.wechat.vo.MsgRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 描述 我的微信服务接口，主要用于结合自己的业务和微信接口
 *
 * @author jfatty on 2019/4/7
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class WxServiceImpl implements WxService {


    @Autowired
    private MsgBaseMapper msgBaseMapper ;

    @Autowired
    private AccountFansMapper accountFansMapper ;

    @Autowired
    private MsgNewsMapper msgNewsMapper ;

    @Autowired
    private MsgTextMapper msgTextMapper ;

    @Autowired
    private AccountMenuMapper accountMenuMapper ;

    @Autowired
    private UserTagMapper userTagMapper ;

    @Override
    public String processMsg(MsgRequest msgRequest, Account account) throws WxErrorException {
        String msgtype = msgRequest.getMsgType();// 接收到的消息类型
        String respXml = null;// 返回的内容；
        if (msgtype.equals(MsgType.Text.toString())) {
            /**
             * 文本消息，一般公众号接收到的都是此类型消息
             */
            respXml = this.processTextMsg(msgRequest, account);
        } else if (msgtype.equals(MsgType.Event.toString())) {// 事件消息
            /**
             * 用户订阅公众账号、点击菜单按钮的时候，会触发事件消息
             */
            respXml = this.processEventMsg(msgRequest, account);

            // 其他消息类型，开发者自行处理
        } else if (msgtype.equals(MsgType.Image.toString())) {// 图片消息

        } else if (msgtype.equals(MsgType.Location.toString())) {// 地理位置消息

        }
        // 如果没有对应的消息，默认返回订阅消息；
        if (StringUtils.isEmpty(respXml)) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("account",account.getAccount());
            map.put("inputcode",MsgType.SUBSCRIBE.toString());
            MsgText text = msgBaseMapper.getMsgTextByInputCode(map);
            if (text != null) {
                respXml = MsgXmlUtil.textToXml(WxMessageBuilder.getMsgResponseText(msgRequest, text));
            }
        }
        return respXml;
    }


    // 处理文本消息
    private String processTextMsg(MsgRequest msgRequest, Account account) {
        String content = msgRequest.getContent();
        if (!StringUtils.isEmpty(content)) {// 文本消息
            String tmpContent = content.trim();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("tmpContent",tmpContent);
            map.put("msgCount",account.getMsgCount());
            map.put("account",account.getAccount());
            List<MsgNews> msgNews = msgNewsMapper.getRandomMsgByContent(map);
            if (!CollectionUtils.isEmpty(msgNews)) {
                return MsgXmlUtil.newsToXml(WxMessageBuilder.getMsgResponseNews(msgRequest, msgNews));
            }
            map.put("msgCount",1);
            MsgText text = msgBaseMapper.getMsgTextByInputCode(map);
            if (text != null)
                return MsgXmlUtil.textToXml(WxMessageBuilder.getMsgResponseText(msgRequest, text));
        }
        return null;
    }


    // 处理事件消息
    private String processEventMsg(MsgRequest msgRequest, Account account) throws WxErrorException {
        String key = msgRequest.getEventKey();
        if (MsgType.SUBSCRIBE.toString().equals(msgRequest.getEvent())) {// 订阅消息
            log.info("关注者openId----------" + msgRequest.getFromUserName());
            String openId = msgRequest.getFromUserName();
            AccountFans fans = WxApiClient.syncAccountFans(openId, account);
            // 用户关注微信公众号后更新粉丝表
            if (null != fans) {
                AccountFans tmpFans = accountFansMapper.getByOpenId(openId);
                if (tmpFans == null) {
                    fans.setAccount(account.getAccount());
                    accountFansMapper.insert(fans);
                } else {
                    fans.setId(tmpFans.getId());
                    accountFansMapper.updateById(fans);
                }
            }
            MsgText text = msgBaseMapper.getMsgTextBySubscribe(account.getAccount());
            if (text != null) {
                return MsgXmlUtil.textToXml(WxMessageBuilder.getMsgResponseText(msgRequest, text));
            }
        } else if (MsgType.UNSUBSCRIBE.toString().equals(msgRequest.getEvent())) {// 取消订阅消息
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("account",account.getAccount());
            map.put("inputcode",MsgType.UNSUBSCRIBE.toString());
            MsgText text = msgBaseMapper.getMsgTextByInputCode(map);
            if (text != null) {
                return MsgXmlUtil.textToXml(WxMessageBuilder.getMsgResponseText(msgRequest, text));
            }
        } else {// 点击事件消息
            if (!StringUtils.isEmpty(key)) {
                /**
                 * 固定消息
                 * _fix_ ：在我们创建菜单的时候，做了限制，对应的event_key 加了 _fix_
                 *
                 * 当然开发者也可以进行修改
                 */
                if (key.startsWith("_fix_")) {
                    String baseIds = key.substring("_fix_".length());
                    if (!StringUtils.isEmpty(baseIds)) {
                        String[] idArr = baseIds.split(",");
                        if (idArr.length > 1) {// 多条图文消息
                            List<MsgNews> msgNews = msgBaseMapper.listMsgNewsByBaseId(idArr);
                            if (msgNews != null && msgNews.size() > 0) {
                                return MsgXmlUtil.newsToXml(WxMessageBuilder.getMsgResponseNews(msgRequest, msgNews));
                            }
                        } else {// 图文消息，或者文本消息
                            MsgBase msg = msgBaseMapper.getById(baseIds);
                            if (msg.getMsgtype().equals(MsgType.Text.toString())) {
                                MsgText text = msgBaseMapper.getMsgTextByBaseId(baseIds);
                                if (text != null) {
                                    return MsgXmlUtil.textToXml(WxMessageBuilder.getMsgResponseText(msgRequest, text));
                                }
                            } else {
                                List<MsgNews> msgNews = msgBaseMapper.listMsgNewsByBaseId(idArr);
                                if (msgNews != null && msgNews.size() > 0) {
                                    return MsgXmlUtil.newsToXml(WxMessageBuilder.getMsgResponseNews(msgRequest, msgNews));
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public JSONObject getMenu(Account mpAccount) throws WxErrorException {
        JSONObject rstObj = WxApiClient.getMenus(mpAccount);//
        log.info("GET菜单返回消息如下:" + rstObj.toString());
        return rstObj ;
    }

    // 发布菜单
    public JSONObject publishMenu(Account mpAccount) throws WxErrorException {
        // 获取数据库菜单
        List<AccountMenu> menus = accountMenuMapper.selectWxMenus(mpAccount.getAccount());
        MsgText msgText = new MsgText() ;
        msgText.setAccount(mpAccount.getAccount());
        List<MsgText> msgTextList = msgTextMapper.getMsgTextList(msgText);
        MsgNews msgNew = new MsgNews();
        msgNew.setAccount(mpAccount.getAccount());
        List<MsgNews> msgNews = msgNewsMapper.listMsgNewsList(msgNew);
        Matchrule matchrule = new Matchrule();
        //TODO
        String menuJson = JSONObject.toJSONString(WxUtil.prepareMenus(menus, matchrule,msgTextList,msgNews));
        log.info("创建菜单传参如下:" + menuJson);
        JSONObject rstObj = WxApiClient.publishMenus(menuJson, mpAccount);// 创建普通菜单
        log.info("创建菜单返回消息如下:" + rstObj.toString());
        // 以下为创建个性化菜单demo，只为男创建菜单；其他个性化需求 设置 Matchrule 属性即可
        // matchrule.setSex("1");//1-男 ；2-女
        // JSONObject rstObj = WxApiClient.publishAddconditionalMenus(menuJson,mpAccount);//创建个性化菜单
        // if(rstObj != null){//成功，更新菜单组
        // if(rstObj.containsKey("menu_id")){
        // menuGroupDao.updateMenuGroupDisable();
        // menuGroupDao.updateMenuGroupEnable(gid);
        // }else if(rstObj.containsKey("errcode") && rstObj.getInt("errcode") == 0){
        // menuGroupDao.updateMenuGroupDisable();
        // menuGroupDao.updateMenuGroupEnable(gid);
        // }
        // }
        return rstObj;
    }

    // 删除菜单
    public JSONObject deleteMenu(Account mpAccount)  throws WxErrorException {
        JSONObject rstObj = WxApiClient.deleteMenu(mpAccount);
        if (rstObj != null && rstObj.getIntValue("errcode") == 0) {// 成功，更新菜单组
            //menuGroupDao.updateMenuGroupDisable();
        }
        return rstObj;
    }

    // 同步粉丝列表
    public boolean syncAccountFansList(Account mpAccount) throws WxErrorException  {
        String nextOpenId = null;
        AccountFans accountFans = new AccountFans();
        accountFans.setAccount(mpAccount.getAccount());
        AccountFans lastFans = accountFansMapper.getLastOpenId(accountFans);
        if (lastFans != null) {
            nextOpenId = lastFans.getOpenId();
        }
        return doSyncAccountFansList(nextOpenId, mpAccount);
    }

    // 同步粉丝列表(开发者在这里可以使用递归处理)
    private boolean doSyncAccountFansList(String nextOpenId, Account mpAccount) throws WxErrorException  {
        String url = WxApi.getFansListUrl(WxApiClient.getAccessToken(mpAccount), nextOpenId);
        log.info("同步粉丝入参消息如下:" + url);
        JSONObject jsonObject = WxApi.httpsRequest(url, HttpMethod.POST, null);
        log.info("同步粉丝返回消息如下:" + jsonObject.toString());
        if (jsonObject.containsKey("errcode")) {
            return false;
        }
        List<AccountFans> fansList = new ArrayList<AccountFans>();
        if (jsonObject.containsKey("data")) {
            if (jsonObject.getJSONObject("data").containsKey("openid")) {
                JSONArray openidArr = jsonObject.getJSONObject("data").getJSONArray("openid");
                int length = openidArr.size();
                for (int i = 0; i < length; i++) {
                    Object openId = openidArr.get(i);
                    AccountFans fans = WxApiClient.syncAccountFans(openId.toString(), mpAccount);
                    // 设置公众号
                    fans.setAccount(WxMemoryCacheClient.getAccount());
                    fansList.add(fans);
                }
                // 批处理
                accountFansMapper.insertList(fansList);
            }
        }
        return true;
    }

    @Override
    public JSONObject sendTemplateMessage(TemplateMessage tplMsg, Account mpAccount) throws WxErrorException {
        return WxApiClient.sendTemplateMessage(tplMsg, mpAccount);
    }

    @Override
    public boolean syncUserTagList(Account mpAccount) throws WxErrorException {
        String url = null;
        try {
            url = WxApi.getUserTagList(WxApiClient.getAccessToken(mpAccount));
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        log.info("同步用户标签参消息如下:"+url);
        JSONObject jsonObject = WxApi.httpsRequest(url, HttpMethod.GET, null);
        log.info("同步用户标签消息如下:"+jsonObject.toString());
        if(jsonObject.containsKey("errcode")){
            return false;
        }
        JSONArray arr = jsonObject.getJSONArray("tags");//获取jsonArray对象
        String js=JSONObject.toJSONString(arr);//将array数组转换成字符串
        List<UserTag> userTagList = JSONObject.parseArray(js, UserTag.class);//把字符串转换成集合
        //判断是否已经同步
        //排序
        Collections.sort(userTagList, new Comparator<UserTag>() {
            @Override
            public int compare(UserTag o1, UserTag o2) {
                return o2.getId().compareTo(o1.getId());
            }
        });
        UserTag userTag = userTagList.get(0);
        Integer maxIdInDb = userTagMapper.getMaxId(mpAccount.getAccount()) ;
        if (maxIdInDb == null ) //第一次同步，数据库没有数据返回null
            maxIdInDb = 0 ;
        if (null == userTag.getId() || Integer.parseInt(userTag.getId()) == maxIdInDb.intValue()) {
            //说明已经同步
            return true;
        }else if( Integer.parseInt(userTag.getId()) > maxIdInDb ){
            //如果微信服务器新增用户标签，同步新增标签，新增标签的ID比本地库的ID大
            for (UserTag tag: userTagList) {
                if( Integer.parseInt(tag.getId()) <= maxIdInDb){
                    userTagList.remove(tag);
                }
            }
            userTagMapper.addList(userTagList);
            return true;
        }
        return true;
    }

    @Override
    public JSONObject massSendTextByOpenId(String openId, String content, Account mpAccount) throws WxErrorException {
        return WxApiClient.massSendTextByOpenId(openId,content,mpAccount);
    }
}
