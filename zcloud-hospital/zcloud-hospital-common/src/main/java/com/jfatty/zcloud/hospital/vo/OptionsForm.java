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
public class OptionsForm implements Serializable {

    /**
     * 选项ID
     */
    private String id;
    /**
     * 排序号
     */
    private Integer orderById  ;
    /**
     * 选项名称
     */
    private String optionName;
    /**
     * 答案/是否选中
     */
    private String answer = "" ;

    /**
     * 其他用户补充
     */
    private String otherText = "" ;
    /**
     * 前端界面自定义配置属性
     */
    private String customize = "" ;

    /**
     * 后台标注字段
     * 后台反什么 前端原样提交
     */
    private String remark = "" ;


}
