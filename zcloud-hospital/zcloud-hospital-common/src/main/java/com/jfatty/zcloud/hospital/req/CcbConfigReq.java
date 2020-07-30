package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.CcbConfigDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 建行支付配置信息
 *
 * @author jfatty on 2020/7/27
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "建行支付配置信息请求实体")
public class CcbConfigReq extends CcbConfigDTO<CcbConfigReq> {


}
