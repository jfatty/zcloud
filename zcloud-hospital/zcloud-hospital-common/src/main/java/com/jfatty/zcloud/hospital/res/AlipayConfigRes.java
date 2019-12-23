package com.jfatty.zcloud.hospital.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.hospital.dto.AlipayConfigDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/24
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "支付宝支付配置信息响应实体")
public class AlipayConfigRes  extends AlipayConfigDTO<AlipayConfigRes> {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 支付宝APPID
     */
    private String appid;

    /**
     * 支付宝支付商户号
     */
    private String mchId;

    /**
     * 支付宝公钥
     */
    private String alipayPublicKey;

    /**
     * 应用私钥
     */
    private String privateKey;

    /**
     * 应用公钥
     */
    private String publicKey;

    /**
     * 返回格式
     */
    private String dataFormat;

    /**
     * 加密方法
     */
    private String signType;

    /**
     * 支付字符串编码
     */
    private String payCharset;

    /**
     * 超时时间 可空
     */
    private String timeoutExpress;

    /**
     * 销售产品码 必填
     */
    private String productCode;

    /**
     * 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
     */
    private String payReturnUrl;

    /**
     * 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    private String payNotifyUrl;

    /**
     * 支付成功跳转详情地址
     */
    private String paySuccessTplUrl;

    /**
     * 授权失败后跳转页面
     */
    private String authFailUrl;

    /**
     * 支付宝网关
     */
    private String gateWay;

    /**
     * 支付秘钥文件地址
     */
    private String certPath;

    /**
     * 支付秘钥密码
     */
    private String certPasswd;

    /**
     * 域值
     */
    private String realm;

    /**
     * 使用状态
     */
    private Integer state;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
