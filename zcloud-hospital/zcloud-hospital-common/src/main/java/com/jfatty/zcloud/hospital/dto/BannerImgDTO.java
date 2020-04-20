package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class BannerImgDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;


    /**
     * 排序号
     */
    @ApiModelProperty(name = "orderNum", position = 5, value = "排序号",required = true ,example = "14")
    private Integer orderNum;


    /**
     * 备注或者描述
     */
    @ApiModelProperty(name = "description", position = 7 , value = "备注或者描述" ,example = "这是描述")
    private String description;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", position = 8 ,required = true, value = "使用状态" ,example = "1",allowableValues = "1,0")
    private Integer state;

    /**
     * 图片一般存储为地址
     */
    @ApiModelProperty(name = "img", position = 10 , value = "存储为地址",example = "http://119.29.96.206/zealsoft/ban01.jpg")
    private String img;

    /**
     * 规格,格式  PC MOBILE APP
     */
    @ApiModelProperty(name = "specification", position = 2 , required = true, value = "规格,格式  PC MOBILE APP" ,example = "MOBILE" , allowableValues = "PC,PAD,MOBILE,APP")
    private String specification;

    /**
     * 关联对象id
     */
    @ApiModelProperty(name = "relationId", position = 2 , required = true, value = "关联对象id" ,example = "ASWS3332232322")
    private String relationId;

}
