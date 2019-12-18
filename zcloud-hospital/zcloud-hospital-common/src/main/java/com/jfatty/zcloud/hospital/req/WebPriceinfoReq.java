package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.WebPriceinfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "物价查询请求实体")
public class WebPriceinfoReq extends WebPriceinfoDTO<WebPriceinfoReq> {


    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "pageIndex", position = 2,required = true, value = "页码" ,example = "1" )
    private Integer pageIndex ;
    @ApiModelProperty(name = "pageSize", position = 3,required = true, value = "每页显示条数" ,example = "10" )
    private Integer pageSize ;
    @ApiModelProperty(name = "cxlb", position = 4,required = true, value = "查询类别",allowableValues = "1,2" ,example = "1")
    private Integer cxlb ;
    @ApiModelProperty(name = "xmmc", position = 5,required = true, value = "查询项目名称" , example = "葡萄糖")
    private String xmmc ;

}
