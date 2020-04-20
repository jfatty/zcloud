package com.jfatty.zcloud.auth.req;

import com.jfatty.zcloud.auth.dto.LoginVoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/19
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "登录实体请求请求实体")
public class LoginVoReq extends LoginVoDTO<LoginVoReq> {

    /**
     * 账号
     */
    @ApiModelProperty(name = "account", position = 0,required = true, value = " 账号 " ,example = "15171084152")
    private String account;

    /**
     * 密码 校验验证码
     */
    @ApiModelProperty(name = "password", position = 0,required = true, value = " 密码 校验验证码 " ,example = "12345678")
    private String password;

    /**
     * 登录方式
     */
    @ApiModelProperty(name = "mode", position = 0,required = true, value = "登录方式 " ,example = "PHONE" ,allowableValues = "PHONE,EMAIL,ACCOUNT,IDCARD,QQ,WECHAT")
    private String mode ;

    /**
     * 源自哪里
     */
    @ApiModelProperty(name = "source", position = 0, value = " 源自哪里 " ,example = "http://www.hfxzxyy.com")
    private String source ;

    /**
     * 回调地址
     */
    @ApiModelProperty(name = "callback", position = 0, value = " 回调地址 " ,example = "http://www.baidu.com")
    private String callback ;
}
