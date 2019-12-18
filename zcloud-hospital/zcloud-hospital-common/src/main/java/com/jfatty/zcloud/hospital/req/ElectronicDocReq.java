package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.ElectronicDocDTO;
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
@ApiModel(description = "电子票据/我的服务单请求实体")
public class ElectronicDocReq extends ElectronicDocDTO<ElectronicDocReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0Z3XKKxGwa7QOlte-z5iIjE")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "pageIndex", position = 2,required = true, value = "页码" ,example = "1" )
    private Integer pageIndex ;
    @ApiModelProperty(name = "pageSize", position = 3,required = true, value = "每页显示条数" ,example = "10" )
    private Integer pageSize ;
    @ApiModelProperty(name = "startTime", position = 4,required = true, value = "开始时间" ,example = "2018-01-01" ,allowableValues = "yyyy-MM-dd")
    private String startTime ;
    @ApiModelProperty(name = "endTime", position = 5,required = true, value = "结束时间" ,example = "2019-12-01",allowableValues = "yyyy-MM-dd")
    private String endTime ;

}
