package com.jfatty.zcloud.alipay.res;

import com.jfatty.zcloud.alipay.dto.AlipayReceivetextDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 文本消息
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "文本消息响应实体")
public class AlipayReceivetextRes extends AlipayReceivetextDTO<AlipayReceivetextRes> {

    
}
