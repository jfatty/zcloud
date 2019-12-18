package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.system.entity.Address;
import com.jfatty.zcloud.system.interfaces.IAddress;
import com.jfatty.zcloud.system.req.AddressReq;
import com.jfatty.zcloud.system.res.AddressRes;
import com.jfatty.zcloud.system.service.AddressService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 公用地址表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Api(tags = "公用地址API" ,value = "公用地址")
@Slf4j
@RestController
@RequestMapping(value={"/api/address"})
public class ApiAddressController  extends ApiBaseSystemController<Address,AddressReq,AddressRes>  implements IAddress {

    private AddressService addressService ;

    @Autowired
    public void setAddressService(AddressService addressService) {
        super.setBaseService(addressService);
        this.addressService = addressService;
    }

}

