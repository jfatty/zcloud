package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.RefundOrderDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 订单退款
 *
 * @author jfatty on 2020/8/6
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "微信订单退款请求实体")
public class WxRefundOrderReq extends RefundOrderDTO<WxRefundOrderReq> {

    @ApiModelProperty(name = "appId",  position = 1, required = true, value = "应用ID APPID" , example = "wxe3336a60d2685379")
    private String appId ;
    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "outTradeNo",  position = 1, required = true, value = "交易订单号" , example = "WC201906181027560003")
    private String outTradeNo ;
    @ApiModelProperty(name = "passwd",  position = 1, required = true, value = "支付密码" , example = "111111")
    private String passwd ;
    @ApiModelProperty(name = "refundDesc",  position = 1, required = true, value = "退款描述" , example = "测试订单退款")
    private String refundDesc ;


}
