package com.jfatty.zcloud.wechat.mapper;


import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.wechat.entity.UserTag;

import java.util.List;

/**
 * <p>
 * 微信用户标签 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-04-28
 */
public interface UserTagMapper extends IBaseMapper<UserTag> {

    /**
     * 获取最大的ID和本地库存的比较决定是否同步
     * @return
     */
    Integer getMaxId(String account);

    /**
     *
     * @param list
     * @return
     */
    int addList(List<UserTag> list);
}
