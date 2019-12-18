package com.jfatty.zcloud.hospital.res;

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
@ApiModel(description = "电子票据/我的服务单详情响应实体")
public class ElectronicDocDetailRes extends ElectronicDocDetailDTO<ElectronicDocDetailRes> {

    /**
     * 收费分类名称
     */
    @ApiModelProperty(name = "sfflmc", position = 2,required = true, value = "收费分类名称" , example = "门诊")
    private String sfflmc ;

    /**
     * 收费项目名称
     */
    @ApiModelProperty(name = "sfxmmc", position = 2,required = true, value = "收费项目名称" , example = "门诊缴费")
    private String sfxmmc ;

    /**
     * 金额
     */
    @ApiModelProperty(name = "je", position = 2,required = true, value = "金额" , example = "361.21")
    private String je ;

    /**
     * 执行科室名称
     */
    @ApiModelProperty(name = "zxksmc", position = 2,required = true, value = "执行科室名称" , example = "内一科")
    private String zxksmc ;
    /**
     * 状态
     */
    @ApiModelProperty(name = "zt", position = 2,required = true, value = "状态" , example = "未取药")
    private String zt = "";
}
