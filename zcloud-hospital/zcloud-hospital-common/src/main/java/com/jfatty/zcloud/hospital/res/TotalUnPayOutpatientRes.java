package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.TotalUnPayOutpatientDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "门诊缴费响应实体")
public class TotalUnPayOutpatientRes extends TotalUnPayOutpatientDTO<TotalUnPayOutpatientRes> {

    /**
     * 费用单号
     * 费用订单列表 传入时 用逗号拼接   HIS系统中的费用单号
     */
    @ApiModelProperty(name = "fydh", position = 2,required = true, value = "费用单号 " , example = " 20125525")
    private String fydh;
    /**
     * 项目名称
     */
    @ApiModelProperty(name = "xmmc", position = 2,required = true, value = "项目名称 " , example = "诊疗费")
    private String xmmc;
    /**
     * 科室名称
     */
    @ApiModelProperty(name = "ksmc", position = 2,required = true, value = "科室名称 " , example = "内三科")
    private String ksmc;
    /**
     * 当前日期
     */
    @ApiModelProperty(name = "dqrq", position = 2,required = true, value = "当前日期 " , example = "2019-12-30 08:15:59")
    private String dqrq;
    /**
     * 姓名
     */
    @ApiModelProperty(name = "xm", position = 2,required = true, value = "姓名 " , example = "张三")
    private String xm;
    /**
     * 身份证号码
     */
    @ApiModelProperty(name = "sfzh", position = 2,required = true, value = "身份证号码 " , example = "42280125858958847")
    private String sfzh;
    /**
     * 支付金额
     */
    @ApiModelProperty(name = "zfje", position = 2,required = true, value = "支付金额 " , example = "123.21")
    private Double zfje;
    /**
     * 支付状态
     */
    @ApiModelProperty(name = "payState", position = 2,required = true, value = "支付状态 " , example = "1")
    private Integer payState;
    /**
     * his系统中的收费号
     */
    @ApiModelProperty(name = "sfh", position = 2,required = true, value = "his系统中的收费号 " , example = "125852")
    private String sfh;

    /**
     *
     * 扩展字段Ext1  有返回信息
     *
     */

    /**
     * 就诊号
     */
    @ApiModelProperty(name = "jzh", position = 2,required = true, value = "就诊号 " , example = "223669")
    private String jzh;

}
