package com.jfatty.zcloud.alipay.res;

import com.jfatty.zcloud.alipay.dto.AlipayAccountDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "支付宝账号信息响应实体")
public class AlipayAccountRes extends AlipayAccountDTO<AlipayAccountRes> {



}
