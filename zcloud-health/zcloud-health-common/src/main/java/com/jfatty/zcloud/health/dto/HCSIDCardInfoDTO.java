package com.jfatty.zcloud.health.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 描述 身份证信息
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Data
public class HCSIDCardInfoDTO<T extends BaseDTO> extends BaseDTO {


    /**
     * 本表中本字段ID为身份证号码
     */
    @ApiModelProperty(name = "id", position = 0, value = "本表中本字段ID即为身份证号码[添加操作,修改操作必传]")
    private String id ;

    @ApiModelProperty(name = "name", position = 0, value = "姓名",required = true ,example = "张三")
    private String name;

    /**
     * 本表中本字段即为身份证号码
     */
    @ApiModelProperty(name = "idCard", position = 0, value = "身份证号码[添加操作,修改操作必传]",example = "422801199207014611")
    private String idCard ;

    @ApiModelProperty(name = "gender", position = 0, value = "性别",required = true ,example = "男",allowableValues = "男,女")
    private String gender;

    @ApiModelProperty(name = "nation", position = 0, value = "民族",example = "土家")
    private String nation;

    @ApiModelProperty(name = "birth", position = 0, value = "出生日期",example = "1994-01-04")
    private String birth;

    @ApiModelProperty(name = "address", position = 0, value = "家庭地址",example = "湖北武汉")
    private String address;

    /**
     *
     */
    @ApiModelProperty(name = "authority", position = 0, value = "签发机关",example = "xxx公安局")
    private String authority;

    @ApiModelProperty(name = "validDate", position = 0, value = "有效期",example = "xxxx.xx.xx-xxxx.xx.xx")
    private String validDate;

    /**
     *
     */
    @ApiModelProperty(name = "description", position = 0, value = "描述",example = "***xxxx")
    private String description;

    /**
     * 使用状态0表示正常使用-1表示维护中-2表示建设中...
     */
    @ApiModelProperty(name = "status", position = 0, value = "使用状态0表示正常使用-1表示维护中-2表示建设中...",example = "0",allowableValues = "0,-1,-2")
    private Integer status;





}
