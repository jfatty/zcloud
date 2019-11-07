package com.jfatty.zcloud.wechat.mapper;



import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.wechat.entity.MsgText;

import java.util.List;

/**
 * 描述 文本消息
 *
 * @author jfatty on 2019/4/16
 * @email jfatty@163.com
 */
public interface MsgTextMapper extends IBaseMapper<MsgText> {


    /**
     * 获取文本消息列表
     * @param msgText
     * @return
     */
    List<MsgText> getMsgTextList(MsgText msgText);

}
