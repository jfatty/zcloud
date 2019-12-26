package com.jfatty.zcloud.health.service.impl;

import com.jfatty.zcloud.health.entity.HCSIDCardInfo;
import com.jfatty.zcloud.health.mapper.HCSIDCardInfoMapper;
import com.jfatty.zcloud.health.service.HCSIDCardInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 身份证信息表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-26
 */
@Slf4j
@Service
public class HCSIDCardInfoServiceImpl extends BaseHealthServiceImpl<HCSIDCardInfo, HCSIDCardInfoMapper> implements HCSIDCardInfoService {


    private  HCSIDCardInfoMapper hcsidCardInfoMapper ;

    @Autowired
    public void setHcsidCardInfoMapper(HCSIDCardInfoMapper hcsidCardInfoMapper) {
        super.setBaseMapper(hcsidCardInfoMapper);
        this.hcsidCardInfoMapper = hcsidCardInfoMapper;
    }
}
