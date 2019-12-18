package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.Privilege;
import com.jfatty.zcloud.system.req.PrivilegeReq;
import com.jfatty.zcloud.system.res.PrivilegeRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@RequestMapping(value={"/privilege"})
public interface IPrivilege extends BInterface<Privilege,PrivilegeReq,PrivilegeRes> {

}
