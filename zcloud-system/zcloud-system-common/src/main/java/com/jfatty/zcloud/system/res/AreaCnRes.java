package com.jfatty.zcloud.system.res;

import com.jfatty.zcloud.system.dto.AreaCnDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/27
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "中国行政地区响应实体")
public class AreaCnRes extends AreaCnDTO<AreaCnRes> {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 父级ID
     */
    @ApiModelProperty(name = "parentId", position = 0,required = true, value = "父级ID",example = "447268")
    private String parentId;

    /**
     * 层级
     */
    @ApiModelProperty(name = "level", position = 0, required = true,value = "层级",example = "0",allowableValues = "1,2,3,4")
    private Integer level;

    /**
     * 名称
     */
    @ApiModelProperty(name = "name", position = 0, required = true,value = "名称",example = "湖北省")
    private String name;
    /**
     * 行政代码
     */
    @ApiModelProperty(name = "areaCode", position = 0,required = true, value = "行政代码",example = "422802000000")
    private Long areaCode;

}
