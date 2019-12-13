package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.hospital.entity.BannerImg;
import com.jfatty.zcloud.hospital.interfaces.IBannerImg;
import com.jfatty.zcloud.hospital.service.BannerImgService;
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
 * @since 2019-12-12
 */
@Slf4j
@RestController
@RequestMapping("/api/bannerImg")
public class ApiBannerImgController extends ApiBaseHospitalController<BannerImg>  implements IBannerImg {

    private BannerImgService bannerImgService;

    @Autowired
    public void setBannerImgService(BannerImgService bannerImgService) {
        super.setBaseService(bannerImgService);
        this.bannerImgService = bannerImgService;
    }
}

