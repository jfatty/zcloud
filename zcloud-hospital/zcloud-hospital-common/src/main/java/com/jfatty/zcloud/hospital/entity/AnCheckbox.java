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
@TableName("stad_an_checkbox")
public class AnCheckbox extends Model<AnCheckbox> {

    private static final long serialVersionUID = 1L;

    private String id;

    private String belongAnswerId;

    private String belongId;

    private String otherText;

    private String quId;

    private String quItemId;

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

    public AnCheckbox() {

    }

    public AnCheckbox(String id, String belongAnswerId, String belongId, String otherText, String quId, String quItemId, String customize) {
        this.id = id;
        this.belongAnswerId = belongAnswerId;
        this.belongId = belongId;
        this.otherText = otherText;
        this.quId = quId;
        this.quItemId = quItemId;
        this.customize = customize;
    }
}
