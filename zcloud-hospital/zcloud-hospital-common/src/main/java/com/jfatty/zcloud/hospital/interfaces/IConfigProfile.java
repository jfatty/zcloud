package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.ConfigProfile;
import com.jfatty.zcloud.hospital.req.ConfigProfileReq;
import com.jfatty.zcloud.hospital.res.ConfigProfileRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述  智慧医疗系统配置配置
 *
 * @author jfatty on 2020/5/21
 * @email jfatty@163.com
 */
@RequestMapping(value={"/configProfile"})
public interface IConfigProfile extends BInterface<ConfigProfile,ConfigProfileReq,ConfigProfileRes> {





}
