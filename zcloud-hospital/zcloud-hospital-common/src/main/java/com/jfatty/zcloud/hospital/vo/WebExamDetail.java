package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 体检中心套餐明细
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */
@Data
public class WebExamDetail  extends BaseResponse {


    /**
     * 显示顺序
     */
    private String xssx = "" ;

    /**
     * 名称
     */
    private String zhmc = "" ;

    /**
     * 内容
     */
    private String zhnr = "" ;
}
