package com.jfatty.zcloud.wechat.utils;

/**
 * 描述 消息类型：所有微信涉及到的消息类型统一管理
 * @author jfatty on 2019/4/7
 * @email jfatty@163.com
 */
public enum  MsgType {

    Text("text"),//文本消息
    News("news"),//图文消息
    Location("location"),//地理位置消息
    Image("image"),//图片消息
    Voice("voice"),//语音消息
    Video("video"),//视频消息
    Event("event"),//事件消息

    MPNEWS("mpnews"),//群发图文消息

    SUBSCRIBE("subscribe"),//订阅消息
    UNSUBSCRIBE("unsubscribe");//取消订阅

    private String name;

    private MsgType(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }

}
