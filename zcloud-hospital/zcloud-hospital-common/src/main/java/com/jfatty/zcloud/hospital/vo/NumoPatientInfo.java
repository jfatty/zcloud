package com.jfatty.zcloud.hospital.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 描述 移动护理模块 患者信息表
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Accessors(chain = true)
@Data
public class NumoPatientInfo implements Serializable {

    protected Long id;
    protected String createdBy;
    protected Integer createdType;                                                    //操作人类型，2--微信用户， 1--支付宝用户，3--后台用户
    protected String updatedBy;
    protected String updatedType;                                                     //操作人类型，2--微信用户， 1--支付宝用户，3--后台用户
    protected String createdTime;
    protected String updatedTime;

    private String patId;                                                           //HIS系统病人唯一码
    private String name;                                                            //姓名
    private Integer age;                                                            //年龄
    private Integer gender;                                                         //性别 1--男， 2--女
    private String tel;                                                             //联系电话
    private String idCard;                                                          //身份证号
    private String address;                                                         //地址
    private String cardNo;                                                          //绑定的卡号 jfatty add 绑定HIS系统中的磁卡号
    private String verifyCode ;                                                     //手机验证码

    private String hisCardNo ;                                                       //就诊卡号
    private String hisCardType ;                                                     //就诊卡类型
    private String hisCardTypeCode ;                                                 //就诊卡类型编码

    private String nation;                                                           //民族
    private String relationship ;                                                    //与就诊人关系
}
