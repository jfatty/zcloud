package com.jfatty.zcloud.wechat.mapper;



import com.jfatty.zcloud.wechat.entity.MsgBase;
import com.jfatty.zcloud.wechat.entity.MsgNews;
import com.jfatty.zcloud.wechat.entity.MsgText;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/4/7
 * @email jfatty@163.com
 */
public interface MsgBaseMapper {



    MsgBase getById(String id);

    List<MsgBase> listForPage(MsgBase searchEntity);

    List<MsgNews> listMsgNewsByBaseId(String[] ids);

    MsgText getMsgTextByBaseId(String id);

    MsgText getMsgTextBySubscribe(String account);

    MsgText getMsgTextByInputCode(Map<String, Object> map);

    //插入
    int insert(MsgBase msgBase);
    //更新
    int updateById(MsgBase msgBase);

    //根据文本消息ID集合删除
    int deleteByMsgTextIds(Collection<? extends Serializable> list);
}
