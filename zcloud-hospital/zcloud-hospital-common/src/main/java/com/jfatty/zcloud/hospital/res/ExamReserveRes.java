package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.ExamReserveDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "体检预约响应实体")
public class ExamReserveRes extends ExamReserveDTO<ExamReserveRes> {

    //预约号
    @ApiModelProperty(name = "yyh", position = 0,required = true, value = "预约号" ,example = "201255894")
    private String yyh ;
    //温馨提示
    @ApiModelProperty(name = "wxts", position = 0,required = true, value = "温馨提示" ,example = "这是温馨提示")
    private String wxts ;

}
