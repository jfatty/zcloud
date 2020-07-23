package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 评估量表或者调查问卷
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
@Data
@TableName("stad_survey_directory")
public class SurveyDirectory extends Model<SurveyDirectory> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    private Integer anItemLeasstadNum;

    /**
     * 量表填写次数默认为0次
     */
    private Integer answerNum;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 1目录，2量表
     */
    private Integer dirType;

    private Integer excerpstadNum;

    /**
     * 静态HTML保存路径
     */
    private String htmlPath;

    /**
     * 该表是否要进行分数统计 默认1表示要进行分数统计 回显结果 0 表示不进行分数统计 不回显结果
     */
    private Integer showResult;

    /**
     * 是否为备份表 默认为0表示不是 1 表示是 备份表
     */
    private Integer isBackup;

    /**
     * 是否共享量表  0不共享 1共享
     */
    private Integer isShare;

    private String parenstadId;

    /**
     * 用于短链接的ID
     */
    private String sid;

    /**
     * 类型、或者所属主体 例如“FRAIL”简化量表 属于 衰弱调查
     */
    private String objecstadId;

    /**
     * 所对应的量表详细信息表Id  当dirType=2
     */
    private String surveyDetailId;

    /**
     * 量表所属的量表模块   1量表模块
     */
    private Integer surveyModel;

    /**
     * 量表名
     */
    private String surveyName;

    /**
     * 量表简称
     */
    private String simpleName;

    /**
     * 表的英文名
     */
    private String enName;

    /**
     * 评估内容
     */
    private String surveyContent;

    /**
     * 评估量表类型
     */
    private String surveyType;

    /**
     * 量表下面有多少题目数
     */
    private Integer surveyQuNum;

    /**
     * 量表状态  0默认设计状态  1执行中 2结束
     */
    private Integer surveyState;

    /**
     * 量表标识 默认 0待审核  1审核通过  2审核未通过
     */
    private Integer surveyTag;

    /**
     * 用户id操作人员id
     */
    private String userId;

    /**
     * 是否公开结果  0不  1公开
     */
    private Integer viewAnswer;

    /**
     * 是否显示  1显示 0不显示
     */
    private Integer visibility;

    private Integer anItemLeastNum;

    /**
     * 引用次数
     */
    private Integer excerptNum;

    /**
     * 父量表ID
     */
    private String parentId;

    /**
     * 微信小程序中对应html页面地址
     */
    private String mpHtmlPath;

    /**
     * 是否为系统自动录入该表的值 0 表示 否 1 表示是 通常用在结论性的总表上面
     */
    private Integer autoCalc;

    /**
     * 默认为0 不唯一 1表示 唯一控制是否唯一答案、意思是该评估表，每个病人只能有一份结果
     */
    private Integer uniqueNum;

    /**
     * 开放评估状态1开放评估 默认为0表示关闭评估3评估量表作废
     */
    private Integer openState;

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
     * 本表生成之后是否可修改状态默认为1表示可修改0表示表示本表生成后是不支持修改的
     */
    private Integer editState;

    /**
     * 是否限制出结论或者结果的次数0表示不限制1表示限制
     */
    private Integer limitSum;

    /**
     * 在限制出结论或者结果的的情况下,具体限制的次数,默认限制出一次
     */
    private Integer limitSumNum;

    /**
     * 本项评估量表对应结果数据是通过用户录入后得出还是通过计算机计算得出0表示通过用户录入数据得出1表示通过计算机计算出
     */
    private Integer resultEntryType;

    /**
     * 量表统计状态默认0表示该量表不进行统计1表示该量表需要进行统计
     */
    private Integer statisticsState;

    /**
     * 该量表是否支持结果打印默认0表示不支持1表示支持
     */
    private Integer printSupport;

    /**
     * 用户对量表的操作范围-1不可操作0所有用户都可以操作1普通用户可以操作2指定用户才能操作
     */
    private Integer optScope;

    /**
     * 是否为自评表 0表示否1表示是 默认为否
     */
    private Integer selfTest;

    /**
     * 类似医生一类的填表人填写 0表示否1表示是 默认为否
     */
    private Integer otherTest;

    /**
     * 系统自动填写0表示否1表示是 默认为否
     */
    private Integer sysTest;

    /**
     * 量表对应出结果的类型 00 既不是总分已不是总结 01 非总分是总结 10 是总分非总结 11及时总分又是总结
     */
    private String resultType;


}
