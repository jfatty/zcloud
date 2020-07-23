package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.AppointmentRecordDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/1/4
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "预约记录响应实体")
public class AppointmentRecordRes extends AppointmentRecordDTO<AppointmentRecordRes> {


    @ApiModelProperty(name = "yyh", position = 0, value = "预约编号" , example = "202001020005")
    private String yyh ;
    @ApiModelProperty(name = "xm", position = 0, value = "就诊人" , example = "张三")
    private String xm ;

    @ApiModelProperty(name = "ksmc", position = 0, value = "科室名称" , example = "急诊内科")
    private String ksmc ;
    @ApiModelProperty(name = "kswz", position = 0, value = "科室位置" , example = "急救中心1F")
    private String kswz ;

    @ApiModelProperty(name = "yyrq", position = 0, value = "预约时间" , example = "2020-01-06 08:00")
    private String yyrq ;

    @ApiModelProperty(name = "jzh", position = 0, value = "就诊号" , example = "20200103087")
    private String jzh = "";

    @ApiModelProperty(name = "zt", position = 0, value = "预约状态 -1 已取消 2 爽约 0 未就诊 1  已就诊" , example = "1")
    private Integer zt ;
    @ApiModelProperty(name = "ztmc", position = 0, value = "状态说明" , example = "已就诊",allowableValues = "已取消,已就诊,未就诊")
    private String ztmc ;

}
