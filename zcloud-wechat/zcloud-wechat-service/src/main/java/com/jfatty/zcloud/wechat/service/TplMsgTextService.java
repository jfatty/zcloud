package com.jfatty.zcloud.wechat.service;

import com.jfatty.zcloud.wechat.entity.TplMsgText;

/**
 * <p>
 * 微信模板消息 服务类
 * </p>
 * @author jfatty
 * @since 2019-04-23
 */
public interface TplMsgTextService extends BaseWechatService<TplMsgText> {

    TplMsgText getByAccount(String account, String kw);
}
