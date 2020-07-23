package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.AssObject;
import com.jfatty.zcloud.hospital.mapper.AssObjectMapper;
import com.jfatty.zcloud.hospital.service.AssObjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 量表关联对象表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2020-06-03
 */
@Slf4j
@Service
public class AssObjectServiceImpl extends BaseHospitalServiceImpl<AssObject, AssObjectMapper> implements AssObjectService {


    private AssObjectMapper assObjectMapper ;

    @Autowired
    public void setAssObjectMapper(AssObjectMapper assObjectMapper) {
        super.setBaseMapper(assObjectMapper);
        this.assObjectMapper = assObjectMapper;
    }

    @Override
    public List<AssObject> getAssObjects(String surveyId) {
        return assObjectMapper.getAssObjects(surveyId);
    }
}
