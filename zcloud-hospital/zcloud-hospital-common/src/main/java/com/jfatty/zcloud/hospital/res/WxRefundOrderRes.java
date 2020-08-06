package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.RefundOrderDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 微信订单退款
 *
 * @author jfatty on 2020/8/6
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "微信订单退款响应实体")
public class WxRefundOrderRes extends RefundOrderDTO<WxRefundOrderRes> {


    @ApiModelProperty(name = "refundTradeNo",  position = 1, required = true, value = "退款订单编号" , example = "RFWC20201525485965")
    private String refundTradeNo ;

}
