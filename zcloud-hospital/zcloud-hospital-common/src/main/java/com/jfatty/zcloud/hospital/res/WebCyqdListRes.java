package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.WebCyqdListDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 出院清单查询 住院记录
 *
 * @author jfatty on 2020/7/15
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "住院记录响应实体")
public class WebCyqdListRes extends WebCyqdListDTO<WebCyqdListRes> {

    //住院编号
    @ApiModelProperty(name = "zybh", position = 1, value = "住院编号" ,example = "202009376" )
    private String zybh ;

    //入院日期
    @ApiModelProperty(name = "ryrq", position = 1, value = "入院日期" ,example = "2020-07-12" )
    private String ryrq ;

    //出院日期
    @ApiModelProperty(name = "cyrq", position = 1, value = "出院日期" ,example = "2020-07-15" )
    private String cyrq ;

    //住院天数
    @ApiModelProperty(name = "zyts", position = 1, value = "住院天数" ,example = "4" )
    private String zyts ;

    //出院科室ID
    @ApiModelProperty(name = "cyks", position = 1, value = "出院科室ID" ,example = "8" )
    private String cyks ;

    //出院科室名称
    @ApiModelProperty(name = "cyksmc", position = 1, value = "出院科室名称" ,example = "内三科" )
    private String cyksmc ;

    //已缴合计
    @ApiModelProperty(name = "yjhj", position = 1, value = "已缴合计" ,example = "500.00" )
    private String yjhj ;

    //费用合计
    @ApiModelProperty(name = "fyhj", position = 1, value = "费用合计" ,example = "1747.97" )
    private String fyhj ;

    //住院状态
    @ApiModelProperty(name = "zyzt", position = 1, value = "住院状态" ,example = "出院结算" )
    private String zyzt ;


}
