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
@TableName("stad_qu_multi_fillblank")
public class QuMultiFillblank extends Model<QuMultiFillblank> {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer checkType;

    private String optionName;

    private String optionTitle;

    private String quId;

    private Integer visibility;

    /**
     * 题号有数字、有字母
     */
    private Integer score;

    /**
     * 等级 或者是 阴阳性 或者 正常不正常状态等文字性描述标准
     */
    private String summary;

    /**
     * 题目的排序号
     */
    private Integer orderById;

}
