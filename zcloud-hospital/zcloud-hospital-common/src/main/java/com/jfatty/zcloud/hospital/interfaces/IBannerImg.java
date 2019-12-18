package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.BannerImg;
import com.jfatty.zcloud.hospital.req.BannerImgReq;
import com.jfatty.zcloud.hospital.res.BannerImgRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/12
 * @email jfatty@163.com
 */
@RequestMapping(value={"/bannerImg"})
public interface IBannerImg extends BInterface<BannerImg,BannerImgReq,BannerImgRes> {
}
