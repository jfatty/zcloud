package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 支付宝支付配置信息表
 * </p>
 *
 * @author jfatty
 * @since 2019-12-23
 */
@Data
@TableName("pay_alipay_config")
public class AlipayConfig extends Model<AlipayConfig> {

    private static final long serialVersionUID = 1L;

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
     * 用户支付成功模板消息备注签名
     */
    private String signName;

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
     * 模板ID
     */
    private String tplId;

    /**
     * 域值
     */
    private String realm;

    /**
     * 使用状态
     */
    private Integer state;

    /**
     * 创建人
     */
    private String createOperator;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime ;

    /**
     * 更新人
     */
    private String updateOperator;

    /**
     * 更新时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 删除状态0表示非删除状态1表示数据已经删除
     */
    private Integer deleteState;

    /**
     * 删除时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deleteTime;

    /**
     * 删除操作者
     */
    private String deleteOperator;



}
