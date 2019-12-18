package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 获取未缴费订单信息
 * @author jfatty on 2019/4/14
 * @email jfatty@163.com
 */
@Data
public class WebMission extends BaseResponse {

    /**
     * 病人ID
     */
    private String brid ;
    /**
     * 姓名
     */
    private String xm ;
    /**
     * 任务类型
     */
    private String rwlx ;

    /**
     * 任务数量
     */
    private String rwsl ;

    /**
     * 流水号
     */
    private String djh ;

}

