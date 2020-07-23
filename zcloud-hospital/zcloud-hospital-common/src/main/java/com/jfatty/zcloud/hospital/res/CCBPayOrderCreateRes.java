package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.PayOrderCreateDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 建行账号(龙)支付订单创建响应实体
 *
 * @author jfatty on 2020/7/22
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "建行账号(龙)支付订单创建响应实体")
public class CCBPayOrderCreateRes extends PayOrderCreateDTO<CCBPayOrderCreateRes> {

    //商户代码
    @ApiModelProperty(name = "merchantId", position = 1, value = "商户代码" ,example = "105000080621818" )
    private String merchantId ;

    //商户柜台代码
    @ApiModelProperty(name = "posId", position = 1, value = "商户柜台代码" ,example = "028473088" )
    private String posId ;

    //分行代码
    @ApiModelProperty(name = "branchId", position = 1, value = "分行代码" ,example = "430000000" )
    private String branchId ;

    //币种
    @ApiModelProperty(name = "curCode", position = 1, value = "币种" ,example = "01" )
    private String curCode = "01" ;

    //交易码 520100
    @ApiModelProperty(name = "txCode", position = 1, value = "交易码" ,example = "520100" )
    private String txCode = "520100" ;
    //备注1
    @ApiModelProperty(name = "remark1", position = 1, value = "备注1" ,example = "门诊缴费" )
    private String remark1 = "" ;
    //备注2
    @ApiModelProperty(name = "remark2", position = 1, value = "备注2" ,example = "" )
    private String remark2 = "" ;

    //公钥后30位
    @ApiModelProperty(name = "pub", position = 1, value = "公钥后30位" ,example = "08c39470a4cfb8214de37dd5020111" )
    private String pub ;

    //订单编号
    @ApiModelProperty(name = "orderId", position = 1, value = "订单编号" ,example = "CCB20201722017584114152871525" )
    private String orderId ;

    //付款金额
    @ApiModelProperty(name = "payMent", position = 1, value = "付款金额" ,example = "0.01" )
    private String payMent ;



}
