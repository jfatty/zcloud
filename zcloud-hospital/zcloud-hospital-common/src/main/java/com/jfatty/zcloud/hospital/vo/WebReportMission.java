package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 报告任务
 * @author jfatty on 2019/4/18
 * @email jfatty@163.com
 */
@Data
public class WebReportMission extends BaseResponse {

    /**
     *
     */
    private static final long serialVersionUID = 7991587027824841756L;
    /**
     * 病人id
     */
    private String brid ;
    /**
     * 病人编号
     */
    private String brbh ;
    /**
     * 姓名
     */
    private String xm ;
    /**
     * 报告类型
     */
    private String bglx ;
    /**
     * 已出报告结果数量
     */
    private Integer ybgsl ;
    /**
     * 未出报告结果数量
     */
    private Integer wbgsl ;

    /**
     * 报告日期
     */
    private String bgrq ;

}
