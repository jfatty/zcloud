package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.ExamReportTaskDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "体检报告子列表响应实体")
public class ExamReportTaskRes extends ExamReportTaskDTO<ExamReportTaskRes> {

    /**
     * 单据号
     */
    @ApiModelProperty(name = "djh", position = 1 ,required = true, value = "单据号 " , example = "2019000648")
    private String djh ;

    /**
     * 体检日期
     */
    @ApiModelProperty(name = "tjrq", position = 1 ,required = true, value = "体检日期 " , example = "2019-05-06")
    private String tjrq ;

    /**
     * 未出体检结果的体检项目数量
     * 未数量
     */
    @ApiModelProperty(name = "wsl", position = 1 , value = "未出体检结果的体检项目数量 " , example = "2")
    private Integer wsl ;

    /**
     * 已出体检结果的体检项目数量
     * 已数量
     */
    @ApiModelProperty(name = "ysl", position = 1 , value = "已出体检结果的体检项目数量 " , example = "3")
    private String ysl ;

}
