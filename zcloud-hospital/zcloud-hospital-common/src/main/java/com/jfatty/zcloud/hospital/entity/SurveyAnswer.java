package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 评估量表或者调查问卷 回答
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
@Data
@TableName("stad_survey_answer")
public class SurveyAnswer extends Model<SurveyAnswer> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 回答者是详细地址
     */
    private String addr;

    /**
     * 开始答题时间
     */
    private LocalDateTime bgAnDate;

    /**
     * 城市
     */
    private String city;

    /**
     * 答题数目
     */
    private Integer completeItemNum;

    /**
     * 回答了多少题
     */
    private Integer completeNum;

    /**
     * 数据来源 0网调  1录入数据 2移动数据 3导入数据
     */
    private Integer dataSource;

    /**
     * 答题结束时间
     */
    private LocalDateTime endAnDate;

    /**
     * 操作状态 0未处理 1通过 2不通过
     */
    private Integer handleState;

    /**
     * ip地址
     */
    private String ipAddr;

    /**
     * 是否完全答完 1完成
     */
    private Integer isComplete;

    /**
     * 完成百分比
     */
    private String completionPercentage;

    /**
     * 是否有效 1有效
     */
    private Integer isEffective;

    /**
     * PC机mac地址
     */
    private String pcMac;

    /**
     * 问题数目
     */
    private Integer quNum;

    /**
     * 量表或者问卷ID
     */
    private String surveyId;

    /**
     * 答题耗时时间
     */
    private Float totalTime;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 控制是否唯一答案、意思是该评估表，每个病人只能有一份结果
     */
    private Integer uniqueNum;

    /**
     * 问卷指向 对象ID  例如病人ID
     */
    private String associationId;

    /**
     * 问卷指向 对象名称 例如病人名称
     */
    private String associationer;

    /**
     * 操作员,量表填写人
     */
    private String operator;

    /**
     * 体检时间
     */
    private String operationTime;

    /**
     * 总分
     */
    private String totalScore;

    /**
     * 评估结论
     */
    private String summary;

    /**
     * 结论备注说明
     */
    private String note;

    /**
     * 量表填写次数 默认为0次
     */
    private Integer answerNum;

    /**
     * 评估或者调查状态0 1 2
     */
    private Integer surveyStatus;

    /**
     * 无法评估、无、有、愿意评估、拒绝评估、无法评估
     */
    private String surveyStatusNote;

    /**
     * 等级未知用0表示其他依次从1到到5表示从正常到不正常
     */
    private Integer surveyGrade;

    /**
     * 对应本次评估量表的 使用状态 1 正常使用 2作废 0 停用状态
     */
    private Integer answerState;

    /**
     * 医生建议
     */
    private String suggestion;

    /**
     * 量表打印状态 默认为0表示未打印
     */
    private Integer printState;

    /**
     * 打印时间
     */
    private String printTime;

    /**
     * 打印操作人员id
     */
    private String printOperator;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建人
     */
    private String createOperator;

    /**
     * 更新人员
     */
    private String updateOperator;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 使用状态
     */
    private Integer state;

    /**
     * 本项结果生成之后是否可修改状态默认为1表示可修改0表示表示本项结果生成后是不支持再修改
     */
    private Integer editState;

    /**
     * 健康体检表编号
     */
    private String serialNum;

    /**
     * 责任医生姓名
     */
    private String doctor;

    /**
     * 微信或支付宝用户ID
     */
    private String openId ;


}
