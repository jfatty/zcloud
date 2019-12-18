package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.InHospitalInfoDTO;
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
@ApiModel(description = "住院预缴前期数据查询响应实体")
public class InHospitalInfoRes  extends InHospitalInfoDTO<InHospitalInfoRes> {

    /**
     * 病人ID
     */
    @ApiModelProperty(name = "bird", position = 2,required = true, value = "病人ID" , example = "152")
    private String bird ;
    /**
     * 病人姓名
     */
    @ApiModelProperty(name = "xm", position = 2,required = true, value = "病人姓名" , example = "张三")
    private String xm ;
    /**
     * 病人身份证号码
     */
    @ApiModelProperty(name = "sfzh", position = 2,required = true, value = "病人身份证号码" , example = "42280125859658488")
    private String sfzh ;
    /**
     * 住院编号
     */
    @ApiModelProperty(name = "zybh", position = 2,required = true, value = "住院编号" , example = "20195263")
    private String zybh ;
    /**
     * 性别
     */
    @ApiModelProperty(name = "xb", position = 2,required = true, value = "性别" , example = "男")
    private String xb ;
    /**
     * 年龄
     */
    @ApiModelProperty(name = "nl", position = 2,required = true, value = "年龄" , example = "40岁")
    private String nl ;
    /**
     * 入院日期
     */
    @ApiModelProperty(name = "ryrq", position = 2,required = true, value = "入院日期" , example = "2012-11-12 06:15:30")
    private String ryrq ;
    /**
     * 住院天数
     */
    @ApiModelProperty(name = "zyts", position = 2,required = true, value = "住院天数" , example = "15天")
    private String zyts ;
    /**
     * 病人类型
     */
    @ApiModelProperty(name = "brlx", position = 2,required = true, value = "病人类型" , example = "住院")
    private String brlx ;
    /**
     * 病区
     */
    @ApiModelProperty(name = "bq", position = 2,required = true, value = "病区" , example = "主区")
    private String bq ;
    /**
     * 科室名称
     */
    @ApiModelProperty(name = "科室名称", position = 2,required = true, value = "科室名称" , example = "内一科")
    private String ksmc ;
    /**
     * 床位号
     */
    @ApiModelProperty(name = "cwh", position = 2,required = true, value = "床位号" , example = "15床")
    private String cwh ;
    /**
     * 管床医生
     */
    @ApiModelProperty(name = "gcys", position = 2,required = true, value = "管床医生" , example = "张三")
    private String gcys ;
    /**
     * 管床护士
     */
    @ApiModelProperty(name = "gchs", position = 2,required = true, value = "管床护士" , example = "")
    private String gchs ;
    /**
     * 当前费用合计
     */
    @ApiModelProperty(name = "dqfyhj", position = 2,required = true, value = "当前费用合计" , example = "1252.12")
    private String dqfyhj;
    /**
     * 当前预缴合计
     */
    @ApiModelProperty(name = "dqyjhj", position = 2,required = true, value = "当前预缴合计" , example = "7412.00")
    private String dqyjhj ;
    /**
     * 担保金额
     */
    @ApiModelProperty(name = "dbje", position = 2,required = true, value = "担保金额" , example = "500.00")
    private String dbje ;
    /**
     * 余额
     */
    @ApiModelProperty(name = "ye", position = 2,required = true, value = "余额" , example = "200.00")
    private String ye ;

    /**
     * 中转存储流水号
     */
    @ApiModelProperty(name = "djh", position = 2,required = true, value = "中转存储流水号" , example = "中转存储流水号")
    private String djh ;
    /**
     *
     * 扩展字段Ext1  有返回信息
     *
     */

    /**
     * 就诊号
     */
    @ApiModelProperty(name = "jzh", position = 2,required = true, value = "就诊号" , example = "2022658")
    private String jzh ;

}
