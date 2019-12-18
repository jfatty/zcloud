package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.WebPacsReportDTO;
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
@ApiModel(description = "检查报告内容请求实体")
public class WebPacsReportReq extends WebPacsReportDTO<WebPacsReportReq> {
    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "djh", position = 2,required = true, value = "HIS流水号" ,example = "20125525636" )
    private String djh ;
}
