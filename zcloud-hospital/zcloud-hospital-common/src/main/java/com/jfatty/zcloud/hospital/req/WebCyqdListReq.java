package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.WebCyqdListDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 出院清单查询 住院记录
 *
 * @author jfatty on 2020/7/15
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "住院记录请求实体")
public class WebCyqdListReq extends WebCyqdListDTO<WebCyqdListReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0Z3XKKxGwa7QOlte-z5iIjE")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "brid", position = 4,required = true, value = "病人ID" ,example = "489513" )
    private String brid ;

}
