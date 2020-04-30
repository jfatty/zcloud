package com.jfatty.zcloud.alipay.req;

import com.jfatty.zcloud.alipay.dto.AlipayMenuDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 支付宝菜单
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "支付宝菜单请求实体")
public class AlipayMenuReq extends AlipayMenuDTO<AlipayMenuReq> {


}
