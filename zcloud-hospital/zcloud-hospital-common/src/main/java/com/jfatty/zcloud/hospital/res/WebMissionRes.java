package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.WebMissionDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/17
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "未缴费订单信息响应实体")
public class WebMissionRes extends WebMissionDTO<WebMissionRes> {

    /**
     * 病人ID
     */
    @ApiModelProperty(name = "brid", position = 2,required = true, value = "病人ID " , example = "141")
    private String brid ;
    /**
     * 姓名
     */
    @ApiModelProperty(name = "xm", position = 2,required = true, value = "姓名 " , example = "141")
    private String xm ;
    /**
     * 任务类型
     */
    @ApiModelProperty(name = "rwlx", position = 2,required = true, value = "任务类型 " , example = "门诊缴费")
    private String rwlx ;

    /**
     * 任务数量
     */
    @ApiModelProperty(name = "rwsl", position = 2,required = true, value = "任务数量 " , example = "2")
    private String rwsl ;

    /**
     * 流水号
     */
    @ApiModelProperty(name = "djh", position = 2,required = true, value = "流水号 " , example = "2336696")
    private String djh ;

}
