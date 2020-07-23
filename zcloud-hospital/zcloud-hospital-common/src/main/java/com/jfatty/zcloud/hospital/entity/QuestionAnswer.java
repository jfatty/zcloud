package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
@Data
@TableName("stad_question_answer")
public class QuestionAnswer extends Model<QuestionAnswer> {

    private static final long serialVersionUID = 1L;

    private String id;

    private String belongAnswerId;

    private String belongId;

    private String quId;

    private Integer visibility;

    /**
     * 用户回答状态0 1 2
     */
    private Integer answerStatus;

    /**
     * 无法评估、无、有、愿意评估、拒绝评估、无法评估
     */
    private String answerStatusNote;

    /**
     * 前端界面自定义配置属性
     */
    private String settings;

    public QuestionAnswer() {
    }

    public QuestionAnswer(String id,String belongId , String belongAnswerId, String quId, String settings) {
        this.id = id;
        this.belongId = belongId;
        this.belongAnswerId = belongAnswerId;
        this.quId = quId;
        this.settings = settings;
    }
}
