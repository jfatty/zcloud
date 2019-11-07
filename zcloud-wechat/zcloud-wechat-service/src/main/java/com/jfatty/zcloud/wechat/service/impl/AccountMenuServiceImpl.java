package com.jfatty.zcloud.wechat.service.impl;


import com.jfatty.zcloud.wechat.entity.AccountMenu;
import com.jfatty.zcloud.wechat.mapper.AccountMenuMapper;
import com.jfatty.zcloud.wechat.service.AccountMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 微信菜单表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-04-07
 */
@Slf4j
@Service
public class AccountMenuServiceImpl implements AccountMenuService {

    @Autowired
    private AccountMenuMapper accountMenuMapper ;

    @Override
    public List<AccountMenu> selectWxMenus(String account) {
        return accountMenuMapper.selectWxMenus(account);
    }


    @Override
    public void deleteMenu(AccountMenu delMenu) throws Exception {
        accountMenuMapper.deleteMenu(delMenu) ;
    }

    @Override
    public boolean save(AccountMenu accountMenu) throws Exception {
        return ( accountMenuMapper.save(accountMenu) > 0 );
    }
}
