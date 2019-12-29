package com.jfatty.zcloud.auth.api;


import com.jfatty.zcloud.auth.entity.AuthSmsConfig;
import com.jfatty.zcloud.auth.interfaces.IAuthSmsConfig;
import com.jfatty.zcloud.auth.req.AuthSmsConfigReq;
import com.jfatty.zcloud.auth.res.AuthSmsConfigRes;
import com.jfatty.zcloud.auth.service.AuthSmsConfigService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统短信息配置表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-27
 */
@Api(tags = "003*****系统短信息配置API" ,value = "系统短信息配置")
@Slf4j
@RestController
@RequestMapping("/api/authSmsConfig")
public class ApiAuthSmsConfigController extends ApiBaseAuthController<AuthSmsConfig,AuthSmsConfigReq,AuthSmsConfigRes> implements IAuthSmsConfig {

    private AuthSmsConfigService authSmsConfigService ;

    @Autowired
    public void setAuthSmsConfigService(AuthSmsConfigService authSmsConfigService) {
        super.setBaseService(authSmsConfigService);
        this.authSmsConfigService = authSmsConfigService;
    }
}

