package com.jfatty.zcloud.alipay.service.impl;

import com.jfatty.zcloud.alipay.entity.AlipayNewstemplate;
import com.jfatty.zcloud.alipay.mapper.AlipayNewstemplateMapper;
import com.jfatty.zcloud.alipay.service.AlipayNewstemplateService;
import com.jfatty.zcloud.base.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 图文素材模板 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-11-08
 */
@Slf4j
@Service
public class AlipayNewstemplateServiceImpl extends BaseServiceImpl<AlipayNewstemplate, AlipayNewstemplateMapper> implements AlipayNewstemplateService {

    private AlipayNewstemplateMapper alipayNewstemplateMapper ;

    @Autowired
    public void setAlipayNewstemplateMapper(AlipayNewstemplateMapper alipayNewstemplateMapper) {
        super.setBaseMapper(alipayNewstemplateMapper);
        this.alipayNewstemplateMapper = alipayNewstemplateMapper;
    }
}
