package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述  描述 排队信息查询
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class QueueProgress  extends BaseResponse {

    /**
     * 排队类型
     */
    private String pdlx ;
    /**
     *
     */
    private String zt ;
    /**
     * 类别
     */
    private String lb ;
    /**
     * 排队号
     */
    private String pdh ;
    /**
     * 姓名
     */
    private String xm ;
    /**
     * 身份证号
     */
    private String sfzh ;
    /**
     * 科室名称
     */
    private String ksmc ;
    /**
     * 开始时间
     */
    private String kssj ;
    /**
     * 等候人数
     */
    private String dhrs ;
    /**
     * 预计等候时间
     */
    private String yjdhsj ;
    /**
     * 备注
     */
    private String bz ;

}
