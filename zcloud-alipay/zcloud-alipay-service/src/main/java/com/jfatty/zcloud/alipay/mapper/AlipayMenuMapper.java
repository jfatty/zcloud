package com.jfatty.zcloud.alipay.mapper;

import com.jfatty.zcloud.alipay.entity.AlipayMenu;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 描述
 *
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */
public interface AlipayMenuMapper extends IBaseMapper<AlipayMenu> {

    /**
     * 通过菜单KEY，查询菜单
     * @param menuKey
     * @return
     */
    AlipayMenu getMenuByMenuKey(@Param("menuKey") String menuKey);
}
