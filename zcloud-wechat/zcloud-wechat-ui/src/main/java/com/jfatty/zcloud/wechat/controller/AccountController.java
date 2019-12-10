package com.jfatty.zcloud.wechat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.wechat.entity.Account;
import com.jfatty.zcloud.wechat.feign.AccountFeignClient;
import com.jfatty.zcloud.wechat.interfaces.IAccount;
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
@RequestMapping(value={"/account"})
public class AccountController implements IBaseController<Account> {

    @Autowired
    private AccountFeignClient accountFeignClient ;

    @Override
    public RELResultUtils<Account> table(Map<String, Object> params) {
        return accountFeignClient.table(params);
    }

    @Override
    public RELResultUtils<Account> table(String v, Integer pageIndex, Integer pageSize) {
        return accountFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return accountFeignClient.list();
    }

    @Override
    public List<Account> list(Long v) {
        return accountFeignClient.list(v);
    }

    @Override
    public Object save(Account entity) {
        return accountFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
        //return objectMapper.convertValue(accountFeignClient.view(id),Account.class);
        return accountFeignClient.view(id);
    }

    @Override
    public Object edit(Account entity) {
        return accountFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return accountFeignClient.delete(params);
    }
}
