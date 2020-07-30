package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 建行支付配置信息表
 * </p>
 *
 * @author jfatty
 * @since 2020-07-27
 */
@Data
@TableName("pay_ccb_config")
public class CcbConfig extends Model<CcbConfig> {

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
     * 商户ID
     */
    private String merchantId;

    /**
     * 商户柜台代码
     */
    private String posId;

    /**
     * 分行代码
     */
    private String branchId;

    /**
     * 币种
     */
    private String curCode;

    /**
     * 交易码
     */
    private String txCode;

    /**
     * 支付回调地址
     */
    private String payNotifyUrl;

    /**
     * 微信支付网关地址
     */
    private String gateWay;

    /**
     * 公钥完整字符串
     */
    private String publicKey;

    /**
     * 公钥后30位
     */
    private String pub;

    /**
     * 模板消息ID
     */
    private String tplId;

    /**
     * 支付成功跳转详情地址
     */
    private String paySuccessTplUrl;

    private String returnType;

    /**
     * 证书号
     */
    private String certNo;

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
