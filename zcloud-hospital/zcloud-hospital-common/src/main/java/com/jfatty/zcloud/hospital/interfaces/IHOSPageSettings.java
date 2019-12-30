package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.HOSPageSettings;
import com.jfatty.zcloud.hospital.req.HOSPageSettingsReq;
import com.jfatty.zcloud.hospital.res.HOSPageSettingsRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/30
 * @email jfatty@163.com
 */
@RequestMapping(value={"/pageSettings"})
public interface IHOSPageSettings extends BInterface<HOSPageSettings,HOSPageSettingsReq,HOSPageSettingsRes> {


}
