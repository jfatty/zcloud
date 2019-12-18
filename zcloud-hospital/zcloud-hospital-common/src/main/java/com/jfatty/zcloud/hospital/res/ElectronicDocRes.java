package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.ElectronicDocDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "电子票据/我的服务单响应实体")
public class ElectronicDocRes extends ElectronicDocDTO<NavigationRes> {

    /**
     * 病人编号
     */
    @ApiModelProperty(name = "brbh", position = 2,required = true, value = "病人编号" , example = "201911240358")
    private String brbh ;
    /**
     * 姓名
     */
    @ApiModelProperty(name = "xm", position = 2,required = true, value = "姓名" , example = "张三")
    private String xm ;
    /**
     * 身份证号
     */
    @ApiModelProperty(name = "sfzh", position = 2,required = true, value = "身份证号" , example = "42282319******4731")
    private String sfzh ;
    /**
     *
     */
    @ApiModelProperty(name = "lx", position = 2,required = true, value = "缴费类型" , example = "门诊胶粉住院预缴")
    private String lx ;
    /**
     * 交易单号
     */
    @ApiModelProperty(name = "jydh", position = 2,required = true, value = "交易单号" , example = "WC2021252825828")
    private String jydh ;
    /**
     * 交易时间
     */
    @ApiModelProperty(name = "jysj", position = 2,required = true, value = "交易时间" , example = "212-02-15 09:11:15")
    private String jysj ;
    /**
     * 付款方式
     */
    @ApiModelProperty(name = "fkfs", position = 2,required = true, value = "付款方式" , example = "微信")
    private String fkfs ;
    /**
     * 金额
     */
    @ApiModelProperty(name = "je", position = 2,required = true, value = "金额" , example = "65.71")
    private String je ;
    /**
     * 2019-06-18 新增字段
     */
    @ApiModelProperty(name = "sfh", position = 2,required = true, value = "收费号" , example = "2125284")
    private String sfh ;

    /**
     * HIS返回扩展字段
     */
    @ApiModelProperty(name = "Ext1", position = 2,required = true, value = "HIS返回扩展字段Ext1" , example = "HIS返回扩展字段")
    protected String Ext1 = "" ;

    /**
     * HIS返回扩展字段
     */
    @ApiModelProperty(name = "Ext2", position = 2,required = true, value = "HIS返回扩展字段Ext2" , example = "HIS返回扩展字段")
    protected String Ext2  = "" ;


}
