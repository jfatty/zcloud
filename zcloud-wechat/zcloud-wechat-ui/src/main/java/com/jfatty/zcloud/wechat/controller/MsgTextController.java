package com.jfatty.zcloud.wechat.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.wechat.entity.MsgText;
import com.jfatty.zcloud.wechat.feign.MsgTextFeignClient;
import com.jfatty.zcloud.wechat.req.MsgTextReq;
import com.jfatty.zcloud.wechat.res.MsgTextRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping(value={"/msgText"})
public class MsgTextController implements IBaseController<MsgText,MsgTextReq,MsgTextRes> {

    @Autowired
    private MsgTextFeignClient msgTextFeignClient ;

    @Override
    public RELResultUtils<MsgTextRes> table(Map<String, Object> params) {
        return msgTextFeignClient.table(params);
    }

    @Override
    public RELResultUtils<MsgTextRes> table(String v, Integer pageIndex, Integer pageSize) {
        return msgTextFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return msgTextFeignClient.list();
    }

    @Override
    public List<MsgTextRes> list(Long v) {
        return msgTextFeignClient.list(v);
    }

    @Override
    public Object save(MsgTextReq entity) {
        return msgTextFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return msgTextFeignClient.view(id);
    }

    @Override
    public Object edit(MsgTextReq entity) {
        return msgTextFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return msgTextFeignClient.delete(params);
    }
}
