package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.Module;
import com.jfatty.zcloud.hospital.req.ModuleReq;
import com.jfatty.zcloud.hospital.res.ModuleRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2020/4/11
 * @email jfatty@163.com
 */
@RequestMapping(value={"/module"})
public interface IModule extends BInterface<Module,ModuleReq,ModuleRes> {

}
