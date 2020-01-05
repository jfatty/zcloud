package com.jfatty.zcloud.wechat.service;

import com.jfatty.zcloud.wechat.entity.TplMsgParams;

import java.util.List;

/**
 * <p>
 * 微信模板消息参数配置表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2020-01-05
 */
public interface TplMsgParamsService extends BaseWechatService<TplMsgParams> {


    List<TplMsgParams> getTplById(String tplId) ;

}
