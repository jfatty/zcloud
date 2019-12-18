package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.WebReportLisDetailDTO;
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
@ApiModel(description = "检验报告内容响应实体")
public class WebReportLisDetailRes extends WebReportLisDetailDTO<WebReportLisDetailRes> {
    /**
     * 项目名称
     */
    @ApiModelProperty(name = "xmmc", position = 2 ,required = true, value = "项目名称 " , example = "化学")
    private String xmmc ;
    /**
     * 项目缩写
     */
    @ApiModelProperty(name = "xmsx", position = 2 ,required = true, value = "项目缩写 " , example = "CDD")
    private String xmsx ;
    /**
     * 项目结果
     */
    @ApiModelProperty(name = "xmjg", position = 2 ,required = true, value = "项目结果 " , example = "12.26")
    private String xmjg ;
    /**
     * 参考值
     */
    @ApiModelProperty(name = "ckz", position = 2 ,required = true, value = "参考值 " , example = "12-26")
    private String ckz ;
    /**
     * 升降标志
     */
    @ApiModelProperty(name = "sjbz", position = 2 ,required = true, value = "升降标志 " , example = "↑")
    private String sjbz ;
    /**
     * 单位
     */
    @ApiModelProperty(name = "dw", position = 2 ,required = true, value = "单位 " , example = "瓶")
    private String dw ;

}
