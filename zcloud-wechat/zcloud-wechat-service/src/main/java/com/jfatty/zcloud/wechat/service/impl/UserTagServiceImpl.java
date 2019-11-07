package com.jfatty.zcloud.wechat.service.impl;


import com.jfatty.zcloud.base.service.impl.BaseServiceImpl;
import com.jfatty.zcloud.wechat.entity.UserTag;
import com.jfatty.zcloud.wechat.mapper.UserTagMapper;
import com.jfatty.zcloud.wechat.service.UserTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信用户标签 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-04-28
 */
@Slf4j
@Service
public class UserTagServiceImpl extends BaseServiceImpl<UserTag, UserTagMapper> implements UserTagService {

    private  UserTagMapper userTagMapper ;

    @Autowired
    public void setUserTagMapper(UserTagMapper userTagMapper) {
        super.setBaseMapper(userTagMapper);
        this.userTagMapper = userTagMapper;
    }
}
