package com.jfatty.zcloud.auth.api;


import com.jfatty.zcloud.auth.entity.AuthSmsLog;
import com.jfatty.zcloud.auth.interfaces.IAuthSmsLog;
import com.jfatty.zcloud.auth.req.AuthSmsLogReq;
import com.jfatty.zcloud.auth.res.AuthSmsLogRes;
import com.jfatty.zcloud.auth.service.AuthSmsLogService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统短信息发送日志记录表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-27
 */

@Api(tags = "004*****系统短信息发送日志记录API" ,value = "系统短信息发送日志记录")
@Slf4j
@RestController
@RequestMapping("/api/authSmsLog")
public class ApiAuthSmsLogController extends ApiBaseAuthController<AuthSmsLog,AuthSmsLogReq,AuthSmsLogRes> implements IAuthSmsLog {

    private AuthSmsLogService authSmsLogService ;

    @Autowired
    public void setAuthSmsLogService(AuthSmsLogService authSmsLogService) {
        super.setBaseService(authSmsLogService);
        this.authSmsLogService = authSmsLogService;
    }
}

