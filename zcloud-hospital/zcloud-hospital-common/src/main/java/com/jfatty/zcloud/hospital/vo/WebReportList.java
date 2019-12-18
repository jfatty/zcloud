package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 创建时间：2018年11月05日
 * 描述  检验报告列表 检查报告列表
 * @author jfatty on 2019/4/18
 * @email jfatty@163.com
 */
@Data
public class WebReportList extends BaseResponse {

    /**
     *
     */
    private static final long serialVersionUID = -3291689576012609358L;
    /**
     * 流水号
     */
    private String djh ;
    /**
     * 项目名称
     */
    private String xmmc ;
    /**
     * 报告时间
     */
    private String bgsj ;
    /**
     * 报告人
     */
    private String bgr ;
    /**
     * 审核人
     */
    private String shr ;

}
