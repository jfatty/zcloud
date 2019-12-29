package com.jfatty.zcloud.health.req;

import com.jfatty.zcloud.health.dto.HCSHealthCardInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/29
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "电子健康卡列表请求实体")
public class SimpleHealthCardInfoReq extends HCSHealthCardInfoDTO<SimpleHealthCardInfoReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 openId 类型" , example = "2" ,allowableValues = "2")
    private Integer openIdType ;
    @ApiModelProperty(name = "hospitalId", position = 0,required = true, value = "医院ID" ,example = "30646")
    private String hospitalId ;
}
