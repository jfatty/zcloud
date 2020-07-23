package com.jfatty.zcloud.hospital.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2020/4/30
 * @email jfatty@163.com
 */
@Data
public class SurveyForm implements Serializable {

    /**
     * 量表或者问卷ID
     */
    private String surveyId;

    /**
     * 答案卷Id
     */
    private String answerId = "" ;

    /**
     * 量表名
     */
    private String surveyName;

    /**
     * 量表备注
     */
    private String surveyNote ;

    /**
     * 量表简称
     */
    private String simpleName;

    /**
     * 开始答题时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime bgAnDate;

    /**
     * 答题结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endAnDate;

    /**
     * 总分
     */
    private String totalScore;

    /**
     * 评估结论
     */
    private String summary;
    /**
     * 操作员,量表填写人
     */
    private String operator;

    /**
     * 微信或支付宝用户ID
     */
    private String openId ;

    /**
     * 操作时间
     */
    private String operationTime = "" ;

    /**
     * 问卷指向 对象ID  例如病人ID
     */
    private String associationId;

    /**
     * 问卷指向 对象名称 例如病人名称
     */
    private String associationer;

    /**
     * 对应评估量表 用户是否可以作答 0 表示可以作答 1 表示 不能作答
     */
    private Integer answerState;


}
