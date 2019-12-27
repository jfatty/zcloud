package com.jfatty.zcloud.health.req;

import com.jfatty.zcloud.health.dto.DynamicQRCodeDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/27
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "身份证信息请求实体")
public class DynamicQRCodeReq extends DynamicQRCodeDTO<DynamicQRCodeReq> {
}
