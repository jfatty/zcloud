package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.PayOrderCreateDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 建行支付支付订单创建请求实体
 *
 * @author jfatty on 2020/7/22
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "建行支付订单创建请求实体")
public class CCBPayOrderCreateReq extends PayOrderCreateDTO<CCBPayOrderCreateReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;

    @ApiModelProperty(name = "appId", position = 2,required = true, value = "微信  支付宝  APP appId" , example = "wx0725202a2fe5ffcf" )
    private String appId ;

    @ApiModelProperty(name = "jzh", position = 0,required = true, value = "就诊号" ,example = "20190909")
    private String jzh ;

    @ApiModelProperty(name = "brid", position = 0,required = true, value = "病人ID" ,example = "125")
    private String brid ;

    @ApiModelProperty(name = "hisNo", position = 0,required = true, value = "his系统中的单号(流水号)" ,example = "223615558")
    private String hisNo ;

    @ApiModelProperty(name = "feeType", position = 0,required = true, value = "费用类型 1 挂号缴费、2 门诊缴费、 3 住院预缴" ,example = "2")
    private Integer feeType;
    @ApiModelProperty(name = "feeAmount", position = 0, value = "费用金额 当且仅当 feeType === 3 时需要传递此参数" ,example = "500.12")
    private String feeAmount;
    @ApiModelProperty(name = "mchId", position = 0,required = true, value = "建行给商户分配的ID" ,example = "105000080621818")
    private String mchId ;

}
