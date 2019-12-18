package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.ElectronicDocDetailDTO;
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
@ApiModel(description = "电子票据/我的服务单详情请求实体")
public class ElectronicDocDetailReq extends ElectronicDocDetailDTO<ElectronicDocDetailReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0Z3XKKxGwa7QOlte-z5iIjE")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "brbh", position = 2,required = true, value = "病人编号" , example = "201812140250")
    private String brbh ;
    @ApiModelProperty(name = "sfh", position = 3,required = true, value = "收费号" , example = "1733392")
    private String sfh ;

}
