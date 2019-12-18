package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.Navigation;
import com.jfatty.zcloud.hospital.req.NavigationReq;
import com.jfatty.zcloud.hospital.res.NavigationRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/12
 * @email jfatty@163.com
 */
@RequestMapping(value={"/navigation"})
public interface INavigation extends BInterface<Navigation,NavigationReq,NavigationRes> {

}
