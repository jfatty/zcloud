package com.jfatty.zcloud.health.req;

import com.jfatty.zcloud.health.dto.HCSIDCardInfoDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;


/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "身份证信息请求实体")
public class HCSIDCardInfoReq extends HCSIDCardInfoDTO<HCSIDCardInfoReq> {


}
