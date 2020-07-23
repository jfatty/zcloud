package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.WebCyfyqdDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 出院清单查询
 *
 * @author jfatty on 2020/7/15
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "出院清单查询响应实体")
public class WebCyfyqdRes extends WebCyfyqdDTO<WebCyfyqdRes> {

    //处方号
    @ApiModelProperty(name = "cfh", position = 1, value = "处方号" ,example = "200700167467" )
    private String cfh ;

    //处方序号
    @ApiModelProperty(name = "cfxh", position = 1, value = "处方序号" ,example = "3" )
    private String cfxh ;

    //处方日期
    @ApiModelProperty(name = "cfrq", position = 1, value = "处方日期" ,example = "2020-07-15" )
    private String cfrq ;

    //收费分类名称
    @ApiModelProperty(name = "sfflmc", position = 1, value = "收费分类名称" ,example = "中药饮片" )
    private String sfflmc ;

    //收费项目名称
    @ApiModelProperty(name = "sfxmmc", position = 1, value = "收费项目名称" ,example = "辛夷（饮）（包煎）1g" )
    private String sfxmmc ;

    //单位
    @ApiModelProperty(name = "dw", position = 1, value = "单位" ,example = "克" )
    private String dw ;

    //单价
    @ApiModelProperty(name = "dj", position = 1, value = "单价" ,example = "2.1250" )
    private String dj ;

    //数量
    @ApiModelProperty(name = "sl", position = 1, value = "数量" ,example = "30.0" )
    private String sl ;

    //金额
    @ApiModelProperty(name = "je", position = 1, value = "金额" ,example = "1.58" )
    private String je ;

}
