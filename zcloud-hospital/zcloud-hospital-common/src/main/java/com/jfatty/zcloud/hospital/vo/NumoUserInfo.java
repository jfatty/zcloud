package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Data
public class NumoUserInfo implements Serializable {

    private String openId;                                                          //微信用户的openId

    protected Long id;
    protected String createdBy;
    protected Integer createdType;                                                    //操作人类型，2--微信用户， 1--支付宝用户，3--后台用户
    protected String updatedBy;
    protected String updatedType;                                                     //操作人类型，2--微信用户， 1--支付宝用户，3--后台用户
    protected String createdTime;
    protected String updatedTime;

    private Integer userType;                                                       //用户类型 1--支付宝， 2--微信
    private Integer type;                                                           //关注状态 1--已经关注， 2--取消关注

    private Integer bindMax;

    private Integer bindNum;

    private String defaultPat ;

}
