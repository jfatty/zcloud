package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.TreatGuide;
import com.jfatty.zcloud.hospital.mapper.TreatGuideMapper;
import com.jfatty.zcloud.hospital.service.TreatGuideService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 就诊指南 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2020-04-28
 */
@Slf4j
@Service
public class TreatGuideServiceImpl extends BaseHospitalServiceImpl<TreatGuide, TreatGuideMapper> implements TreatGuideService {


    private TreatGuideMapper treatGuideMapper ;

    @Autowired
    public void setTreatGuideMapper(TreatGuideMapper treatGuideMapper) {
        super.setBaseMapper(treatGuideMapper);
        this.treatGuideMapper = treatGuideMapper;
    }

    @Override
    public List<TreatGuide> getTreatGuides(String appId, String version, String specification) {
        return treatGuideMapper.getTreatGuides(appId,version,specification);
    }
}
