package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.WepayConfigDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/19
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "微信支付配置信息请求实体")
public class WepayConfigReq extends WepayConfigDTO<WepayConfigReq> {


}
