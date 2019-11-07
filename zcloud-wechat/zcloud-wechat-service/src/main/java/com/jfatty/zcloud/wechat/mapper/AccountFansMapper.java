package com.jfatty.zcloud.wechat.mapper;


import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.wechat.entity.AccountFans;

import java.util.List;

/**
 * <p>
 * 微信粉丝表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-04-07
 */
public interface AccountFansMapper extends IBaseMapper<AccountFans> {

    /**
     * 根据openId获取粉丝信息
     * @param openId
     * @return
     */
    AccountFans getByOpenId(String openId);

    /**
     * 获取上次最后同步的一个粉丝
     * @return
     */
    AccountFans getLastOpenId(AccountFans accountFans);

    /**
     * 批量新增粉丝
     * @param fansList
     * @return
     */
    int insertList(List<AccountFans> fansList);
}
