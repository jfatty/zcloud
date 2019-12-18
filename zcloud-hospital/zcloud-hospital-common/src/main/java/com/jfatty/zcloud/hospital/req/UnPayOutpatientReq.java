package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.UnPayOutpatientDTO;
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
@ApiModel(description = "就诊人待缴费单信息请求实体")
public class UnPayOutpatientReq extends UnPayOutpatientDTO<UnPayOutpatientReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "pageIndex", position = 2,required = true, value = "页码" ,example = "1" )
    private Integer pageIndex ;
    @ApiModelProperty(name = "pageSize", position = 3,required = true, value = "每页显示条数" ,example = "10" )
    private Integer pageSize ;
    @ApiModelProperty(name = "brid", position = 2,required = true, value = "HIS病人编号" ,example = "237037")
    private String brid ;
    @ApiModelProperty(name = "djh", position = 3,required = true, value = "流水号" ,example = "201912180001")
    private String djh ;



}
