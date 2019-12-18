package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.Address;
import com.jfatty.zcloud.system.req.AddressReq;
import com.jfatty.zcloud.system.res.AddressRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/13
 * @email jfatty@163.com
 */
@RequestMapping(value={"/address"})
public interface IAddress extends BInterface<Address,AddressReq,AddressRes> {



}
