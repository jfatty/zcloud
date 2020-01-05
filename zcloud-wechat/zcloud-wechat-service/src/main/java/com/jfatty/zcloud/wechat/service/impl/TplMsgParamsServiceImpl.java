package com.jfatty.zcloud.wechat.service.impl;

import com.jfatty.zcloud.wechat.entity.TplMsgParams;
import com.jfatty.zcloud.wechat.mapper.TplMsgParamsMapper;
import com.jfatty.zcloud.wechat.service.TplMsgParamsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 微信模板消息参数配置表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2020-01-05
 */
@Slf4j
@Service
public class TplMsgParamsServiceImpl extends BaseWechatServiceImpl<TplMsgParams,TplMsgParamsMapper> implements TplMsgParamsService {

    private TplMsgParamsMapper tplMsgParamsMapper ;


    @Autowired
    public void setTplMsgParamsMapper(TplMsgParamsMapper tplMsgParamsMapper) {
        super.setBaseMapper(tplMsgParamsMapper);
        this.tplMsgParamsMapper = tplMsgParamsMapper;
    }

    @Override
    public List<TplMsgParams> getTplById(String tplId) {
        return tplMsgParamsMapper.getTplById(tplId);
    }
}
