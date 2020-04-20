package com.jfatty.zcloud.hospital.vo;

import lombok.Data;


/**
 * 描述 体检报告
 *
 * @author jfatty on 2019/4/25
 * @email jfatty@163.com
 */
@Data
public class ExamReportTask extends BaseResponse {

    /**
     * 单据号
     */
    private String djh ;

    /**
     * 体检日期
     */
    private String tjrq ;

    /**
     * 未出体检结果的体检项目数量
     * 未数量
     */
    private Integer wsl ;

    /**
     * 已出体检结果的体检项目数量
     * 已数量
     */
    private String ysl ;

}
