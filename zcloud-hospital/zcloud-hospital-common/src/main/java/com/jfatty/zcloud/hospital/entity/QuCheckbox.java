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
@TableName("stad_qu_checkbox")
public class QuCheckbox extends Model<QuCheckbox> {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer checkType;

    private Integer isNote;

    private Integer isRequiredFill;

    private String optionName;

    private String optionTitle;

    private Integer orderById;

    private String quId;

    private Integer visibility;

    /**
     * 选项标准得分
     */
    private Integer score;

    /**
     * 等级 或者是 阴阳性 或者 正常不正常状态等文字性描述标准
     */
    private String summary;


}
