package com.jfatty.zcloud.hospital.controller;


import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.BannerImg;
import com.jfatty.zcloud.hospital.feign.BannerImgFeignClient;
import com.jfatty.zcloud.hospital.req.BannerImgReq;
import com.jfatty.zcloud.hospital.res.BannerImgRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
@RequestMapping("/bannerImg")
public class BannerImgController implements IBaseController<BannerImg,BannerImgReq,BannerImgRes> {

    @Autowired
    private BannerImgFeignClient bannerImgFeignClient ;

    @Override
    public RELResultUtils<BannerImgRes> table(Map<String, Object> params) {
        return bannerImgFeignClient.table(params);
    }

    @Override
    public RELResultUtils<BannerImgRes> table(String v, Integer pageIndex, Integer pageSize) {
        return bannerImgFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return bannerImgFeignClient.list();
    }

    @Override
    public List<BannerImgRes> list(Long v) {
        return bannerImgFeignClient.list(v);
    }

    @Override
    public Object save(BannerImgReq entity) {
        return bannerImgFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return bannerImgFeignClient.view(id);
    }

    @Override
    public Object edit(BannerImgReq entity) {
        return bannerImgFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return bannerImgFeignClient.delete(params);
    }
}

