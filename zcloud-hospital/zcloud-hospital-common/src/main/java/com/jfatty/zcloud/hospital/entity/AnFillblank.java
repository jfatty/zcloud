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
@TableName("stad_an_fillblank")
public class AnFillblank extends Model<AnFillblank> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 填空题答案
     */
    private String answer;

    /**
     * 填空题答案备注字段
     */
    private String answerNote;

    private String belongAnswerId;

    private String belongId;

    private String quId;

    private Integer visibility;

    /**
     * 填写回答后得分
     */
    private Integer score;

    /**
     * 等级 或者是 阴阳性 或者 正常不正常状态等文字性描述标准
     */
    private String summary;

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
    private String customize;

    public AnFillblank() {
    }

    public AnFillblank(String id, String answer, String answerNote, String belongAnswerId, String belongId, String quId, String customize) {
        this.id = id;
        this.answer = answer;
        this.answerNote = answerNote;
        this.belongAnswerId = belongAnswerId;
        this.belongId = belongId;
        this.quId = quId;
        this.customize = customize;
    }
}
