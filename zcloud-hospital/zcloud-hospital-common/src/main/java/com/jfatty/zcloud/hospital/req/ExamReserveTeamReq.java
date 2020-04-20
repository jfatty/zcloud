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
@ApiModel(description = "团队预约请求实体")
public class ExamReserveTeamReq extends ExamReserveDTO<ExamReserveTeamReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    //单位名称
    @ApiModelProperty(name = "yydw", position = 1,required = true, value = "单位名称" , example = "千千科技" )
    private String yydw  ;
    //单位地址
    @ApiModelProperty(name = "lxdz", position = 1,required = true, value = "单位地址" , example = "当代光谷梦工厂" )
    private String lxdz  ;
    //预约人数
    @ApiModelProperty(name = "yyrs", position = 1,required = true, value = "预约人数" , example = "5" )
    private Integer yyrs = 1 ;
    //预约日期
    @ApiModelProperty(name = "yyrq", position = 1,required = true, value = "预约日期" , example = "2020-05-05",allowableValues = "yyyy-MM-dd")
    private String yyrq ;
    //备注
    @ApiModelProperty(name = "beizhu", position = 1,required = true, value = "备注" , example = "有糖尿病史检查前需要注意哪些问题" )
    private String beizhu = "";
    //联系人
    @ApiModelProperty(name = "lxr", position = 1,required = true, value = "联系人" , example = "张三" )
    private String lxr ;
    //联系方式
    @ApiModelProperty(name = "lxfs", position = 1,required = true, value = "联系方式" , example = "13177211452" )
    private String lxfs ;

    @ApiModelProperty(name = "rjys", position = 1,required = true, value = "人均预算 dicValue:::dicCode:::id" , example = "300元以内/人:::LESS300:::40288190717C96BC01717C97E4790001" )
    private String rjys ;

}
