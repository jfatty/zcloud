package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.WebReportListContentDTO;
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
@ApiModel(description = "检验报告内容包括头部信息以及详-请求实体")
public class WebReportListContentReq extends WebReportListContentDTO<WebReportListContentReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "sn", position = 2,required = true, value = "报告序列号" ,example = "1021911" )
    private String sn ;

}
