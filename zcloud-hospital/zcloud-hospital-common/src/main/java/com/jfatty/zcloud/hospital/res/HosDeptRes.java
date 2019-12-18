package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.HosDeptDTO;
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
@ApiModel(description = "医院预约科室信息响应实体")
public class HosDeptRes extends HosDeptDTO<HosDeptRes> {


    /**
     * 科室ID
     */
    @ApiModelProperty(name = "ksid", position = 1, value = "科室ID" , example = "11540")
    private String ksid ;

    /**
     * 科室名称
     */
    @ApiModelProperty(name = "ksmc", position = 1, value = "科室名称" , example = "急诊内科")
    private String ksmc ;
    /**
     * 科室说明
     */
    @ApiModelProperty(name = "kssm", position = 1, value = "科室说明" , example = "二楼右二楼右二楼右二楼右")
    private String kssm ;
    /**
     * 科室位置
     */
    @ApiModelProperty(name = "kswz", position = 1, value = "科室位置" , example = "门诊二楼右侧")
    private String kswz ;

}
