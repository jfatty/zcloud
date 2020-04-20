package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.hospital.entity.Banner;
import com.jfatty.zcloud.hospital.interfaces.IBanner;
import com.jfatty.zcloud.hospital.req.BannerReq;
import com.jfatty.zcloud.hospital.res.BannerRes;
import com.jfatty.zcloud.hospital.service.BannerService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2020-04-11
 */
@Api(tags = "轮播图API" ,value = "轮播图")
@Slf4j
@RestController
@RequestMapping("/api/banner")
public class ApiBannerController extends ApiBaseHospitalController<Banner,BannerReq,BannerRes>  implements IBanner {


    private BannerService bannerService ;

    @Autowired
    public void setBannerService(BannerService bannerService) {
        super.setBaseService(bannerService);
        this.bannerService = bannerService;
    }
}

