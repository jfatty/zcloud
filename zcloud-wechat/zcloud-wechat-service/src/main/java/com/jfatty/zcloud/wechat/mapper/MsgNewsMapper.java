package com.jfatty.zcloud.wechat.mapper;



import com.jfatty.zcloud.wechat.entity.MsgNews;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 微信推送消息表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-04-07
 */
public interface MsgNewsMapper {

  List<MsgNews> getRandomMsgByContent(Map<String, Object> map);

  /**
   * 获取新闻消息列表
   * @param msgNew
   * @return
   */
  List<MsgNews> listMsgNewsList(MsgNews msgNew);
}
