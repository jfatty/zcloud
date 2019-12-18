package com.jfatty.zcloud.wechat.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.wechat.entity.AccountFans;
import com.jfatty.zcloud.wechat.feign.AccountFansFeignClient;
import com.jfatty.zcloud.wechat.req.AccountFansReq;
import com.jfatty.zcloud.wechat.res.AccountFansRes;
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
@RequestMapping(value={"/accountFans"})
public class AccountFansController implements IBaseController<AccountFans,AccountFansReq,AccountFansRes> {

    @Autowired
    private AccountFansFeignClient accountFansFeignClient ;

    @Override
    public RELResultUtils<AccountFansRes> table(Map<String, Object> params) {
        return accountFansFeignClient.table(params);
    }

    @Override
    public RELResultUtils<AccountFansRes> table(String v, Integer pageIndex, Integer pageSize) {
        return accountFansFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        Long v = System.currentTimeMillis();
        List<AccountFansRes> list = accountFansFeignClient.list(v);
        if(CollectionUtils.isNotEmpty(list))
            return ResultUtils.ok(list);
        return ResultUtils.build(400, "没有查询到数据");
    }

    @Override
    public List<AccountFansRes> list(Long v) {
        return accountFansFeignClient.list(v);
    }

    @Override
    public Object save(AccountFansReq entity) {
        return accountFansFeignClient.save(entity);
    }

    @Override
    public AccountFans view(String id) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(accountFansFeignClient.view(id),AccountFans.class);
    }

    @Override
    public Object edit(AccountFansReq entity) {
        return accountFansFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return accountFansFeignClient.delete(params);
    }
}
