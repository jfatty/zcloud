package com.jfatty.zcloud.hospital.controller;


import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.Banner;
import com.jfatty.zcloud.hospital.feign.BannerFeignClient;
import com.jfatty.zcloud.hospital.req.BannerReq;
import com.jfatty.zcloud.hospital.res.BannerRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2020/4/17
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping("/banner")
public class BannerController implements IBaseController<Banner,BannerReq,BannerRes> {


    @Autowired
    private BannerFeignClient bannerFeignClient ;


    @Override
    public RELResultUtils<BannerRes> table(Map<String, Object> params) {
        return bannerFeignClient.table(params);
    }

    @Override
    public RELResultUtils<BannerRes> table(String v, Integer pageIndex, Integer pageSize) {
        return bannerFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return bannerFeignClient.list();
    }

    @Override
    public List<BannerRes> list(Long v) {
        return bannerFeignClient.list(v);
    }

    @Override
    public Object save(BannerReq entity) {
        return bannerFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return bannerFeignClient.view(id);
    }

    @Override
    public Object edit(BannerReq entity) {
        return bannerFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return bannerFeignClient.delete(params);
    }
}
