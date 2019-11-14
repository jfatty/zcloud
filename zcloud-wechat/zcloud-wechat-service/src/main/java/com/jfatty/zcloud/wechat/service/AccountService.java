package com.jfatty.zcloud.wechat.service;


import com.jfatty.zcloud.wechat.entity.Account;

/**
 * <p>
 * 微信账号表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-04-04
 */
public interface AccountService extends BaseWechatService<Account> {

    /**
     * 根据微信账号信息进行查询
     * @param account 微信账号
     * @return
     */
    Account getByAccount(String account);

}
