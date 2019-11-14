package com.jfatty.zcloud.wechat.service;

import com.jfatty.zcloud.wechat.entity.AccountMenu;

import java.util.List;

/**
 * <p>
 * 微信菜单表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-04-07
 */
public interface AccountMenuService extends BaseWechatService<AccountMenu> {

    /**
     * 获取微信菜单
     * @param account 微信账号
     * @return
     */
    List<AccountMenu> selectWxMenus(String account);

    /**
     * 删除原有菜单
     * @param delMenu
     */
    void deleteMenu(AccountMenu delMenu) throws  Exception ;

    /**
     * 保存菜单
     * @param accountMenu
     * @throws Exception
     */
    boolean save(AccountMenu accountMenu) ;
}
