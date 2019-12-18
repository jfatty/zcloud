package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.PreRegisteredDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "预约挂号请求实体")
public class PreRegisteredReq extends PreRegisteredDTO<PreRegisteredReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "preDate", position = 2,required = true, value = "预约日期" ,example = "2019-12-25" ,allowableValues = "yyyy-MM-dd")
    private String preDate ;
    @ApiModelProperty(name = "preTime", position = 3,required = true, value = "预约时间 每10分钟一个间隔" ,example = "08:40" ,allowableValues = "mm:ss")
    private String preTime ;
    @ApiModelProperty(name = "ksid", position = 3,required = true, value = "预约科室ID" ,example = "11542" )
    private String ksid ;
    @ApiModelProperty(name = "brid", position = 3,required = true, value = "病人ID" ,example = "1" )
    private String brid ;


}
