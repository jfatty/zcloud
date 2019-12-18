package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.WebReportMissionDTO;
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
@ApiModel(description = "报告任务响应实体")
public class WebReportMissionRes  extends WebReportMissionDTO<WebReportMissionRes> {

    /**
     * 病人id
     */
    @ApiModelProperty(name = "brid", position = 2 ,required = true, value = "病人id " , example = "1582")
    private String brid ;
    /**
     * 病人编号
     */
    @ApiModelProperty(name = "brbh", position = 2 ,required = true, value = "病人编号 " , example = "201225")
    private String brbh ;
    /**
     * 姓名
     */
    @ApiModelProperty(name = "xm", position = 2 ,required = true, value = "姓名 " , example = "小红")
    private String xm ;
    /**
     * 报告类型
     */
    @ApiModelProperty(name = "bglx", position = 2 ,required = true, value = "报告类型 " , example = "检查")
    private String bglx ;
    /**
     * 已出报告结果数量
     */
    @ApiModelProperty(name = "ybgsl", position = 2 ,required = true, value = "已出报告结果数量 " , example = "1")
    private Integer ybgsl ;
    /**
     * 未出报告结果数量
     */
    @ApiModelProperty(name = "wbgsl", position = 2 ,required = true, value = "未出报告结果数量 " , example = "2")
    private Integer wbgsl ;

}
