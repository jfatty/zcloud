package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.Role;
import com.jfatty.zcloud.system.req.RoleReq;
import com.jfatty.zcloud.system.res.RoleRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
@RequestMapping(value={"/role"})
public interface IRole extends BInterface<Role,RoleReq,RoleRes> {



}
