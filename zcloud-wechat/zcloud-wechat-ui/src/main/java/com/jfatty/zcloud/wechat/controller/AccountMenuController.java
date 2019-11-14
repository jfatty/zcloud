package com.jfatty.zcloud.wechat.controller;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.wechat.entity.AccountMenu;
import com.jfatty.zcloud.wechat.feign.AccountMenuFeignClient;
import com.jfatty.zcloud.wechat.interfaces.IAccountMenu;
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
public class AccountMenuController  implements IAccountMenu {

    @Autowired
    private AccountMenuFeignClient accountMenuFeignClient ;

    @Override
    public RELResultUtils<AccountMenu> table(Map<String, Object> params) {
        return accountMenuFeignClient.table(params);
    }

    @Override
    public RELResultUtils<AccountMenu> table(String v, Integer pageIndex, Integer pageSize) {
        return accountMenuFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public List<AccountMenu> list() {
        return accountMenuFeignClient.list();
    }

    @Override
    public Object save(AccountMenu entity) {
        return accountMenuFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return accountMenuFeignClient.view(id);
    }

    @Override
    public Object edit(AccountMenu entity) {
        return accountMenuFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return accountMenuFeignClient.delete(params);
    }
}
