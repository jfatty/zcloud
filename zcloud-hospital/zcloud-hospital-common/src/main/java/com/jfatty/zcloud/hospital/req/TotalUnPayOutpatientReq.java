package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.TotalUnPayOutpatientDTO;
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
@ApiModel(description = "门诊缴费请求实体")
public class TotalUnPayOutpatientReq extends TotalUnPayOutpatientDTO<TotalUnPayOutpatientReq> {
    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "djh", position = 2,required = true, value = "系统流水号" ,example = "201912180001")
    private String djh ;
    @ApiModelProperty(name = "brid", position = 3,required = true, value = "HIS病人ID" ,example = "237037")
    private String brid ;
}
