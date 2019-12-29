package com.jfatty.zcloud.auth.interfaces;

import com.jfatty.zcloud.auth.entity.AuthSmsConfig;
import com.jfatty.zcloud.auth.req.AuthSmsConfigReq;
import com.jfatty.zcloud.auth.res.AuthSmsConfigRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/27
 * @email jfatty@163.com
 */
@RequestMapping(value={"/authSmsConfig"})
public interface IAuthSmsConfig extends BInterface<AuthSmsConfig,AuthSmsConfigReq,AuthSmsConfigRes> {

}
