package com.jfatty.zcloud.auth.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 系统短信息配置
 *
 * @author jfatty on 2019/12/27
 * @email jfatty@163.com
 */
@Data
public class AuthSmsConfigDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 每个应用都对应有appId支付宝、微信、第三方APPappId
     */
    @ApiModelProperty(name = "appid", value = "每个应用都对应有appId支付宝、微信、第三方APP",required = true,example = "wxe3336a60d2685379")
    private String appid;

    /**
     * 短信发送编码全局唯一
     */
    @ApiModelProperty(name = "smsCode", value = "短信发送编码全局唯一",required = true,example = "aliyun",allowableValues = "aliyun,tencent")
    private String smsCode;

    /**
     * 短信发送服务名称
     */
    @ApiModelProperty(name = "serviceName", value = "短信发送服务名称",required = true,example = "aliyun",allowableValues = "aliyun,tencent")
    private String serviceName;

    /**
     * 短信服务提供商名称
     */
    @ApiModelProperty(name = "providerName", value = "短信服务提供商名称",required = true,example = "阿里云",allowableValues = "阿里云,腾讯云,华为云")
    private String providerName;

    /**
     * 产品名称:云通信短信API产品,开发者无需替换
     */
    @ApiModelProperty(name = "product", value = "产品名称:云通信短信API产品,开发者无需替换",example = "Dysmsapi")
    private String product;

    /**
     * 产品域名,开发者无需替换
     */
    @ApiModelProperty(name = "domain", value = "产品域名,开发者无需替换",example = "dysmsapi.aliyuncs.com")
    private String domain;

    /**
     * 短信应用SDK AppID
     */
    @ApiModelProperty(name = "accessKeyId", value = "短信应用SDK AppID",required = true,example = "LTAIbVXcCV7BPdgu")
    private String accessKeyId;

    /**
     * 短信应用SDK AppKey
     */
    @ApiModelProperty(name = "accessKeySecret", value = "短信应用SDK AppKey",required = true,example = "pKHTygWtkXqCuK10L33Q5zXZYZWnU5")
    private String accessKeySecret;

    /**
     * 短信模板ID，需要在短信应用中申请
     */
    @ApiModelProperty(name = "templateId", value = "短信模板ID，需要在短信应用中申请",required = true,example = "SMS_130914739")
    private String templateId;

    /**
     * 必填:短信签名-可在短信控制台中找到
     */
    @ApiModelProperty(name = "signName", value = "必填:短信签名-可在短信控制台中找到",required = true,example = "鹤峰县中心医院",allowableValues = "鹤峰县中心医院,龙山县中医院,武汉志软科技有限公司")
    private String signName;

    /**
     * outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
     */
    @ApiModelProperty(name = "outId", value = "outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者",example = "hfxzxyy")
    private String outId;

    /**
     * 验证码超时时间以秒(s)对单位 默认 300m
     */
    @ApiModelProperty(name = "expireTime", value = "验证码超时时间以秒(s)对单位",example = "300")
    private Integer expireTime ;

    /**
     * 使用状态0表示正常使用-1表示维护中-2表示建设中...
     */
    private Integer status;
}
