package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 就诊指南
 *
 * @author jfatty on 2020/4/28
 * @email jfatty@163.com
 */
@Data
public class TreatGuideDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 应用ID APPID
     */
    @ApiModelProperty(name = "appid", position = 2,required = true, value = "微信  支付宝  APP appId" , example = "wx0725202a2fe5ffcf" )
    private String appid;

    /**
     * 就诊指南标题
     */
    @ApiModelProperty(name = "title", value = "就诊指南标题", required = true, position = 2, example = "中医院微信公众号操作指南")
    private String title;

    /**
     * 就诊指南图标
     */
    @ApiModelProperty(name = "icon", value = "就诊指南图标", required = true, position = 2, example = "http://icon.com/jzzn.png")
    private String icon;

    /**
     * 就诊指南详情地址
     */
    @ApiModelProperty(name = "guideDetail", value = "就诊指南详情地址", required = true, position = 2, example = "http://icon.com/jzzn.png")
    private String guideDetail;

    /**
     * 规格,格式
     */
    @ApiModelProperty(name = "specification", position = 2 , required = true, value = "规格,格式  PC MOBILE APP" ,example = "MOBILE" , allowableValues = "PC,PAD,MOBILE,APP")
    private String specification;
    /**
     * 排序号
     */
    @ApiModelProperty(name = "orderNum", position = 5, value = "排序号",required = true ,example = "14")
    private Integer orderNum;


    /**
     * 版本
     */
    @ApiModelProperty(name = "version", position = 6, value = "版本" ,required = true,example = "1.0.0" )
    private String version;

    /**
     * 使用方唯一码
     */
    @ApiModelProperty(name = "user", value = "使用方唯一码", required = true, position = 2, example = "lsxzyy")
    private String user;

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

}
