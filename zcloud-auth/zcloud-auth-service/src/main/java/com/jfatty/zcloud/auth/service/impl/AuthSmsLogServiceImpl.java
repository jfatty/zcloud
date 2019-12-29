package com.jfatty.zcloud.auth.service.impl;

import com.jfatty.zcloud.auth.entity.AuthSmsLog;
import com.jfatty.zcloud.auth.mapper.AuthSmsLogMapper;
import com.jfatty.zcloud.auth.service.AuthSmsLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统短信息发送日志记录表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-27
 */
@Slf4j
@Service
public class AuthSmsLogServiceImpl extends BaseAuthServiceImpl<AuthSmsLog,AuthSmsLogMapper> implements AuthSmsLogService {

    private AuthSmsLogMapper authSmsLogMapper ;

    @Autowired
    public void setAuthSmsLogMapper(AuthSmsLogMapper authSmsLogMapper) {
        super.setBaseMapper(authSmsLogMapper);
        this.authSmsLogMapper = authSmsLogMapper;
    }
}
