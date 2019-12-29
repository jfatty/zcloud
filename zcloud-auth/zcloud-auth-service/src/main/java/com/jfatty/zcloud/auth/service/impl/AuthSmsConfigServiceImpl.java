package com.jfatty.zcloud.auth.service.impl;

import com.jfatty.zcloud.auth.entity.AuthSmsConfig;
import com.jfatty.zcloud.auth.mapper.AuthSmsConfigMapper;
import com.jfatty.zcloud.auth.service.AuthSmsConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统短信息配置表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-27
 */
@Slf4j
@Service
public class AuthSmsConfigServiceImpl extends BaseAuthServiceImpl<AuthSmsConfig,AuthSmsConfigMapper> implements AuthSmsConfigService {


    private AuthSmsConfigMapper authSmsConfigMapper ;

    @Autowired
    public void setAuthSmsConfigMapper(AuthSmsConfigMapper authSmsConfigMapper) {
        super.setBaseMapper(authSmsConfigMapper);
        this.authSmsConfigMapper = authSmsConfigMapper;
    }
}
