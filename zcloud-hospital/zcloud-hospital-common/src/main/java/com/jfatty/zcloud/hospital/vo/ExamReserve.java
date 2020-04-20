package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/16
 * @email jfatty@163.com
 */
@Data
public class ExamReserve extends BaseResponse {

    //预约号
    private String yyh ;
    //温馨提示
    private String wxts ;

}
