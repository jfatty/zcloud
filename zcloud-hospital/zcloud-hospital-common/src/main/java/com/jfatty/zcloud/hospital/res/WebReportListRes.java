package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.WebReportListDTO;
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
@ApiModel(description = "检验/检查报告列表响应实体")
public class WebReportListRes extends WebReportListDTO<WebReportListRes> {
    /**
     * 流水号
     */
    @ApiModelProperty(name = "djh", position = 2 ,required = true, value = "流水号 " , example = "3266544")
    private String djh ;
    /**
     * 项目名称
     */
    @ApiModelProperty(name = "xmmc", position = 2 ,required = true, value = "项目名称 " , example = "测血压")
    private String xmmc ;
    /**
     * 报告时间
     */
    @ApiModelProperty(name = "bgsj", position = 2 ,required = true, value = "报告时间 " , example = "1")
    private String bgsj ;
    /**
     * 报告人
     */
    @ApiModelProperty(name = "bgr", position = 2 ,required = true, value = "报告人 " , example = "哈哈")
    private String bgr ;
    /**
     * 审核人
     */
    @ApiModelProperty(name = "shr", position = 2 ,required = true, value = "审核人 " , example = "哈哈")
    private String shr ;

}
