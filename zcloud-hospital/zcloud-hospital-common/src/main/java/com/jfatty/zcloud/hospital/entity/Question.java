package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
@Data
@TableName("stad_question")
public class Question extends Model<Question> {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer answerInpustadRow;

    private Integer answerInpustadWidth;

    private String belongId;

    /**
     * 题号有数字、有字母
     */
    private String quNum;

    private String quName;

    private String quNote;

    private Integer cellCount;

    private Integer checkType;

    private Integer contactsAttr;

    private String contactsField;

    private String copyFromId;

    private LocalDateTime createDate;

    private Integer hv;

    private Integer isRequired;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 题目的排序号
     */
    private Integer orderById;

    private Integer paramInt01;

    private Integer paramInt02;

    private String parenstadQuId;

    private Integer quTag;

    /**
     * 题目标题
     */
    private String quTitle;

    private Integer quType;

    private Integer randOrder;

    private Integer tag;

    private Integer visibility;

    private Integer yesnoOption;

    private Integer answerInputRow;

    private Integer answerInputWidth;

    /**
     * 父题目ID
     */
    private String parentQuId;

    /**
     * 每题计分公式
     */
    private String formula;

    /**
     * 是否在最终结果表中显示出来 0 表示不显示 1 表示显示
     */
    private Integer showInResult;

    /**
     * 选项标准得分 填空题的分值要写在 问题里面 有分数段的情况出现
     */
    private String score;

    /**
     * 每题的标准答案
     */
    private String answer;

    /**
     * 每题或者每项的评估标准
     */
    private String quRemark;

    /**
     * 0 表示不是题目标题标记 1 表示是题目标题标记
     */
    private Integer isQuTitle;

    /**
     * 本题回答之后是否可修改状态默认为1表示可修改0表示表示本题回答后是不支持修改的
     */
    private Integer editState;

    /**
     * 前端界面自定义配置属性
     */
    private String settings;

    /**
     * 标签属性
     */
    private String labelAttr;

    /**
     * 合并行值默认占1行的值
     */
    private Integer mergeRow;

    /**
     * 合并列值默认占1列的值
     */
    private Integer mergeCol;

    /**
     * 改题目是否支持统计0表示默认表示不支持1表示支持统计
     */
    private Integer stats;

}
