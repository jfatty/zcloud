package com.jfatty.zcloud.auth.req;

import com.jfatty.zcloud.auth.dto.AuthSmsConfigDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/27
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统短信息配置请求实体")
public class AuthSmsConfigReq  extends AuthSmsConfigDTO<AuthSmsConfigReq> {
}
