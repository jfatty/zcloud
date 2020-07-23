package com.jfatty.zcloud.hospital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/5/27
 * @email jfatty@163.com
 */
@Data
public class SurveyFormDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 量表或者问卷ID
     */
    @ApiModelProperty(name = "surveyId", position = 0, required = true, value = "量表或者问卷ID",example = "4028fe8171f7125b0171f71a19ff0000")
    private String surveyId;

    /**
     * 答案卷Id
     */
    @ApiModelProperty(name = "answerId", position = 0, value = "答案卷Id",example = "4028fe8171f7125b0171f71a19ff0000")
    private String answerId ;

    /**
     * 量表名
     */
    @ApiModelProperty(name = "surveyName", position = 0, required = true, value = "量表名",example = "龙山县中医院职工满意度调查表")
    private String surveyName;
    /**
     * 量表备注
     */
    @ApiModelProperty(name = "surveyNote", position = 0, value = "量表备注",example = "满意度调查表")
    private String surveyNote ;

    /**
     * 量表简称
     */
    @ApiModelProperty(name = "simpleName", position = 0, value = "量表简称",example = "职工满意度调查")
    private String simpleName;

    /**
     * 开始答题时间
     */
    @ApiModelProperty(name = "bgAnDate", position = 0, value = "开始答题时间",example = "2020-05-28 16:24:27" ,allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime bgAnDate;

    /**
     * 答题结束时间
     */
    @ApiModelProperty(name = "endAnDate", position = 0, value = "答题结束时间",example = "2020-05-28 16:33:27" ,allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endAnDate;

    /**
     * 总分
     */
    @ApiModelProperty(name = "totalScore", position = 0, value = "总分",example = "" )
    private String totalScore;

    /**
     * 评估结论
     */
    @ApiModelProperty(name = "summary", position = 0, value = "评估结论",example = "非常满意" )
    private String summary;
    /**
     * 操作员,量表填写人
     */
    @ApiModelProperty(name = "operator", position = 0, value = "操作员,量表填写人",example = "wsxcderfvbgtyhnmju" )
    private String operator;

    /**
     * 微信或支付宝用户ID
     */
    @ApiModelProperty(name = "openId", position = 0, value = "微信或支付宝用户ID",example = "wsxcderfvbgtyhnmju" )
    private String openId ;

    /**
     * 操作时间
     */
    @ApiModelProperty(name = "operationTime", position = 0, value = "操作时间",example = "2020-06-03 09:49:11",allowableValues = "yyyy-MM-dd HH:mm:ss")
    private String operationTime = "";

    /**
     * 问卷指向 对象ID  例如病人ID
     */
    @ApiModelProperty(name = "associationId", position = 0, value = "问卷指向 对象ID  例如病人ID",example = "zhangsanid" )
    private String associationId;

    /**
     * 问卷指向 对象名称 例如病人名称
     */
    @ApiModelProperty(name = "associationer", position = 0, value = "问卷指向 对象名称 例如病人名称",example = "azsxdcdfvqwed" )
    private String associationer;

    /**
     * 对应评估量表 用户是否可以作答 0 表示可以作答 1 表示 不能作答
     */
    @ApiModelProperty(name = "answerState", position = 0, value = "对应评估量表 用户是否可以作答 0 表示可以作答 1 表示 不能作答(或者已经作答)",example = "1" )
    private Integer answerState;


    @ApiModelProperty(name = "questions", position = 0, value = "题目集合" )
    private List<QuestionFormDTO> questions ;

}
