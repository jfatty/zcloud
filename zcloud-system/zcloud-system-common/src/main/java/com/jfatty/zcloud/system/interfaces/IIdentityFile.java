package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.IdentityFile;
import com.jfatty.zcloud.system.req.IdentityFileReq;
import com.jfatty.zcloud.system.res.IdentityFileRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/13
 * @email jfatty@163.com
 */
@RequestMapping(value={"/identityFile"})
public interface IIdentityFile extends BInterface<IdentityFile,IdentityFileReq,IdentityFileRes> {
}
