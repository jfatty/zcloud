package com.jfatty.zcloud.alipay.service.impl;

import com.jfatty.zcloud.alipay.entity.AlipayAuthCode;
import com.jfatty.zcloud.alipay.mapper.AlipayAuthCodeMapper;
import com.jfatty.zcloud.alipay.service.AlipayAuthCodeService;
import com.jfatty.zcloud.base.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class AlipayAuthCodeServiceImpl extends BaseServiceImpl<AlipayAuthCode, AlipayAuthCodeMapper> implements AlipayAuthCodeService {


    private AlipayAuthCodeMapper alipayAuthCodeMapper ;

    @Autowired
    public void setAlipayAuthCodeMapper(AlipayAuthCodeMapper alipayAuthCodeMapper) {
        super.setBaseMapper(alipayAuthCodeMapper);
        this.alipayAuthCodeMapper = alipayAuthCodeMapper;
    }


    @Override
    public AlipayAuthCode getByAuthCode(String code, String appId) {
        return alipayAuthCodeMapper.getByAuthCode(code,appId);
    }
}
