package com.jfatty.zcloud.wechat.controller;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.wechat.entity.Account;
import com.jfatty.zcloud.wechat.feign.AccountFeignClient;
import com.jfatty.zcloud.wechat.interfaces.IAccount;
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
public class AccountController implements IAccount {

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
    public List<Account> list() {
        return accountFeignClient.list();
    }

    @Override
    public Object save(Account entity) {
        return accountFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
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
