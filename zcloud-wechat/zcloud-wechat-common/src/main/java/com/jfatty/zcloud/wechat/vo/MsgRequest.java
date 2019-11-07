package com.jfatty.zcloud.wechat.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述 用户发送给公众号的消息；
 * @author jfatty on 2019/4/7
 * @email jfatty@163.com
 */
@Data
public class MsgRequest implements Serializable {

    private String MsgType;//消息类型
    private String MsgId;
    private String FromUserName;//openid
    private String ToUserName;
    private String CreateTime;
    //文本消息
    private String Content;
    //图片消息
    private String PicUrl;
    //地理位置消息
    private String Location_X;
    private String Location_Y;
    private String Scale;
    private String Label;
    //事件消息
    private String Event;
    private String EventKey;

}
