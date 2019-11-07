package com.jfatty.zcloud.wechat.service;

import com.jfatty.zcloud.wechat.entity.MsgNews;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/4/16
 * @email jfatty@163.com
 */
public interface MsgNewsService {

    /**
     * 获取新闻消息列表
     * @param msgNew
     * @return
     */
    List<MsgNews> listMsgNewsList(MsgNews msgNew);
}
