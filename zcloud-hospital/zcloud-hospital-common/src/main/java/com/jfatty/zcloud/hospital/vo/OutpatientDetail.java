package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 费用代号 查询 费用详情
 *
 * @author jfatty on 2019/4/16
 * @email jfatty@163.com
 */
@Data
public class OutpatientDetail  extends BaseResponse {

    /**
     * 序号
     */
    private String xh;
    /**
     * 收费项目名称
     */
    private String sfxmmc ;
    /**
     * 规格
     */
    private String gg ;
    /**
     * 单位
     */
    private String dw ;
    /**
     * 数量
     */
    private String sl ;
    /**
     * 金额
     */
    private String je ;

}
