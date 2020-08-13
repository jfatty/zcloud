package com.jfatty.zcloud.auth.req;

import com.jfatty.zcloud.auth.dto.LoginVoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 微信点餐登录请求实体
 *
 * @author jfatty on 2020/7/8
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "微信点餐登录请求实体")
public class SellLoginReq extends LoginVoDTO<SellLoginReq> {

    /**
     * 账号(手机号)
     */
    @ApiModelProperty(name = "account", position = 0,required = true, value = " 账号(手机号) " ,example = "15171084152")
    private String account;

    /**
     * 密码 校验验证码
     */
    @ApiModelProperty(name = "password", position = 0,required = true, value = " 密码 校验验证码 " ,example = "12345678")
    private String password;

    /**
     * 登录方式
     */
    @ApiModelProperty(name = "mode", position = 0,required = true, value = "登录方式 短信验证码登录KAPTCHA 账号密码登录USERPWD" ,example = "KAPTCHA" ,allowableValues = "USERPWD,KAPTCHA")
    private String mode ;
}
