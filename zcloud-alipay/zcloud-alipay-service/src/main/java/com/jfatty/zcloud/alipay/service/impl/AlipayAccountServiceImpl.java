package com.jfatty.zcloud.alipay.service.impl;

import com.jfatty.zcloud.alipay.entity.AlipayAccount;
import com.jfatty.zcloud.alipay.mapper.AlipayAccountMapper;
import com.jfatty.zcloud.alipay.service.AlipayAccountService;
import com.jfatty.zcloud.base.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号信息表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-11-08
 */
@Slf4j
@Service
public class AlipayAccountServiceImpl extends BaseServiceImpl<AlipayAccount, AlipayAccountMapper> implements AlipayAccountService {


    private AlipayAccountMapper alipayAccountMapper ;

    @Autowired
    public void setAlipayAccountMapper(AlipayAccountMapper alipayAccountMapper) {
        super.setBaseMapper(alipayAccountMapper);
        this.alipayAccountMapper = alipayAccountMapper;
    }
}
