package com.jfatty.zcloud.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class AddressDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 所属人ID
     */
    @ApiModelProperty(name = "belongId", position = 1,required = true, value = "所属人ID" ,example = "2018110261977161")
    private String belongId;

    /**
     * 国家
     */
    @ApiModelProperty(name = "country", position = 1, value = "国家" ,example = "中国")
    private String country;

    /**
     * 省
     */
    @ApiModelProperty(name = "province", position = 1, value = "省" ,example = "湖北")
    private String province;

    /**
     * 市州
     */
    @ApiModelProperty(name = "province", position = 1, value = "市州" ,example = "武汉市")
    private String city;

    /**
     * 区县
     */
    @ApiModelProperty(name = "area", position = 1, value = "区县" ,example = "洪山区")
    private String area;

    /**
     * 乡
     */
    @ApiModelProperty(name = "ownship", position = 1, value = "乡" ,example = "关山街道")
    private String ownship;

    /**
     * 村
     */
    @ApiModelProperty(name = "village", position = 1, value = "村" ,example = "汤逊湖社区")
    private String village;

    /**
     * 户籍
     */
    @ApiModelProperty(name = "household", position = 1, value = "户籍" ,example = "汤逊湖社区")
    private String household;

    /**
     * 邮编
     */
    @ApiModelProperty(name = "postcode", position = 1, value = "邮编" ,example = "445000")
    private String postcode;

    /**
     * 地址类型
     */
    @ApiModelProperty(name = "addrType", position = 1, value = "地址类型" ,example = "户籍")
    private String addrType;

    /**
     * 描述备注
     */
    @ApiModelProperty(name = "description", position = 1, value = "描述备注" ,example = "大中华")
    private String description;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", position = 11,required = true,value = "正常使用 1 停用 0 使用状态" , example = "1" ,allowableValues = "0,1")
    private Integer state;


    /**
     * 域值
     */
    @ApiModelProperty(name = "realm", position = 12 , value = "域值" )
    private String realm;


    /**
     * 更新人
     */
    @ApiModelProperty(name = "updateOperator", position = 12 , value = "更新人" , example = "张三" )
    private String updateOperator;

    /**
     * 更新时间
     */
    @ApiModelProperty(name = "updateTime", position = 13 , value = "更新时间" ,allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
