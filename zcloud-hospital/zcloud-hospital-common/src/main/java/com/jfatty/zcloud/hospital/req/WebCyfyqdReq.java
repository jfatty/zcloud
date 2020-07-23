package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.WebCyfyqdDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 出院清单查询
 *
 * @author jfatty on 2020/7/15
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "出院清单查询请求实体")
public class WebCyfyqdReq extends WebCyfyqdDTO<WebCyfyqdReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0Z3XKKxGwa7QOlte-z5iIjE")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "zybh", position = 4,required = true, value = "住院编号" ,example = "202009376" )
    private String zybh ;


}
