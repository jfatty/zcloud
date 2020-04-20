package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.ModuleRelationship;
import com.jfatty.zcloud.hospital.req.ModuleRelationshipReq;
import com.jfatty.zcloud.hospital.res.ModuleRelationshipRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 系统模块与菜单对应关系
 *
 * @author jfatty on 2020/4/17
 * @email jfatty@163.com
 */
@RequestMapping(value={"/moduleRelationship"})
public interface IModuleRelationship extends BInterface<ModuleRelationship,ModuleRelationshipReq,ModuleRelationshipRes> {



}
