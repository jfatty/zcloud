package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.IconPicture;
import com.jfatty.zcloud.hospital.mapper.IconPictureMapper;
import com.jfatty.zcloud.hospital.service.IconPictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class IconPictureServiceImpl extends BaseHospitalServiceImpl<IconPicture , IconPictureMapper> implements IconPictureService {

    private IconPictureMapper iconPictureMapper ;


    @Autowired
    public void setIconPictureMapper(IconPictureMapper iconPictureMapper) {
        super.setBaseMapper(iconPictureMapper);
        this.iconPictureMapper = iconPictureMapper;
    }
}
