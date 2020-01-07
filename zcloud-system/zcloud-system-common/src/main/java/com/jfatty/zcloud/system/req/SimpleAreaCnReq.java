package com.jfatty.zcloud.system.req;

import com.jfatty.zcloud.system.dto.AreaCnDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/1/7
 * @email jfatty@163.com
 */
@Data
public class SimpleAreaCnReq extends AreaCnDTO<SimpleAreaCnReq> {


    @ApiModelProperty(name = "parentId", position = 0,required = true, value = "父级行政地区ID",example = "447268")
    private String parentId ;

    @ApiModelProperty(name = "level", position = 1,required = true, value = "行政地区 级别0-4",example = "0",allowableValues = "0,1,2,3,4")
    private Integer level ;

    @ApiModelProperty(name = "name", position = 2,required = true, value = "行政地区 名称",example = "湖北省")
    private String name = "" ;

    @ApiModelProperty(name = "shortName", position = 3,required = true, value = "行政地区 简称",example = "湖北")
    private String shortName = "" ;


}
