package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/5/27
 * @email jfatty@163.com
 */
@Data
public class QuestionFormDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 题目ID
     */
    @ApiModelProperty(name = "id", position = 0,required = true,value = "题目ID",example = "1wswwsss" )
    private String id ;
    /**
     * 题目的排序号
     */
    @ApiModelProperty(name = "orderById", position = 0,required = true,value = "题目的排序号",example = "1" )
    private Integer orderById;
    /**
     * 题目标题
     */
    @ApiModelProperty(name = "quTitle", position = 0,required = true,value = "题目标题",example = "您对门诊的就医环境是否满意？" )
    private String quTitle;
    /**
     * 题目类型
     */
    @ApiModelProperty(name = "quType", position = 0,required = true,value = "题目类型 1 单选题 2 多选题 3 填空题 6 复合填空题",example = "1" )
    private Integer quType;

    /**
     * 填空题答案
     */
    //@ApiModelProperty(name = "answer", position = 0,value = "填空题答案",example = "多多改进" )
    //private String answer;

    /**
     * 前端界面自定义配置属性
     */
    @ApiModelProperty(name = "settings", position = 0,value = "前端界面自定义配置属性",example = "默认为空" )
    private String settings;

    @ApiModelProperty(name = "optionses", position = 0,value = "选项集合" )
    private List<OptionsFormDTO>  optionses ;

}
