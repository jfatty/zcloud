package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.Module;
import com.jfatty.zcloud.hospital.mapper.ModuleMapper;
import com.jfatty.zcloud.hospital.service.ModuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class ModuleServiceImpl extends BaseHospitalServiceImpl<Module, ModuleMapper> implements ModuleService {


    private ModuleMapper moduleMapper ;

    @Autowired
    public void setModuleMapper(ModuleMapper moduleMapper) {
        super.setBaseMapper(moduleMapper);
        this.moduleMapper = moduleMapper;
    }

    @Override
    public List<Module> getModulesById(String appId, String version, String moduleId, String specification) {
        return moduleMapper.getModulesById(appId,version,moduleId,specification);
    }
}
