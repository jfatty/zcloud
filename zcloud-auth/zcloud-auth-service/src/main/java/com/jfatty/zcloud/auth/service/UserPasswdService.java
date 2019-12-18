package com.jfatty.zcloud.auth.service;

import com.jfatty.zcloud.auth.entity.UserPasswd;
import com.jfatty.zcloud.base.service.BaseService;

/**
 * 描述
 *
 * @author jfatty on 2019/12/8
 * @email jfatty@163.com
 */
public interface UserPasswdService extends BaseService<UserPasswd> {


    UserPasswd getUserPasswd(String account);


}
