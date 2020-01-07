package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.Address;
import com.jfatty.zcloud.system.interfaces.IAddress;
import com.jfatty.zcloud.system.req.AddressReq;
import com.jfatty.zcloud.system.res.AddressRes;
import com.jfatty.zcloud.system.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
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

    @ApiOperation(value="更新公用地址")
    @RequestMapping(value={"/updateByBelongId"},method=RequestMethod.POST)
    public ResultUtils updateByBelongId(@RequestBody Address address) {
        Address db_address = addressService.getByBelongId(address.getBelongId());
        if (db_address != null){
            addressService.updateById(address);
            return ResultUtils.success("更新成功");
        }
        try {
            addressService.saveId(address);
            return ResultUtils.success("更新成功");
        } catch (Exception e) {
            log.error("更新公用地址出现异常 更新参数[{}] 异常信息[{}]",address.toString(),e.getMessage());
        }
        return ResultUtils.faild("网络异常!请稍后重试");
    }

}

