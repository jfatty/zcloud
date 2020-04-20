package com.jfatty.zcloud.alipay.req;

import com.jfatty.zcloud.alipay.dto.AlipayGzuserinfoDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "支付宝关注用户请求实体")
public class AlipayGzuserinfoReq extends AlipayGzuserinfoDTO<AlipayGzuserinfoReq> {
}
