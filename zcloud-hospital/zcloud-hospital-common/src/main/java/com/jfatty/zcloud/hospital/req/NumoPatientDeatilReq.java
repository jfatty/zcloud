package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.NumoPatientInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/17
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "就诊人详情/删除就诊人请求实体")
public class NumoPatientDeatilReq extends NumoPatientInfoDTO<NumoPatientDeatilReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true,value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "brid", position = 2,required = true, value = "病人ID" , example = "237037")
    private String brid;

}
