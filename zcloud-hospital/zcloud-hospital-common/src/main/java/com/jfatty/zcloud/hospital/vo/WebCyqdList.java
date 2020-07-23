package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 出院清单查询
 *
 *  住院记录
 *
 * @author jfatty on 2020/7/15
 * @email jfatty@163.com
 */
@Data
public class WebCyqdList  extends BaseResponse {

    //住院编号
    private String zybh ;

    //入院日期
    private String ryrq ;

    //出院日期
    private String cyrq ;

    //住院天数
    private String zyts ;

    //出院科室ID
    private String cyks ;

    //出院科室名称
    private String cyksmc ;

    //已缴合计
    private String yjhj ;

    //费用合计
    private String fyhj ;

    //住院状态
    private String zyzt ;

}
