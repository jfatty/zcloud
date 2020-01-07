package com.jfatty.zcloud.system.req;

import com.jfatty.zcloud.system.dto.AreaCnDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述
 *
 * @author jfatty on 2019/12/27
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "中国行政地区请求实体")
public class AreaCnReq extends AreaCnDTO<AreaCnReq> {

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

    /**
     * 邮政编码
     */
    @ApiModelProperty(name = "zipCode", position = 0, value = "邮政编码",example = "445000")
    private Integer zipCode;
    /**
     * 区号
     */
    @ApiModelProperty(name = "cityCode", position = 0,required = true, value = "区号",example = "0718")
    private String cityCode;
    /**
     * 简称
     */
    @ApiModelProperty(name = "shortName", position = 0,required = true, value = "简称",example = "恩施")
    private String shortName;
    /**
     * 组合名
     */
    @ApiModelProperty(name = "mergerName", position = 0, value = "组合名",example = "湖北,恩施,恩施")
    private String mergerName;
    /**
     * 拼音
     */
    @ApiModelProperty(name = "pinyin", position = 0,required = true, value = "拼音",example = "EnShi")
    private String pinyin;
    /**
     * 经度
     */
    @ApiModelProperty(name = "lng", position = 0, value = "经度",example = "108.936376")
    private BigDecimal lng;

    /**
     * 纬度
     */
    @ApiModelProperty(name = "lat", position = 0,value = "纬度",example = "30.290996")
    private BigDecimal lat;

}
