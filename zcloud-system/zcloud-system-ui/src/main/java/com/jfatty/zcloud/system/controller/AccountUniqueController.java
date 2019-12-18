package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.feign.AccountUniqueFeignClient;
import com.jfatty.zcloud.system.req.AccountUniqueReq;
import com.jfatty.zcloud.system.res.AccountUniqueRes;
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
@RequestMapping(value={"/accountUnique"})
public class AccountUniqueController implements IBaseController<AccountUnique,AccountUniqueReq,AccountUniqueRes> {

    @Autowired
    private AccountUniqueFeignClient accountUniqueFeignClient ;

    @Override
    public RELResultUtils<AccountUniqueRes> table(Map<String, Object> params) {
        return accountUniqueFeignClient.table(params);
    }

    @Override
    public RELResultUtils<AccountUniqueRes> table(String v, Integer pageIndex, Integer pageSize) {
        return accountUniqueFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return accountUniqueFeignClient.list();
    }

    @Override
    public List<AccountUniqueRes> list(Long v) {
        return accountUniqueFeignClient.list(v);
    }

    @Override
    public Object save(AccountUniqueReq entity) {
        return accountUniqueFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return accountUniqueFeignClient.view(id);
    }

    @Override
    public Object edit(AccountUniqueReq entity) {
        return accountUniqueFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return accountUniqueFeignClient.delete(params);
    }
}
