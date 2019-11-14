package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.Org;
import com.jfatty.zcloud.system.mapper.OrgMapper;
import com.jfatty.zcloud.system.service.OrgService;
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
public class OrgServiceImpl extends BaseSystemServiceImpl<Org,OrgMapper> implements OrgService {

    private OrgMapper orgMapper ;

    @Autowired
    public void setOrgMapper(OrgMapper orgMapper) {
        super.setBaseMapper(orgMapper);
        this.orgMapper = orgMapper;
    }
}
