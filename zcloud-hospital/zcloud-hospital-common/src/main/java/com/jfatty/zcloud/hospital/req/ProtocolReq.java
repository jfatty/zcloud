package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.ProtocolDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */

@Data
@ApiModel(description = "用户协议请求实体")
public class ProtocolReq  extends ProtocolDTO<ProtocolReq> {


}
