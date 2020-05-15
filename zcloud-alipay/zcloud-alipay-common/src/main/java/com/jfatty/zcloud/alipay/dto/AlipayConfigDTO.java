package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 支付宝支付配置信息
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
public class AlipayConfigDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;

    /**
     * 支付宝APPID
     */
    @ApiModelProperty(name = "appid", position = 0, required = true, value = "支付宝APPID",example = "38473748183831")
    private String appid;

    /**
     * 私钥 pkcs8格式的
     */
    @ApiModelProperty(name = "rsaPrivateKey", position = 0, required = true, value = "私钥 pkcs8格式的",example = "3847374eowijwqejoiejoijoj8183831")
    private String rsaPrivateKey;

    /**
     * 支付宝网关地址
     */
    @ApiModelProperty(name = "alipayGateway", position = 0, required = true, value = "支付宝网关地址",example = "https://openapi.alipay.com/gateway.do")
    private String alipayGateway = "https://openapi.alipay.com/gateway.do";

    /**
     * 签名编码-视支付宝服务窗要求 GBK
     */
    @ApiModelProperty(name = "signCharset", position = 0, required = true, value = "签名编码-视支付宝服务窗要求 GBK",example = "GBK")
    private String signCharset;

    /**
     * 字符编码-传递给支付宝的数据编码 GBK UTF-8
     */
    @ApiModelProperty(name = "payCharset", position = 0, required = true, value = "字符编码-传递给支付宝的数据编码 GBK UTF-8",example = "UTF-8")
    private String payCharset = "UTF-8";

    /**
     * 返回格式json
     */
    @ApiModelProperty(name = "alipayFormat", position = 0, required = true, value = "返回格式json",example = "json")
    private String alipayFormat = "json";

    /**
     * 签名类型-视支付宝服务窗要求RSA2
     */
    @ApiModelProperty(name = "signType", position = 0, required = true, value = "签名类型-视支付宝服务窗要求RSA2",example = "RSA2")
    private String signType = "RSA2";

    /**
     * 支付宝公钥
     */
    @ApiModelProperty(name = "alipayPublicKey", position = 0, required = true, value = "支付宝公钥",example = "huhu9343984298742834832h8h238h8hdhd8h8")
    private String alipayPublicKey;

    /**
     * 应用公钥
     */
    @ApiModelProperty(name = "publicKey", position = 0, required = true, value = "应用公钥",example = "77888777766huhu9343984298742834832h8h238h8hdhd8h8")
    private String publicKey;

    /**
     * 应用私钥
     */
    @ApiModelProperty(name = "privateKey", position = 0, required = true, value = "应用私钥",example = "WWSSSS77888777766huhu9343984298742834832h8h238h8hdhd8h8")
    private String privateKey;

    /**
     * 授权访问令牌的授权类型
     */
    @ApiModelProperty(name = "grantType", position = 0, required = true, value = "授权访问令牌的授权类型",example = "authorization_code")
    private String grantType  = "authorization_code";

    /**
     * 开发者账号PID
     */
    @ApiModelProperty(name = "partner", position = 0, value = "开发者账号PID",example = "dev520")
    private String partner;

    /**
     * 异步通知地址 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    @ApiModelProperty(name = "notifyUrl", position = 0, required = true, value = "异步通知地址 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问",example = "http://www.baidu.com")
    private String notifyUrl;

    /**
     * 同步地址 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
     */
    @ApiModelProperty(name = "returnUrl", position = 0, required = true, value = "同步地址 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址",example = "http://www.baidu.com")
    private String returnUrl;

    /**
     * 超时时间 可空 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m
     */
    @ApiModelProperty(name = "timeoutExpress", position = 0, required = true, value = "超时时间 可空 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m",example = "15m")
    private String timeoutExpress;

    /**
     * 销售产品码 必填 QUICK_WAP_PAY
     */
    @ApiModelProperty(name = "productCode", position = 0, required = true, value = "销售产品码 必填 QUICK_WAP_PAY",example = "QUICK_WAP_PAY")
    private String productCode;

    /**
     * 支付后验证成功回调页面路径
     */
    @ApiModelProperty(name = "verResSuccess", position = 0,  value = "支付后验证成功回调页面路径",example = "http://www.baidu.com")
    private String verResSuccess;

    /**
     * 支付后验证失败回调页面路径
     */
    @ApiModelProperty(name = "verResFailed", position = 0, value = "支付后验证失败回调页面路径",example = "http://www.baidu.com")
    private String verResFailed;

    /**
     * 支付后验证失败回调页面路径
     */
    @ApiModelProperty(name = "authFailed", position = 0,  value = "支付后验证失败回调页面路径",example = "http://www.baidu.com")
    private String authFailed;

    /**
     * 账户id
     */
    @ApiModelProperty(name = "accountid", position = 0, required = true, value = "账户id",example = "73783e8ud83ue8v9939399329c")
    private String accountid;

}
