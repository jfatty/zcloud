package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 描述
 *
 * @author jfatty on 2019/12/19
 * @email jfatty@163.com
 */
@Data
public class WepayConfigDTO<T extends BaseDTO> extends BaseDTO {

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
     * 模板ID
     */
    @ApiModelProperty(name = "tplId", position = 0,required = true, value = "模板ID" ,example = "a884ef773e91407582644a18c18d836c")
    private String tplId;

    /**
     * 使用状态
     */
    private Integer state;

}
