package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import lombok.Data;

import java.util.Date;

/**
 * 描述 账号信息表
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
public class AlipayAccountDTO<T extends BaseDTO> extends BaseDTO {

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
