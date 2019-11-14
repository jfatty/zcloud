package com.jfatty.zcloud.wechat.mapper;



import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.wechat.entity.AccountMenu;

import java.util.List;

/**
 * <p>
 * 微信菜单表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-04-07
 */
public interface AccountMenuMapper extends IBaseMapper<AccountMenu> {

    /**
     * 微信公众号菜单查询
     * @param account 微信账号
     * @return
     */
    List<AccountMenu> selectWxMenus(String account);

    /**
     * 删除原有菜单
     * @param delMenu
     * @return
     */
    Integer deleteMenu(AccountMenu delMenu);

    /**
     * 保存菜单
     * @param accountMenu
     * @return
     */
    Integer save(AccountMenu accountMenu);
}
