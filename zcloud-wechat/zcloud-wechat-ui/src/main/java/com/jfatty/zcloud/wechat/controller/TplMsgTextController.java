package com.jfatty.zcloud.wechat.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.wechat.entity.TplMsgText;
import com.jfatty.zcloud.wechat.feign.TplMsgTextFeignClient;
import com.jfatty.zcloud.wechat.req.TplMsgTextReq;
import com.jfatty.zcloud.wechat.res.TplMsgTextRes;
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
@RequestMapping(value={"/tplMsgText"})
public class TplMsgTextController implements IBaseController<TplMsgText,TplMsgTextReq,TplMsgTextRes> {

    @Autowired
    private TplMsgTextFeignClient tplMsgTextFeignClient ;

    @Override
    public RELResultUtils<TplMsgTextRes> table(Map<String, Object> params) {
        return tplMsgTextFeignClient.table(params);
    }

    @Override
    public RELResultUtils<TplMsgTextRes> table(String v, Integer pageIndex, Integer pageSize) {
        return tplMsgTextFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return tplMsgTextFeignClient.list();
    }

    @Override
    public List<TplMsgTextRes> list(Long v) {
        return tplMsgTextFeignClient.list(v);
    }

    @Override
    public Object save(TplMsgTextReq entity) {
        return tplMsgTextFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return tplMsgTextFeignClient.view(id);
    }

    @Override
    public Object edit(TplMsgTextReq entity) {
        return tplMsgTextFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return tplMsgTextFeignClient.delete(params);
    }
}
