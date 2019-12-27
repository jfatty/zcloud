package com.jfatty.zcloud.health.service.impl;

import com.jfatty.zcloud.health.entity.HCSHealthCardInfo;
import com.jfatty.zcloud.health.mapper.HCSHealthCardInfoMapper;
import com.jfatty.zcloud.health.service.HCSHealthCardInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-26
 */
@Slf4j
@Service
public class HCSHealthCardInfoServiceImpl extends BaseHealthServiceImpl<HCSHealthCardInfo, HCSHealthCardInfoMapper> implements HCSHealthCardInfoService {

    private HCSHealthCardInfoMapper hcsHealthCardInfoMapper ;

    @Autowired
    public void setHcsHealthCardInfoMapper(HCSHealthCardInfoMapper hcsHealthCardInfoMapper) {
        super.setBaseMapper(hcsHealthCardInfoMapper);
        this.hcsHealthCardInfoMapper = hcsHealthCardInfoMapper;
    }

    @Override
    public HCSHealthCardInfo getByIdCardNumber(String idNumber) {
        return hcsHealthCardInfoMapper.getByIdCardNumber(idNumber);
    }
}
