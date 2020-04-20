package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.WebReportLisHeadDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/17
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "检验报告表头响应实体")
public class WebReportLisHeadRes extends WebReportLisHeadDTO<WebReportLisHeadRes> {

    /**
     * 病人编号
     */
    @ApiModelProperty(name = "brbh", position = 2 ,required = true, value = "病人编号 " , example = "2012525")
    private String brbh ;
    /**
     * 姓名
     */
    @ApiModelProperty(name = "xm", position = 2 ,required = true, value = "姓名 " , example = "哈哈")
    private String xm ;
    /**
     * 性别
     */
    @ApiModelProperty(name = "xb", position = 2 ,required = true, value = "性别 " , example = "男")
    private String xb ;
    /**
     * 年龄
     */
    @ApiModelProperty(name = "dw", position = 2 ,required = true, value = "年龄 " , example = "15岁")
    private String nl ;
    /**
     * 科室名称
     */
    @ApiModelProperty(name = "ksmc", position = 2 ,required = true, value = "科室名称 " , example = "儿科")
    private String ksmc ;
    /**
     * 床位号
     */
    @ApiModelProperty(name = "cwh", position = 2 ,required = true, value = "床位号 " , example = "11")
    private String cwh ;
    /**
     * 诊断
     */
    @ApiModelProperty(name = "zd", position = 2 ,required = true, value = "诊断 " , example = "还不错")
    private String zd ;

    /**
     * 标本类型名称
     */
    @ApiModelProperty(name = "bblxmc", position = 2 ,required = true, value = "标本类型名称 " , example = "草本钢木")
    private String bblxmc ;
    /**
     * 送样时间
     */
    @ApiModelProperty(name = "sysj", position = 2 ,required = true, value = "送样时间 " ,  example = "2019-03-31")
    private String sysj ;
    /**
     *
     */
    @ApiModelProperty(name = "bz", position = 2 ,required = true, value = "备注 " , example = "备注瓶")
    private String bz ;
    /**
     *
     */
    private String sqsj ;
    /**
     * 采集时间
     */
    @ApiModelProperty(name = "cjsj", position = 2 ,required = true, value = "采集时间 " , example  = "2019-03-31")
    private String cjsj ;
    /**
     *
     */
    private String qssj ;
    /**
     *
     */
    private String sjys ;
    /**
     * 报告时间
     */
    @ApiModelProperty(name = "bgsj", position = 2 ,required = true, value = "报告时间 " , example = "2019-03-31")
    private String bgsj ;
    /**
     *
     */
    private String jys ;

    /**
     * 审核人名称
     */
    @ApiModelProperty(name = "shrmc", position = 2 ,required = true, value = "审核人名称 " , example = "张荣")
    private String shrmc ;
    /**
     * 审核人签名
     */
    @ApiModelProperty(name = "shrqm", position = 2 ,required = true, value = "审核人签名 " , example = "阿三")
    private String shrqm ;
    /**
     *
     */
    private String jybh ;
    /**
     *
     */
    private String jyrq ;
    /**
     * 样本条形码
     */
    @ApiModelProperty(name = "barcode", position = 2 ,required = true, value = "样本条形码 " , example = "663255555")
    private String barcode ;

}
