package com.jfatty.zcloud.wechat.service.impl;


import com.jfatty.zcloud.wechat.entity.MsgNews;
import com.jfatty.zcloud.wechat.mapper.MsgNewsMapper;
import com.jfatty.zcloud.wechat.service.MsgNewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/4/16
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class MsgNewsServiceImpl implements MsgNewsService {

    @Autowired
    private MsgNewsMapper msgNewsMapper ;

    @Override
    public List<MsgNews> listMsgNewsList(MsgNews msgNew) {
        return msgNewsMapper.listMsgNewsList(msgNew);
    }
}
