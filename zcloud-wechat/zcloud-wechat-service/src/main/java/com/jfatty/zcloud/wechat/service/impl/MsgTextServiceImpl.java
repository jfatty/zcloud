package com.jfatty.zcloud.wechat.service.impl;


import com.jfatty.zcloud.base.utils.UUIDGenerator;
import com.jfatty.zcloud.wechat.entity.MsgBase;
import com.jfatty.zcloud.wechat.entity.MsgText;
import com.jfatty.zcloud.wechat.mapper.MsgBaseMapper;
import com.jfatty.zcloud.wechat.mapper.MsgTextMapper;
import com.jfatty.zcloud.wechat.service.MsgTextService;
import com.jfatty.zcloud.wechat.utils.MsgType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/4/16
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class MsgTextServiceImpl  extends BaseWechatServiceImpl<MsgText,MsgTextMapper> implements MsgTextService {


    @Autowired
    private MsgBaseMapper msgBaseMapper ;

    private MsgTextMapper msgTextMapper ;

    @Autowired
    public void setMsgTextMapper(MsgTextMapper msgTextMapper) {
        super.setBaseMapper(msgTextMapper);
        this.msgTextMapper = msgTextMapper;
    }

    @Override
    public List<MsgText> getMsgTextList(MsgText msgText) {
        return msgTextMapper.getMsgTextList(msgText);
    }

    @Override
    public boolean save(MsgText entity) {
        MsgBase msgBase = new MsgBase();
        String baseId = UUIDGenerator.uuid() ;
        msgBase.setId(baseId);
        msgBase.setAccount(entity.getAccount());
        msgBase.setInputcode(entity.getInputcode());
        msgBase.setMsgtype(MsgType.Text.toString());
        msgBase.setCreateOperator(entity.getCreateOperator());
        msgBase.setCreateTime(entity.getCreateTime());
        msgBaseMapper.insert(msgBase);
        entity.setBaseId(baseId);
        return super.save(entity);
    }

    @Override
    public boolean updateById(MsgText entity) {
        MsgBase msgBase = msgBaseMapper.getById(entity.getBaseId());
        msgBase.setAccount(entity.getAccount());
        msgBase.setInputcode(entity.getInputcode());
        msgBase.setMsgtype(MsgType.Text.toString());
        msgBase.setUpdateOperator(entity.getUpdateOperator());
        msgBaseMapper.updateById(msgBase);
        return super.updateById(entity);
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        int res  = msgBaseMapper.deleteByMsgTextIds(idList);
        return super.removeByIds(idList);
    }
}
