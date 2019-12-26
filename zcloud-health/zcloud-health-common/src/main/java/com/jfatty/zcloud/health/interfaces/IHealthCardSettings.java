package com.jfatty.zcloud.health.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.req.HealthCardSettingsReq;
import com.jfatty.zcloud.health.res.HealthCardSettingsRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@RequestMapping(value={"/healthCardSettings"})
public interface IHealthCardSettings extends BInterface<HealthCardSettings,HealthCardSettingsReq,HealthCardSettingsRes> {


}
