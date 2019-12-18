package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.OutpatientDetailDTO;
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
@ApiModel(description = "单笔门诊缴费详情响应实体")
public class OutpatientDetailRes extends OutpatientDetailDTO<OutpatientDetailRes> {
    /**
     * 序号
     */
    @ApiModelProperty(name = "xh", position = 2,required = true, value = "序号 " , example = "12")
    private String xh;
    /**
     * 收费项目名称
     */
    @ApiModelProperty(name = "sfxmmc", position = 2,required = true, value = "收费项目名称 " , example = "西药费")
    private String sfxmmc ;
    /**
     * 规格
     */
    @ApiModelProperty(name = "gg", position = 2,required = true, value = "规格 " , example = "中盒")
    private String gg ;
    /**
     * 单位
     */
    @ApiModelProperty(name = "dw", position = 2,required = true, value = "单位 " , example = "千克")
    private String dw ;
    /**
     * 数量
     */
    @ApiModelProperty(name = "sl", position = 2,required = true, value = "数量 " , example = "6")
    private String sl ;
    /**
     * 金额
     */
    @ApiModelProperty(name = "je", position = 2,required = true, value = "金额 " , example = "15.20")
    private String je ;

}
