package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.CcbConfig;
import com.jfatty.zcloud.hospital.req.CcbConfigReq;
import com.jfatty.zcloud.hospital.res.CcbConfigRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2020/7/27
 * @email jfatty@163.com
 */
@RequestMapping(value={"/ccbConfig"})
public interface ICcbConfig extends BInterface<CcbConfig,CcbConfigReq,CcbConfigRes> {


}
