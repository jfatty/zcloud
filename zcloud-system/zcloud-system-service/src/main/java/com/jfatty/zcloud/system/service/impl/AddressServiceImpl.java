package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.Address;
import com.jfatty.zcloud.system.mapper.AddressMapper;
import com.jfatty.zcloud.system.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公用地址表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Slf4j
@Service
public class AddressServiceImpl extends BaseSystemServiceImpl<Address, AddressMapper> implements AddressService {

    private AddressMapper addressMapper ;

    @Autowired
    public void setAddressMapper(AddressMapper addressMapper) {
        super.setBaseMapper(addressMapper);
        this.addressMapper = addressMapper;
    }

    @Override
    public Address getByBelongId(String belongId) {
        return addressMapper.getByBelongId(belongId);
    }
}
