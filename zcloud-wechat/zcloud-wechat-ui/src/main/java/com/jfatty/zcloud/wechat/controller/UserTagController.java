package com.jfatty.zcloud.wechat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.wechat.entity.TplMsgText;
import com.jfatty.zcloud.wechat.entity.UserTag;
import com.jfatty.zcloud.wechat.feign.UserTagFeignClient;
import com.jfatty.zcloud.wechat.interfaces.IUserTag;
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
@RequestMapping(value={"/userTag"})
public class UserTagController implements IBaseController<UserTag> {

    @Autowired
    private UserTagFeignClient userTagFeignClient ;

    @Override
    public RELResultUtils<UserTag> table(Map<String, Object> params) {
        return userTagFeignClient.table(params);
    }

    @Override
    public RELResultUtils<UserTag> table(String v, Integer pageIndex, Integer pageSize) {
        return userTagFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return userTagFeignClient.list();
    }

    @Override
    public List<UserTag> list(Long v) {
        return userTagFeignClient.list(v);
    }

    @Override
    public Object save(UserTag entity) {
        return userTagFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return userTagFeignClient.view(id);
    }

    @Override
    public Object edit(UserTag entity) {
        return userTagFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return userTagFeignClient.delete(params);
    }
}
