package com.jfatty.zcloud.auth.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/27
 * @email jfatty@163.com
 */
@Data
public class AuthSmsLogDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 每个应用都对应有appId支付宝、微信、第三方APPappId
     */
    private String appid;

    /**
     * 发送短息的手机号
     */
    private String smsPhone;

    /**
     * 短信发送编码全局唯一 短信发送内容
     */
    private String smsContent;

    /**
     * 短信发送状态 0表示正常 -1表示信息发送异常
     */
    private Integer smsStatus;

    /**
     * 短信应用SDK AppID
     */
    private String accessKeyId;

    /**
     * 短信服务提供商名称
     */
    private String providerName;

    /**
     * 短信模板ID，需要在短信应用中申请
     */
    private String templateId;

    /**
     * 必填:短信签名-可在短信控制台中找到
     */
    private String signName;

    /**
     * 错误信息
     */
    private String errMsg;

    /**
     * 使用状态0表示正常使用-1表示维护中-2表示建设中...
     */
    private Integer status;

}
