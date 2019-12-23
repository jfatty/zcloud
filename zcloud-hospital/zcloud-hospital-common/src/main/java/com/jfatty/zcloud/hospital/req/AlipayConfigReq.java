package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.AlipayConfigDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/24
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "支付宝支付配置信息请求实体")
public class AlipayConfigReq extends AlipayConfigDTO<AlipayConfigReq> {

    /**
     * 支付宝APPID
     */
    @ApiModelProperty(name = "appid", position = 0,required = true, value = "支付宝APPID" ,example = "2018110261977161")
    private String appid;

    /**
     * 支付宝支付商户号
     */
    @ApiModelProperty(name = "mchId", position = 0,required = true, value = "支付宝支付商户号" ,example = "2018110261977161")
    private String mchId;

    /**
     * 支付宝公钥
     */
    @ApiModelProperty(name = "alipayPublicKey", position = 0,required = true, value = "支付宝公钥" ,example = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl8KX9zrLqaWm80vrNL6LIHVI3JKqKYJD3MRIkpsTtxUYngm21nzJD6wljwaKNXsVKJV3Ofnbu4aS89Dy8V3ooidAK9OZ6IyLhQ+igrLmBW1n+5NkefGt8l1SA4Cdj/8CrxnO4PFsam2XAPB1dA8gNHVA36nlzbJKOQrJNi8F/VIGjggjENPbKIzIwMjrhE03POb0Or9g1vY3OB6sBJOiNMH7hngrlinpihvedsHvOrr2ZC2D9vq/gMqW/M8BjRDI6oFq2JSDge98REGeRpvjnBgernzX7AEAYU1UyT3Za8NcZramGwb7QKYvS7z0Wrwllr2EFOM9grVhKOiQT7UX6QIDAQAB")
    private String alipayPublicKey;

    /**
     * 应用私钥
     */
    @ApiModelProperty(name = "privateKey", position = 0,required = true, value = "应用私钥" ,example = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCcVSYKmAJe/QY75I1fTEUNgAL3PzuRGSyca7vmftqR2Bmq7i3dvcRuEo6UZIxyJOvqChPLMa27gCf3/LNf2eFOCnXHzdflK6L+eMEd02u0YQRQDewiyRQqunWLQ+V9Me1dSjCU6xvKkKU48/4gQFc7elVobxlxA8oADzNiecvDX01Ew2QFunD3I7Oj3fPpcp4za9Jj6uDdk9nzWr4nXfFulYg0JarI2/oQ4zRUzlwUpNyNgy7CnhMd0CM19v9B82DHDD3LLEIQA8B2MLU+lmlP4c2YZ77/HF+VjbnbnU2XQjz++QhyTCHUDMch/uRcWV+C/uL69nw6xfrgwaWd5I83AgMBAAECggEAYseiq9r01JRIFhwKAAcvMqKKPTPlLX+copGoPrI05SaIwWqR7KR1s59iG/2UiKMvtcf8Tc3sGqeVmapApPYE2MzfMwqruhBigyxFydTHH0iV8wd5B1nKtlzu3LpgDUU42FOCcvZDrzDKVTxGfJZrCBf6U2yvxKtCPdtc+oI+8AkMgOWSj4TdeDo4x79g1osD62CL1jC/4QSe0jMbZ95gEmhmiuy0+osoLXJUmboR9iNNpRsf6WPukA3Dz85fkcQZmDSvItAZLsDe2InPghdo6IZD9G2tEMxxJxn/Lr4vqWzaq7Xck9BeSG6hmkykSDnQDpPsgLUVZXn1yN1VcziOMQKBgQDxV5ABE9DqVUehTuGeReEp2Qqe4aN7jCD7uC8WtxAcmcrr+fRSSc+Sz9zrLTx1bf+JNe3epcbjdLD8bMhdtQlEf1pWLqN9YSWrN4yPUfyO/NQe1Qs3zcK9VcfxjnZaYwZp6BQtwGoK8yx41ejraNpaqY/FlhYoORchHnh9H/oeMwKBgQCl09djW81trLR2hNvWf60JPWhXFqIDJex7pYcKPz6P3xZ+4QPCdjg3rEfQxtdHOeUpvx2yG5rpQllGuaOmPFCG23UTvgVpVNTTH/ME03JUrjtdg5CMGTGP1E78XL9MecdnK+jlRKonPl5L5I8maKiMZS+xPaW4rBCuMePhoSD+7QKBgHDFKI3IU6Nbi+fs8vHA11B1kUfiSUCunq7gRmiHy6iBmFchaa+Vu79vD1x4u7pnVrMnlumlbsTTvuuEbS+UKyttkqmYi15HqZFSmIRTm/64Vum9RMujgq5zycSue9EKWnHcNqmWMjbBn/MqiPaO/RDGEF8UHXBYFN2t3kEhUv8PAoGAOnErcrfy8VkxjKeMNs9uc1gyAqdWV9ewvW775a+eY+QSsIqq4Yj6jRxpfvnk+xQ7YHgbhh7WfKjGf/eC5l5RXwXPADMzAwlDrFiRND01CQUSpQVuFwH2BqOjZqtlPBWbIhBGly6Y7RW88/BMRxQRetFaepOoaSozAsFQd79quo0CgYAYAe6Inrvf2HFyzX901oqraLIeMVakENMnbzW5gVgIO5GeNABWc/mHTfacXuDVabkr59cHIYVBBNBI1jZ9dGuPuyjpHEi4sIv5rKPYUgQxJfEIUd5zxQ2aEJwF06XRkD3YiUexluo3w1FkdlfvyVh/NzgZi/Z2kxQkzWJNOl665A==")
    private String privateKey;

    /**
     * 应用公钥
     */
    @ApiModelProperty(name = "publicKey", position = 0,required = true, value = "应用公钥" ,example = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnFUmCpgCXv0GO+SNX0xFDYAC9z87kRksnGu75n7akdgZqu4t3b3EbhKOlGSMciTr6goTyzGtu4An9/yzX9nhTgp1x83X5Sui/njBHdNrtGEEUA3sIskUKrp1i0PlfTHtXUowlOsbypClOPP+IEBXO3pVaG8ZcQPKAA8zYnnLw19NRMNkBbpw9yOzo93z6XKeM2vSY+rg3ZPZ81q+J13xbpWINCWqyNv6EOM0VM5cFKTcjYMuwp4THdAjNfb/QfNgxww9yyxCEAPAdjC1PpZpT+HNmGe+/xxflY25251Nl0I8/vkIckwh1AzHIf7kXFlfgv7i+vZ8OsX64MGlneSPNwIDAQAB")
    private String publicKey;

    /**
     * 返回格式
     */
    @ApiModelProperty(name = "dataFormat", position = 0,required = true, value = "返回格式" ,example = "json")
    private String dataFormat;

    /**
     * 签名方法
     */
    @ApiModelProperty(name = "signType", position = 0,required = true, value = "签名方法" ,example = "RSA2")
    private String signType;

    /**
     * 支付字符串编码
     */
    @ApiModelProperty(name = "payCharset", position = 0,required = true, value = "支付字符串编码" ,example = "UTF-8")
    private String payCharset;

    /**
     * 超时时间 可空
     */
    @ApiModelProperty(name = "timeoutExpress", position = 0,required = true, value = "超时时间 可空" ,example = "10m")
    private String timeoutExpress;

    /**
     * 销售产品码 必填
     */
    @ApiModelProperty(name = "productCode", position = 0,required = true, value = "销售产品码 必填" ,example = "QUICK_WAP_PAY")
    private String productCode;

    /**
     * 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
     */
    @ApiModelProperty(name = "payReturnUrl", position = 0,required = true, value = "页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址" ,example = "http://weixin.jfatty.cn/hfnumo/Alipay/returnUrl")
    private String payReturnUrl;

    /**
     * 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    @ApiModelProperty(name = "payNotifyUrl", position = 0,required = true, value = "服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问" ,example = "http://weixin.jfatty.cn/hfnumo/Alipay/notifyUrl")
    private String payNotifyUrl;

    /**
     * 支付成功跳转详情地址
     */
    @ApiModelProperty(name = "paySuccessTplUrl", position = 0,required = true, value = "支付成功跳转详情地址" ,example = "http://weixin.jfatty.cn/hfnumo/view/pay/success.html")
    private String paySuccessTplUrl;

    /**
     * 授权失败后跳转页面
     */
    @ApiModelProperty(name = "authFailUrl", position = 0,required = true, value = "授权失败后跳转页面" ,example = "http://weixin.jfatty.cn/hfnumo/view/pay/authFailed.html")
    private String authFailUrl;

    /**
     * 支付宝网关
     */
    @ApiModelProperty(name = "gateWay", position = 0,required = true, value = "支付宝网关" ,example = "https://openapi.alipay.com/gateway.do")
    private String gateWay;
}
