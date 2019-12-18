package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.PermRelationship;
import com.jfatty.zcloud.system.req.PermRelationshipReq;
import com.jfatty.zcloud.system.res.PermRelationshipRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/4
 * @email jfatty@163.com
 */
@RequestMapping(value={"/perm"})
public interface IPermRelationship extends BInterface<PermRelationship,PermRelationshipReq,PermRelationshipRes> {


}
