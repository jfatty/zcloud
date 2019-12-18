package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.QueueProgressDTO;
import com.jfatty.zcloud.hospital.req.QueueProgressReq;
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
@ApiModel(description = "用户排队响应实体")
public class QueueProgressRes extends QueueProgressDTO<QueueProgressReq> {

    /**
     * 排队类型
     */
    @ApiModelProperty(name = "pdlx", position = 2,required = true, value = "排队类型 " , example = "普通门诊")
    private String pdlx ;
    /**
     * 状态
     */
    @ApiModelProperty(name = "zt", position = 2,required = true, value = "状态 " , example = "普通门诊")
    private String zt ;
    /**
     * 类别
     */
    @ApiModelProperty(name = "lb", position = 2,required = true, value = "类别 " , example = "门诊")
    private String lb ;
    /**
     * 排队号
     */
    @ApiModelProperty(name = "pdh", position = 2,required = true, value = "排队号 " , example = "46")
    private String pdh ;
    /**
     * 姓名
     */
    @ApiModelProperty(name = "xm", position = 2,required = true, value = "姓名 " , example = "王五")
    private String xm ;
    /**
     * 身份证号
     */
    @ApiModelProperty(name = "sfzh", position = 2,required = true, value = "身份证号 " , example = "422802252228")
    private String sfzh ;
    /**
     * 科室名称
     */
    @ApiModelProperty(name = "ksmc", position = 2,required = true, value = "科室名称 " , example = "内一科")
    private String ksmc ;
    /**
     * 开始时间
     */
    @ApiModelProperty(name = "kssj", position = 2,required = true, value = "开始时间 " , example = "2018-12-12 08:19:11")
    private String kssj ;
    /**
     * 等候人数
     */
    @ApiModelProperty(name = "dhrs", position = 2,required = true, value = "等候人数 " , example = "4")
    private String dhrs ;
    /**
     * 预计等候时间
     */
    @ApiModelProperty(name = "yjdhsj", position = 2,required = true, value = "预计等候时间 " , example = " 10 分钟")
    private String yjdhsj ;
    /**
     * 备注
     */
    @ApiModelProperty(name = "bz", position = 2,required = true, value = "备注 " , example = " 再等 10 分钟")
    private String bz ;
}
