package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.ExamReportDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "体检报告详情请求实体")
public class ExamReportDetailReq extends ExamReportDetailDTO<ExamReportDetailReq> {


    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "djh", position = 1,required = true, value = "体检报告单据号" , example = "2020015854" )
    private String djh ;

}
