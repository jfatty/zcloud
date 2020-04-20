package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/9/30
 * @email jfatty@163.com
 */
@Data
public class EreportResponse extends BaseResponse {

    private String zhid = "" ;

    private String zhmc  = "" ;

    /**
     * 项目名称
     */
    private String xmmc  = "" ;
    /**
     * 项目结果
     */
    private String xmjg  = "" ;
    /**
     * 项目单位
     */
    private String xmdw  = "" ;
    /**
     * 参考值
     */
    private String ckz  = "" ;
    /**
     * 体检医生ID
     */
    private String tjysid = "" ;
    /**
     * 体检医生名称
     */
    private String tjysmc = "" ;
    /**
     * 体检医生签名
     */
    private byte[] tjysqm ;
    /**
     * 体检时间
     */
    private String tjsj = "" ;

    /**
     * 图像数量
     */
    private Integer txsl = 0 ;

    /**
     * 结果说明
     */
    private String jgsm = "" ;

    /**
     * 序号
     */
    private Integer xh ;
    /**
     * 图像
     */
    private byte[] tx ;

    private Integer etype  ;
}
