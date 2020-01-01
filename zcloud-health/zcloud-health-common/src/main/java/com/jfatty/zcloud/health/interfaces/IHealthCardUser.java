package com.jfatty.zcloud.health.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.health.entity.HealthCardUser;
import com.jfatty.zcloud.health.req.HealthCardUserReq;
import com.jfatty.zcloud.health.res.HealthCardUserRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/31
 * @email jfatty@163.com
 */
@RequestMapping(value={"/healthCardUser"})
public interface IHealthCardUser extends BInterface<HealthCardUser,HealthCardUserReq,HealthCardUserRes> {



}
