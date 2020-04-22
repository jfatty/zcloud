package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.ComplexPayOrder;
import com.jfatty.zcloud.hospital.req.ComplexPayOrderReq;
import com.jfatty.zcloud.hospital.res.ComplexPayOrderRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 智慧医疗交易订单
 *
 * @author jfatty on 2020/4/21
 * @email jfatty@163.com
 */
@RequestMapping(value={"/complexPayOrder"})
public interface IComplexPayOrder extends BInterface<ComplexPayOrder,ComplexPayOrderReq,ComplexPayOrderRes> {


}
