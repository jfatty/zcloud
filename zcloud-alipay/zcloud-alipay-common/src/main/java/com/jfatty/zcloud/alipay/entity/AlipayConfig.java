package com.jfatty.zcloud.alipay.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 支付宝支付配置信息表
 * </p>
 *
 * @author jfatty
 * @since 2019-11-08
 */
@Data
@TableName("alipay_config")
public class AlipayConfig extends Model<AlipayConfig> {


    /**
     * 主键ID
     */
    private String id;

    /**
     * 支付宝APPID
     */
    private String appid;

    /**
     * 私钥 pkcs8格式的
     */
    private String rsaPrivateKey;

    /**
     * 支付宝网关地址
     */
    private String alipayGateway = "https://openapi.alipay.com/gateway.do";

    /**
     * 签名编码-视支付宝服务窗要求 GBK
     */
    private String signCharset;

    /**
     * 字符编码-传递给支付宝的数据编码 GBK UTF-8
     */
    private String payCharset = "UTF-8";

    /**
     * 返回格式json
     */
    private String alipayFormat = "json";

    /**
     * 签名类型-视支付宝服务窗要求RSA2
     */
    private String signType = "RSA2";

    /**
     * 支付宝公钥
     */
    private String alipayPublicKey;

    /**
     * 应用公钥
     */
    private String publicKey;

    /**
     * 应用私钥
     */
    private String privateKey;

    /**
     * 授权访问令牌的授权类型
     */
    private String grantType  = "authorization_code";

    /**
     * 开发者账号PID
     */
    private String partner;

    /**
     * 异步通知地址 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    private String notifyUrl;

    /**
     * 同步地址 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
     */
    private String returnUrl;

    /**
     * 超时时间 可空 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m
     */
    private String timeoutExpress;

    /**
     * 销售产品码 必填 QUICK_WAP_PAY
     */
    private String productCode;

    /**
     * 支付后验证成功回调页面路径
     */
    private String verResSuccess;

    /**
     * 支付后验证失败回调页面路径
     */
    private String verResFailed;

    /**
     * 支付后验证失败回调页面路径
     */
    private String authFailed;

    /**
     * 账户id
     */
    private String accountid;


}
