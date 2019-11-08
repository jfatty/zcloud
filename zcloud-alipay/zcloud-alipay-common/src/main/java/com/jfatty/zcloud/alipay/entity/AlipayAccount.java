package com.jfatty.zcloud.alipay.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 描述：</b>QywxAccount:账号信息表<br>
 * 实体定义规则
 * 字段不允许存在基本类型，必须都是包装类型(因为基本类型有默认值)
 * 基本数据类型  包装类 byte Byte boolean Boolean short Short char Character int Integer long Long float Float double  Double
 * @author Alex
 * @since：2016年03月24日 14时55分37秒 星期四
 * @version:1.0
 */
@Data
@TableName("alipay_account")
public class AlipayAccount extends Model<AlipayAccount> {

    /**
     *id
     */
    private String id;
    /**
     *名称
     */
    private String accontName;
    /**
     *描述
     */
    private String accountDesc;
    /**
     *商户应用APPID
     */
    private String appid;
    /**
     *开发者应用私钥
     */
    private String rsaPrivateKey;
    /**
     *支付宝公钥
     */
    private String alipayPublicKey;
    /**应用公钥*/
    private String publicKey;

    /**商户应用私钥**/
    private String privateKey ;

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

    private String conversationSecret ;

}
