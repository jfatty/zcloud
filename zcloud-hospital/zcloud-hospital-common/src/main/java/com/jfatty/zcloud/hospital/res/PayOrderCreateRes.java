package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.PayOrderCreateDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/19
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "订单创建响应实体")
public class PayOrderCreateRes  extends PayOrderCreateDTO<PayOrderCreateRes> {

}
