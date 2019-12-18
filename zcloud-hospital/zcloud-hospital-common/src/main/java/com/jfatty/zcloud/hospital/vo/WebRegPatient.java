package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述  绑定就诊人时到HIS数据库中进行身份验证 获取已经绑定病人信息列表
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class WebRegPatient extends BaseResponse {

    /**
     * 性别
     */
    private String xm ;
    /**
     * 性别
     */
    private String xb;
    /**
     * 身份证号
     */
    private String sfzh ;
    /**
     * 磁卡号
     */
    private String ckh ;

    /**
     * 移动电话
     */
    private String yddh ;

    /**
     * 地址
     */
    private String dz = "" ;

    /**
     * 病人ID
     */
    private String brid ;
    /**
     * 建档时间
     */
    private String jdsj ;
    /**
     * 注销时间
     */
    private String zxsj ;

}
