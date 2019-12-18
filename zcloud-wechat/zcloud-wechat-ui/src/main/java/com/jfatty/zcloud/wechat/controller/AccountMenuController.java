package com.jfatty.zcloud.wechat.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.wechat.entity.AccountMenu;
import com.jfatty.zcloud.wechat.feign.AccountMenuFeignClient;
import com.jfatty.zcloud.wechat.req.AccountMenuReq;
import com.jfatty.zcloud.wechat.res.AccountMenuRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping(value={"/accountMenu"})
public class AccountMenuController  implements IBaseController<AccountMenu,AccountMenuReq,AccountMenuRes> {

    @Autowired
    private AccountMenuFeignClient accountMenuFeignClient ;

    @Override
    public RELResultUtils<AccountMenuRes> table(Map<String, Object> params) {
        return accountMenuFeignClient.table(params);
    }

    @Override
    public RELResultUtils<AccountMenuRes> table(String v, Integer pageIndex, Integer pageSize) {
        return accountMenuFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return accountMenuFeignClient.list();
    }

    @Override
    public List<AccountMenuRes> list(Long v) {
        return accountMenuFeignClient.list(v);
    }

    @Override
    public Object save(AccountMenuReq entity) {
        return accountMenuFeignClient.save(entity);
    }

    @RequestMapping(value = {"saveMenu"} , method = RequestMethod.POST)
    public Object save(String menus) {
        return accountMenuFeignClient.saveMenu(menus);
    }

    @Override
    public Object view(String id) {
        return accountMenuFeignClient.view(id);
    }

    @Override
    public Object edit(AccountMenuReq entity) {
        return accountMenuFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return accountMenuFeignClient.delete(params);
    }

    @RequestMapping(value = "/publishMenu", method = RequestMethod.GET)
    public Object publishMenu() {
        return accountMenuFeignClient.publishMenu();
    }

}
