package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.WebRegPatientDTO;
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
@ApiModel(description = "互联网病人信息响应实体")
public class WebRegPatientRes extends WebRegPatientDTO<WebRegPatientRes> {

    /**
     * 姓名
     */
    @ApiModelProperty(name = "xm", position = 2 ,required = true, value = "姓名 " , example = "小三")
    private String xm ;
    /**
     * 性别
     */
    @ApiModelProperty(name = "xb", position = 2 ,required = true, value = "性别 " , example = "男")
    private String xb;
    /**
     * 身份证号
     */
    @ApiModelProperty(name = "sfzh", position = 2 ,required = true, value = "身份证号 " , example = "42280119892255455")
    private String sfzh ;
    /**
     * 磁卡号
     */
    @ApiModelProperty(name = "ckh", position = 2 ,required = true, value = "磁卡号 " , example = "202365689")
    private String ckh ;

    /**
     * 移动电话
     */
    @ApiModelProperty(name = "yddh", position = 2 ,required = true, value = "移动电话 " , example = "1318266581")
    private String yddh ;

    /**
     * 地址
     */
    @ApiModelProperty(name = "dz", position = 2 ,required = true, value = "地址 " , example = "湖北武汉")
    private String dz = "" ;

    /**
     * 病人ID
     */
    @ApiModelProperty(name = "brid", position = 2 ,required = true, value = "病人ID " , example = "125")
    private String brid ;

    @ApiModelProperty(name = "defaultPat", position = 12,required = true, value = "是否为默认就诊人 1表示是默认 0表示否" , example = "0",allowableValues = "1,0")
    private Integer defaultPat;



}
