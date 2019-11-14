package com.jfatty.zcloud.wechat.service;

import com.jfatty.zcloud.base.service.BaseService;
import com.jfatty.zcloud.wechat.entity.MsgText;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/4/16
 * @email jfatty@163.com
 */
public interface MsgTextService extends BaseWechatService<MsgText> {


    /**
     * 获取文本消息列表
     * @param msgText
     * @return
     */
    List<MsgText> getMsgTextList(MsgText msgText);


}
