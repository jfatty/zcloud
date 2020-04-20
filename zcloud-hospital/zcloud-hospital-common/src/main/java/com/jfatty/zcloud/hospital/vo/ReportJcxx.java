package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 体检报告基础信息
 *
 * @author jfatty on 2019/5/7
 * @email jfatty@163.com
 */
@Data
public class ReportJcxx extends BaseResponse {

    /**
     * 单据号
     */
    private String djh = "";
    /**
     * 姓名
     */
    private String xm = "";
    /**
     * 身份证号
     */
    private String sfzh = "";
    /**
     * 出生日期
     */
    private String csrq= "";
    /**
     * 性别
     */
    private String xb = "";
    /**
     * 年龄
     */
    private String nl = "";
    /**
     * 单位ID
     */
    private String dwid = "";
    /**
     * 单位名称
     */
    private String dwmc = "";
    /**
     *套餐ID
     */
    private String tcid = "";
    /**
     *套餐名称
     */
    private String tcmc = "";
    /**
     * 联系电话
     */
    private String lxdh = "";
    /**
     * 报告日期
     */
    private String bgrq = "";
    /**
     * 过敏史
     */
    private String gms= "";
    /**
     * 既往史
     */
    private String jws = "";
    /**
     * 手术史
     */
    private String sss = "";
    /**
     * 睡眠情况
     */
    private String smqk= "";
    /**
     * 地址
     */
    private String dz = "" ;

}
