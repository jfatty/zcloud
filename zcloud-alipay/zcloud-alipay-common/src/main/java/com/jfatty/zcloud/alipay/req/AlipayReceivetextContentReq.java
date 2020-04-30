package com.jfatty.zcloud.alipay.req;

import com.jfatty.zcloud.alipay.dto.AlipayReceivetextContentDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述  用户消息详情
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "用户消息详情请求实体")
public class AlipayReceivetextContentReq extends AlipayReceivetextContentDTO<AlipayReceivetextContentReq> {


}
