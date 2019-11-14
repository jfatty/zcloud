package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.feign.AccountUniqueFeignClient;
import com.jfatty.zcloud.system.interfaces.IAccountUnique;
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
public class AccountUniqueController implements IAccountUnique {

    @Autowired
    private AccountUniqueFeignClient accountUniqueFeignClient ;

    @Override
    public RELResultUtils<AccountUnique> table(Map<String, Object> params) {
        return accountUniqueFeignClient.table(params);
    }

    @Override
    public RELResultUtils<AccountUnique> table(String v, Integer pageIndex, Integer pageSize) {
        return accountUniqueFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public List<AccountUnique> list() {
        return accountUniqueFeignClient.list();
    }

    @Override
    public Object save(AccountUnique entity) {
        return accountUniqueFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return accountUniqueFeignClient.view(id);
    }

    @Override
    public Object edit(AccountUnique entity) {
        return accountUniqueFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return accountUniqueFeignClient.delete(params);
    }
}
