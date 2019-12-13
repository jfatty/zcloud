package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.BannerImg;
import com.jfatty.zcloud.hospital.mapper.BannerImgMapper;
import com.jfatty.zcloud.hospital.service.BannerImgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Slf4j
@Service
public class BannerImgServiceImpl extends BaseHospitalServiceImpl<BannerImg, BannerImgMapper> implements BannerImgService {


    private BannerImgMapper bannerImgMapper ;

    @Autowired
    public void setBannerImgMapper(BannerImgMapper bannerImgMapper) {
        super.setBaseMapper(bannerImgMapper);
        this.bannerImgMapper = bannerImgMapper;
    }
}
