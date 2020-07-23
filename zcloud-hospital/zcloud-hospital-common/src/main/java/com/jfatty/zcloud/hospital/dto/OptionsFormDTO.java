package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/5/27
 * @email jfatty@163.com
 */
@Data
public class OptionsFormDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 选项ID
     */
    @ApiModelProperty(name = "id", position = 0,required = true,value = "选项ID",example = "1wswwsss" )
    private String id = "";
    /**
     * 排序号
     */
    @ApiModelProperty(name = "orderById", position = 0,required = true,value = "选项的排序号",example = "1" )
    private Integer orderById = 0 ;
    /**
     * 选项名称
     */
    @ApiModelProperty(name = "optionName", position = 0,required = true,value = "选项名称",example = "满意" )
    private String optionName = "";
    /**
     * 答案/是否选中
     */
    @ApiModelProperty(name = "answer", position = 0,required = true,value = "答案/是否选中",example = "单选 多选 为checked 复合填空 为用户填写答案" )
    private String answer = "" ;
    /**
     * 其他用户补充
     */
    @ApiModelProperty(name = "otherText", position = 0,value = "单选多选 其他选项用户手动填写",example = "游泳" )
    private String otherText = "" ;
    /**
     * 前端界面自定义配置属性
     */
    @ApiModelProperty(name = "customize", position = 0, value = "前端界面自定义配置属性",example = "默认为空" )
    private String customize = "";

    /**
     * 后台标注字段
     * 后台反什么 前端原样提交
     */
    @ApiModelProperty(name = "remark", position = 0, value = "后台标注字段 后台反什么 前端原样提交",example = "AAAbbbID" )
    private String remark = "" ;
}
