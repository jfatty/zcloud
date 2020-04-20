package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.Banner;
import com.jfatty.zcloud.hospital.req.BannerReq;
import com.jfatty.zcloud.hospital.res.BannerRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2020/4/11
 * @email jfatty@163.com
 */
@RequestMapping(value={"/banner"})
public interface IBanner extends BInterface<Banner,BannerReq,BannerRes> {


}
