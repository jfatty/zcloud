package com.jfatty.zcloud.wechat.service.impl;

import com.jfatty.zcloud.wechat.entity.Account;
import com.jfatty.zcloud.wechat.mapper.AccountMapper;
import com.jfatty.zcloud.wechat.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信账号表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-04-04
 */
@Slf4j
@Service
public class AccountServiceImpl extends BaseWechatServiceImpl<Account,AccountMapper> implements AccountService {

    private AccountMapper accountMapper ;

    @Autowired
    public void setAccountMapper(AccountMapper accountMapper) {
        super.setBaseMapper(accountMapper);
        this.accountMapper = accountMapper;
    }

    @Override
    public Account getByAccount(String account) {
        return accountMapper.getByAccount(account);
    }

    @Override
    public Account getActiveAccount() {
        return accountMapper.getActiveAccount();
    }
}
