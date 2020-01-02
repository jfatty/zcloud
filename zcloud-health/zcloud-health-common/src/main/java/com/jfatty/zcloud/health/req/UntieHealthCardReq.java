package com.jfatty.zcloud.health.req;

import com.jfatty.zcloud.health.dto.UntieHealthCardDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/1/2
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "解绑电子健康卡请求实体")
public class UntieHealthCardReq extends UntieHealthCardDTO<UntieHealthCardReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 openId 类型" , example = "2" ,allowableValues = "2")
    private Integer openIdType ;
    @ApiModelProperty(name = "hospitalId", position = 2,required = true, value = "医院ID" ,example = "30646")
    private String hospitalId ;
    @ApiModelProperty(name = "healthCardInfoId", position = 3,required = true, value = "健康卡信息记录ID(系统健康卡ID)",example = "2C9580916F47F3AA016F47F3AA0F0000")
    private String healthCardInfoId ;

}
