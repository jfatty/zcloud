package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


/**
 * <p>
 * 微信支付配置信息表
 * </p>
 *
 * @author jfatty
 * @since 2019-12-19
 */
@Data
@TableName("pay_wepay_config")
public class WepayConfig extends Model<WepayConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 公众号APPID
     */
    private String appid;

    /**
     * 微信支付商户号
     */
    private String mchId;

    /**
     * 加密方法
     */
    private String signType;

    /**
     * 微信支付key
     */
    private String tradeType;

    /**
     * 币种，1人民币   66
     */
    private String feeFype;

    /**
     * 支付key
     */
    private String payKey;

    /**
     * 微信支付回调地址
     */
    private String payNotifyUrl;

    /**
     * 微信支付网关地址
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
     * 支付成功跳转详情地址
     */
    private String paySuccessTplUrl;

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
    private LocalDateTime createTime;

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
