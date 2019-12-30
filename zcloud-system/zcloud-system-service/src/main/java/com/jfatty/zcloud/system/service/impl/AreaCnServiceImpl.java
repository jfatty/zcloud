package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.AreaCn;
import com.jfatty.zcloud.system.mapper.AreaCnMapper;
import com.jfatty.zcloud.system.service.AreaCnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 中国行政地区表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-27
 */
@Slf4j
@Service
public class AreaCnServiceImpl extends BaseSystemServiceImpl<AreaCn,AreaCnMapper> implements AreaCnService {

    private AreaCnMapper areaCnMapper ;

    @Autowired
    public void setAreaCnMapper(AreaCnMapper areaCnMapper) {
        super.setBaseMapper(areaCnMapper);
        this.areaCnMapper = areaCnMapper;
    }

    @Override
    public List<AreaCn> getLevelList(String parentId, Integer level, String name, String shortName) {
        return areaCnMapper.getLevelList(parentId,level,name,shortName,null);
    }
}
