package com.jfatty.zcloud.auth.req;

import com.jfatty.zcloud.auth.dto.KaptchaDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/19
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "手机号二维码请求实体")
public class KaptchaReq extends KaptchaDTO<KaptchaReq> {

    private String phone ;

    private String random ;
}
