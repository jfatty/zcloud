package com.jfatty.zcloud.wechat.controller;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.wechat.entity.AccountFans;
import com.jfatty.zcloud.wechat.feign.AccountFansFeignClient;
import com.jfatty.zcloud.wechat.interfaces.IAccountFans;
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
public class AccountFansController implements IAccountFans {

    @Autowired
    private AccountFansFeignClient accountFansFeignClient ;

    @Override
    public RELResultUtils<AccountFans> table(Map<String, Object> params) {
        return accountFansFeignClient.table(params);
    }

    @Override
    public RELResultUtils<AccountFans> table(String v, Integer pageIndex, Integer pageSize) {
        return accountFansFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public List<AccountFans> list() {
        return accountFansFeignClient.list();
    }

    @Override
    public Object save(AccountFans entity) {
        return accountFansFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return accountFansFeignClient.view(id);
    }

    @Override
    public Object edit(AccountFans entity) {
        return accountFansFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return accountFansFeignClient.delete(params);
    }
}
