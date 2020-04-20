package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.ExamReportDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/4/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "体检报告列表响应实体")
public class ExamReportRes extends ExamReportDTO<ExamReportRes> {


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
     * 移动电话
     */
    @ApiModelProperty(name = "yddh", position = 2 ,required = true, value = "移动电话 " , example = "1318266581")
    private String yddh ;

    @ApiModelProperty(name = "bgsl", position = 2 ,required = true, value = "报告数量 " , example = "1")
    private Integer bgsl = 0 ;

    //报告数量
    private List<ExamReportTaskRes> tasks ;

}
