package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.PayOrderCreateDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 建行聚合支付支付订单创建响应实体
 *
 * @author jfatty on 2020/7/22
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "建行聚合支付支付订单创建响应实体")
public class CCBQrPayOrderCreateRes extends PayOrderCreateDTO<CCBQrPayOrderCreateRes> {

    //订单编号
    @ApiModelProperty(name = "orderId", position = 1, value = "订单编号" ,example = "CCB20201722017584114152871525" )
    private String orderId ;

    @ApiModelProperty(name = "qrUrl", position = 1, value = "聚合支付qrUrl" ,example = "105000080621818" )
    private String qrUrl ;

}
