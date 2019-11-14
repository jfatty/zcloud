package com.jfatty.zcloud.wechat.service.impl;


import com.jfatty.zcloud.wechat.entity.AccountFans;
import com.jfatty.zcloud.wechat.mapper.AccountFansMapper;
import com.jfatty.zcloud.wechat.service.AccountFansService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信粉丝表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-04-07
 */
@Slf4j
@Service
public class AccountFansServiceImpl extends BaseWechatServiceImpl<AccountFans, AccountFansMapper> implements AccountFansService {

    private AccountFansMapper accountFansMapper ;

    @Autowired
    public void setAccountFansMapper(AccountFansMapper accountFansMapper) {
        super.setBaseMapper(accountFansMapper);
        this.accountFansMapper = accountFansMapper;
    }
}
