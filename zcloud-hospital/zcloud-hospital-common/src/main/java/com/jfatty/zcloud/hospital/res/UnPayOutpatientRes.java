package com.jfatty.zcloud.hospital.res;

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
@ApiModel(description = "就诊人待缴费单信息响应实体")
public class UnPayOutpatientRes extends UnPayOutpatientDTO<UnPayOutpatientRes> {

    /**
     * 费用单号
     */
    @ApiModelProperty(name = "fydh", position = 2,required = true, value = "费用单号 " , example = "223669")
    private String fydh ;
    /**
     * 序号
     */
    @ApiModelProperty(name = "xh", position = 2,required = true, value = "序号 " , example = "14")
    private String xh ;
    /**
     * 科室名称
     */
    @ApiModelProperty(name = "ksmc", position = 2,required = true, value = "科室名称 " , example = "五官科")
    private String ksmc ;
    /**
     * 收费项目名称
     */
    @ApiModelProperty(name = "sfxmmc", position = 2,required = true, value = "收费项目名称 " , example = "胸透")
    private String sfxmmc ;

    /**
     * 金额
     */
    @ApiModelProperty(name = "je", position = 2,required = true, value = "金额 " , example = "13.12")
    private String je ;

}
