package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.User;
import com.jfatty.zcloud.system.req.UserReq;
import com.jfatty.zcloud.system.res.UserRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@RequestMapping(value={"/user"})
public interface IUser extends BInterface<User,UserReq,UserRes> {
}
