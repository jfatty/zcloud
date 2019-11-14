package com.jfatty.zcloud.wechat.service.impl;


import com.jfatty.zcloud.wechat.entity.TplMsgText;
import com.jfatty.zcloud.wechat.mapper.TplMsgTextMapper;
import com.jfatty.zcloud.wechat.service.TplMsgTextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信模板消息 服务实现类
 * </p>
 * @author jfatty
 * @since 2019-04-23
 */
@Slf4j
@Service
public class TplMsgTextServiceImpl extends BaseWechatServiceImpl<TplMsgText,TplMsgTextMapper> implements TplMsgTextService {

    private TplMsgTextMapper tplMsgTextMapper ;

    @Autowired
    public void setTplMsgTextMapper(TplMsgTextMapper tplMsgTextMapper) {
        super.setBaseMapper(tplMsgTextMapper);
        this.tplMsgTextMapper = tplMsgTextMapper;
    }
}
