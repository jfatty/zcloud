package com.jfatty.zcloud.auth.interfaces;

import com.jfatty.zcloud.auth.entity.AuthSmsLog;
import com.jfatty.zcloud.auth.req.AuthSmsLogReq;
import com.jfatty.zcloud.auth.res.AuthSmsLogRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/27
 * @email jfatty@163.com
 */
@RequestMapping(value={"/authSmsLog"})
public interface IAuthSmsLog extends BInterface<AuthSmsLog,AuthSmsLogReq,AuthSmsLogRes> {

}
