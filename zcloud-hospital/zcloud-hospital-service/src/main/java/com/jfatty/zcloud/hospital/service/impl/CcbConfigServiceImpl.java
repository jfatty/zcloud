package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.entity.CcbConfig;
import com.jfatty.zcloud.hospital.mapper.CcbConfigMapper;
import com.jfatty.zcloud.hospital.service.CcbConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 建行支付配置信息表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2020-07-27
 */
@Slf4j
@Service
public class CcbConfigServiceImpl extends BaseHospitalServiceImpl<CcbConfig, CcbConfigMapper> implements CcbConfigService {

    private CcbConfigMapper ccbConfigMapper ;

    @Autowired
    public void setCcbConfigMapper(CcbConfigMapper ccbConfigMapper) {
        super.setBaseMapper(ccbConfigMapper);
        this.ccbConfigMapper = ccbConfigMapper;
    }

    @Override
    public CcbConfig getByMchId(String mchId) {
        return ccbConfigMapper.getByMchId(mchId);
    }
}
