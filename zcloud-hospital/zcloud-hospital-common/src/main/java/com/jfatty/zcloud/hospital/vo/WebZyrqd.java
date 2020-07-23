package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 住院日清单
 *
 * @author jfatty on 2020/7/15
 * @email jfatty@163.com
 */
@Data
public class WebZyrqd extends BaseResponse {

    //处方号
    private String cfh ;

    //处方序号
    private String cfxh ;

    //处方日期
    private String cfrq ;

    //收费分类名称
    private String sfflmc ;

    //收费项目名称
    private String sfxmmc ;

    //单位
    private String dw ;

    //单价
    private String dj ;

    //数量
    private String sl ;

    //金额
    private String je ;

    //当前已缴合计
    private String dqyjhj ;

    //当前费用合计
    private String dqfyhj ;

}
