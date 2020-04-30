package com.jfatty.zcloud.alipay.service.impl;

import com.jfatty.zcloud.alipay.entity.AlipayAutoresponseDefault;
import com.jfatty.zcloud.alipay.mapper.AlipayAutoresponseDefaultMapper;
import com.jfatty.zcloud.alipay.service.AlipayAutoresponseDefaultService;
import com.jfatty.zcloud.base.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 默认关键字回复 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-11-08
 */
@Slf4j
@Service
public class AlipayAutoresponseDefaultServiceImpl extends BaseServiceImpl<AlipayAutoresponseDefault, AlipayAutoresponseDefaultMapper> implements AlipayAutoresponseDefaultService {

    private AlipayAutoresponseDefaultMapper alipayAutoresponseDefaultMapper ;

    @Autowired
    public void setAlipayAutoresponseDefaultMapper(AlipayAutoresponseDefaultMapper alipayAutoresponseDefaultMapper) {
        super.setBaseMapper(alipayAutoresponseDefaultMapper);
        this.alipayAutoresponseDefaultMapper = alipayAutoresponseDefaultMapper;
    }
}
