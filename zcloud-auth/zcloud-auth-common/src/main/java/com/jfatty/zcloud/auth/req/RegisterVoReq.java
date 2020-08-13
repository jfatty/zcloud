package com.jfatty.zcloud.auth.req;

import com.jfatty.zcloud.auth.dto.RegisterVoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 用户注册请求实体
 *
 * @author jfatty on 2020/7/8
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "用户注册请求实体")
public class RegisterVoReq  extends RegisterVoDTO<RegisterVoReq> {

    /**
     * 账号 手机号
     */
    @ApiModelProperty(name = "phone", position = 0,required = true, value = " 账号 " ,example = "15171084152")
    private String phone;

    /**
     * 密码 校验验证码
     */
    @ApiModelProperty(name = "password", position = 0,required = true, value = " 密码 " ,example = "12345678")
    private String password;

    /**
     * 短信验证码
     */
    @ApiModelProperty(name = "kaptcha", position = 0,required = true, value = "短信验证码 " ,example = "142536" )
    private String kaptcha ;


}
