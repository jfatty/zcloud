package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 *
 * @author jfatty
 * 创建时间：2018年11月05日
 * 描述  检验报告内容
 */
@Data
public class WebReportLisDetail  extends BaseResponse {

    /**
     *
     */
    private static final long serialVersionUID = 8009906070646234976L;
    /**
     * 项目名称
     */
    private String xmmc ;
    /**
     * 项目缩写
     */
    private String xmsx ;
    /**
     * 项目结果
     */
    private String xmjg ;
    /**
     * 参考值
     */
    private String ckz ;
    /**
     * 升降标志
     */
    private String sjbz ;
    /**
     * 单位
     */
    private String dw ;

}
