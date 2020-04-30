package com.jfatty.zcloud.alipay.service.impl;

import com.jfatty.zcloud.alipay.entity.AlipayTexttemplate;
import com.jfatty.zcloud.alipay.mapper.AlipayTexttemplateMapper;
import com.jfatty.zcloud.alipay.service.AlipayTexttemplateService;
import com.jfatty.zcloud.base.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文本模板 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-11-08
 */
@Slf4j
@Service
public class AlipayTexttemplateServiceImpl extends BaseServiceImpl<AlipayTexttemplate, AlipayTexttemplateMapper> implements AlipayTexttemplateService {

    private AlipayTexttemplateMapper alipayTexttemplateMapper ;


    @Autowired
    public void setAlipayTexttemplateMapper(AlipayTexttemplateMapper alipayTexttemplateMapper) {
        super.setBaseMapper(alipayTexttemplateMapper);
        this.alipayTexttemplateMapper = alipayTexttemplateMapper;
    }
}
