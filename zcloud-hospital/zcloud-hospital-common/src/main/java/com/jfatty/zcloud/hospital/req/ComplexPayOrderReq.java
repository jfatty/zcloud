package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.ComplexPayOrderDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/21
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "智慧医疗交易订单请求实体")
public class ComplexPayOrderReq extends ComplexPayOrderDTO<ComplexPayOrderReq> {



}
