package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.AlipayConfigDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/24
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "支付宝支付配置信息响应实体")
public class AlipayConfigRes  extends AlipayConfigDTO<AlipayConfigRes> {
}
