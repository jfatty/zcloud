package com.jfatty.zcloud.hospital.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.IconPicture;
import com.jfatty.zcloud.hospital.feign.IconPictureFeignClient;
import com.jfatty.zcloud.hospital.req.IconPictureReq;
import com.jfatty.zcloud.hospital.res.IconPictureRes;
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
@RequestMapping("/iconPicture")
public class IconPictureController implements IBaseController<IconPicture,IconPictureReq,IconPictureRes> {

    @Autowired
    private IconPictureFeignClient iconPictureFeignClient;

    @Override
    public RELResultUtils<IconPictureRes> table(Map<String, Object> params) {
        return iconPictureFeignClient.table(params);
    }

    @Override
    public RELResultUtils<IconPictureRes> table(String v, Integer pageIndex, Integer pageSize) {
        return iconPictureFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return iconPictureFeignClient.list();
    }

    @Override
    public List<IconPictureRes> list(Long v) {
        return iconPictureFeignClient.list(v);
    }

    @Override
    public Object save(IconPictureReq entity) {
        return iconPictureFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return iconPictureFeignClient.view(id);
    }

    @Override
    public Object edit(IconPictureReq entity) {
        return iconPictureFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return iconPictureFeignClient.delete(params);
    }

}
