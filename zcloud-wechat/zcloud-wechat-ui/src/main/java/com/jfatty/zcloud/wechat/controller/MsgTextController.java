package com.jfatty.zcloud.wechat.controller;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.wechat.entity.MsgText;
import com.jfatty.zcloud.wechat.feign.MsgTextFeignClient;
import com.jfatty.zcloud.wechat.interfaces.IMsgText;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@RestController
public class MsgTextController implements IMsgText {

    @Autowired
    private MsgTextFeignClient msgTextFeignClient ;

    @Override
    public RELResultUtils<MsgText> table(Map<String, Object> params) {
        return msgTextFeignClient.table(params);
    }

    @Override
    public RELResultUtils<MsgText> table(String v, Integer pageIndex, Integer pageSize) {
        return msgTextFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public List<MsgText> list() {
        return msgTextFeignClient.list();
    }

    @Override
    public Object save(MsgText entity) {
        return msgTextFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return msgTextFeignClient.view(id);
    }

    @Override
    public Object edit(MsgText entity) {
        return msgTextFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return msgTextFeignClient.delete(params);
    }
}
