package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.HosClazzDTO;
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
@ApiModel(description = "医院工作班次响应实体")
public class HosClazzRes extends HosClazzDTO<HosClazzRes> {

    /**
     * 班次ID
     */
    @ApiModelProperty(name = "bcid", position = 0,required = true, value = "班次ID" ,example = "1")
    private String bcid ;
    /**
     * 班次名称
     */
    @ApiModelProperty(name = "bcmc", position = 0,required = true, value = "班次名称" ,example = "上午")
    private String bcmc ;
    /**
     * 开始时间
     */
    @ApiModelProperty(name = "kssj", position = 0,required = true, value = "开始时间" ,example = "08:00")
    private String kssj ;
    /**
     * 结束时间
     */
    @ApiModelProperty(name = "jssj", position = 0,required = true, value = "结束时间" ,example = "12:00")
    private String jssj ;

}
