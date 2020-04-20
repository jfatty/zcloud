package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.Banner;
import com.jfatty.zcloud.hospital.mapper.BannerMapper;
import com.jfatty.zcloud.hospital.service.BannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2020-04-11
 */
@Slf4j
@Service
public class BannerServiceImpl extends BaseHospitalServiceImpl<Banner, BannerMapper> implements BannerService {

    private BannerMapper bannerMapper ;

    @Autowired
    public void setBannerMapper(BannerMapper bannerMapper) {
        super.setBaseMapper(bannerMapper);
        this.bannerMapper = bannerMapper;
    }

    @Override
    public List<Banner> getDiffBanners(String appId, String version, String specification) {
        return bannerMapper.getDiffBanners(appId,version,specification) ;
    }
}
