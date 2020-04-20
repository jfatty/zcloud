package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.ReserveRecordDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "预约记录响应实体")
public class ReserveRecordRes extends ReserveRecordDTO<ReserveRecordRes> {

    /**
     * 预约号
     */
    @ApiModelProperty(name = "yyh", position = 2, value = "预约号 " , example = "2020040008")
    private String yyh ;
    /**
     * 预约日期
     */
    @ApiModelProperty(name = "yyrq", position = 2, value = "预约日期 " , example = "2020-04-16",allowableValues = "yyyy-MM-dd")
    private String yyrq ;
    /**
     * 团队标志
     */
    @ApiModelProperty(name = "tdbz", position = 2, value = "团队标志 0个人 1团队 " , example = "0")
    private String tdbz ;
    /**
     * 预约单位 团队名称
     */
    @ApiModelProperty(name = "yydw", position = 2, value = "预约单位 团队名称 " , example = "天天开心科技")
    private String yydw ;
    /**
     * 预约人数
     */
    @ApiModelProperty(name = "yydw", position = 2, value = "预约单位 团队名称 " , example = "天天开心科技")
    private Integer yyrs ;

    /**
     * 联系人
     */
    @ApiModelProperty(name = "lxr", position = 2, value = "联系人 " , example = "张三")
    private String lxr ;

    /**
     * 联系方式
     */
    @ApiModelProperty(name = "lxfs", position = 2, value = "联系方式 " , example = "15171001574")
    private String lxfs ;
    /**
     * 联系地址
     */
    @ApiModelProperty(name = "lxfs", position = 2, value = "现居住地址 单位地址 " , example = "武汉中山路")
    private String lxdz ;
    /**
     * 预约状态 0预约失败 1 预约成功 2 预约过期 3已经预约体检
     */
    @ApiModelProperty(name = "yyzt", position = 2, value = "预约状态 0预约失败 1 预约成功 2 预约过期  " , example = "1")
    private String yyzt ;
    /**
     * 处理状态 0 医院未处理 1 医院已处理
     */
    @ApiModelProperty(name = "clzt", position = 2, value = "处理状态 0 医院未处理 1 医院已处理 " , example = "0")
    private String clzt  ;
    /**
     * 备注
     */
    @ApiModelProperty(name = "beizhu", position = 2, value = "备注 " , example = "预约备注")
    private String beizhu = "";

    /**
     * 记录时间
     */
    @ApiModelProperty(name = "jlsj", position = 2, value = "预约时间 " , example = "2020-04-15 21:16:06")
    private String jlsj ;
    /**
     * 人均预算
     */
    @ApiModelProperty(name = "rjys", position = 2, value = "人均预算 " , example = "300元以内/人:::LESS300:::40288190717C96BC01717C97E4790001")
    private String rjys ;

    /**
     * 预约套餐
     */
    @ApiModelProperty(name = "yytc", position = 2, value = "预约套餐ID " , example = "10001")
    private String yytc = "" ;
    /**
     * 套餐名称
     */
    @ApiModelProperty(name = "tcmc", position = 2, value = "套餐名称 " , example = "套餐A")
    private String tcmc = "" ;
    /**
     * 身份证号
     */
    @ApiModelProperty(name = "sfzh", position = 2, value = "身份证号 " , example = "422828********4710")
    private String sfzh = "" ;

}
