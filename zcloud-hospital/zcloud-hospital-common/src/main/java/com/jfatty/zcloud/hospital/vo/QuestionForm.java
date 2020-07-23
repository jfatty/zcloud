package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2020/4/30
 * @email jfatty@163.com
 */
@Data
public class QuestionForm implements Serializable {

    /**
     * 题目ID
     */
    private String id;
    /**
     * 题目的排序号
     */
    private Integer orderById;
    /**
     * 题目标题
     */
    private String quTitle;
    /**
     * 题目类型
     */
    private Integer quType;

    /**
     * 填空题答案
     */
    //private String answer = "" ;

    /**
     * 前端界面自定义配置属性
     */
    private String settings;

}
