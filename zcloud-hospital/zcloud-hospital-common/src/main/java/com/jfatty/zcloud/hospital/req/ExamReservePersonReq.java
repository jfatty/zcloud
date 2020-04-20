package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.ExamReserveDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "个人预约请求实体")
public class ExamReservePersonReq extends ExamReserveDTO<ExamReservePersonReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "tcid", position = 1,required = true, value = "套餐ID" , example = "1001" )
    private String tcid ;
    @ApiModelProperty(name = "tcmc", position = 1,required = true, value = "套餐名称" , example = "体检套餐男A" )
    private String tcmc ;
    //预约日期
    @ApiModelProperty(name = "yyrq", position = 1,required = true, value = "预约日期" , example = "2020-05-05",allowableValues = "yyyy-MM-dd")
    private String yyrq ;
    //备注
    @ApiModelProperty(name = "beizhu", position = 1,required = true, value = "备注" , example = "有糖尿病史检查前需要注意哪些问题" )
    private String beizhu = "";
    //现居住地址
    @ApiModelProperty(name = "lxdz", position = 1,required = true, value = "现居住地址" , example = "湖北咸宁" )
    private String lxdz ;
    //病人ID
    @ApiModelProperty(name = "brid", position = 1,required = true, value = "就诊人ID" , example = "1243" )
    private String  brid ;
}
