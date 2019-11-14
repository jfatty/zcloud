package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.Office;
import com.jfatty.zcloud.system.mapper.OfficeMapper;
import com.jfatty.zcloud.system.service.OfficeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class OfficeServiceImpl extends BaseSystemServiceImpl<Office,OfficeMapper> implements OfficeService {

    private OfficeMapper officeMapper ;

    @Autowired
    public void setOfficeMapper(OfficeMapper officeMapper) {
        super.setBaseMapper(officeMapper);
        this.officeMapper = officeMapper;
    }
}
