package com.jfatty.zcloud.hospital.res;

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
@ApiModel(description = "微信支付配置信息响应实体")
public class WepayConfigRes extends WepayConfigDTO<WepayConfigRes> {



}
