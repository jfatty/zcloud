package com.jfatty.zcloud.wechat.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.wechat.entity.TplMsgParams;
import com.jfatty.zcloud.wechat.feign.TplMsgParamsFeignClient;
import com.jfatty.zcloud.wechat.req.TplMsgParamsReq;
import com.jfatty.zcloud.wechat.res.TplMsgParamsRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述 微信模板消息参数配置表
 *
 * @author jfatty on 2020/4/17
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/tplMsgParams"})
public class TplMsgParamsController implements IBaseController<TplMsgParams,TplMsgParamsReq,TplMsgParamsRes> {


    @Autowired
    private TplMsgParamsFeignClient tplMsgParamsFeignClient ;


    @Override
    public RELResultUtils<TplMsgParamsRes> table(Map<String, Object> params) {
        return tplMsgParamsFeignClient.table(params);
    }

    @Override
    public RELResultUtils<TplMsgParamsRes> table(String v, Integer pageIndex, Integer pageSize) {
        return tplMsgParamsFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return tplMsgParamsFeignClient.list();
    }

    @Override
    public List<TplMsgParamsRes> list(Long v) {
        return tplMsgParamsFeignClient.list(v);
    }

    @Override
    public Object save(TplMsgParamsReq entity) {
        return tplMsgParamsFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return tplMsgParamsFeignClient.view(id);
    }

    @Override
    public Object edit(TplMsgParamsReq entity) {
        return tplMsgParamsFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return tplMsgParamsFeignClient.delete(params);
    }

}
