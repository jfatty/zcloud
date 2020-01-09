package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.UnPayOutpatientDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Accessors(chain = true)
@Data
@ApiModel(description = "就诊人待缴费单信息包含列表响应实体")
public class WebmzListRes extends UnPayOutpatientDTO<WebmzListRes> {

    @ApiModelProperty(name = "name", position = 2,required = true, value = "患者姓名 " , example = "2")
    private String name ;
    @ApiModelProperty(name = "idCard", position = 2,required = true, value = "身份证号 " , example = "422801125158582571747")
    private String idCard ;
    @ApiModelProperty(name = "jzh", position = 2,required = true, value = "就诊号 " , example = "202001080574")
    private String jzh ;

    private List<UnPayOutpatientRes> unPays ;

}
