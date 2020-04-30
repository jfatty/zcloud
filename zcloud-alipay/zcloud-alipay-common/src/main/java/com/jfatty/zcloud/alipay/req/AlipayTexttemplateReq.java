package com.jfatty.zcloud.alipay.req;

import com.jfatty.zcloud.alipay.dto.AlipayTexttemplateDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 文本模板
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "文本模板请求实体")
public class AlipayTexttemplateReq extends AlipayTexttemplateDTO<AlipayTexttemplateReq> {


}
