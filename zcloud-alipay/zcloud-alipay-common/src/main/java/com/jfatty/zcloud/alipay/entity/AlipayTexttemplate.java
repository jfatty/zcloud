package com.jfatty.zcloud.alipay.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 描述：</b>QywxTexttemplate:文本模板<br>
 * 实体定义规则
 * 字段不允许存在基本类型，必须都是包装类型(因为基本类型有默认值)
 * 基本数据类型  包装类 byte Byte boolean Boolean short Short char Character int Integer long Long float Float double  Double
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */
@Data
@TableName("alipay_texttemplate")
public class AlipayTexttemplate extends Model<AlipayTexttemplate> {

    /**
     *id
     */
    private String id;
    /**
     *模板名称
     */
    private String templateName;
    /**
     *模板内容
     */
    private String templateContent;
    /**
     *微信企业账户id
     */
    private String accountid;
    /**
     *创建人名称
     */
    private String createName;
    /**
     *创建人登录名称
     */
    private String createBy;
    /**
     *创建日期
     */
    private Date createDate;
    /**
     *更新人名称
     */
    private String updateName;
    /**
     *更新人登录名称
     */
    private String updateBy;
    /**
     *更新日期
     */
    private Date updateDate;

}
