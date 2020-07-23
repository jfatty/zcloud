package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.ConfigProfileDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 慧医疗系统配置配置
 *
 * @author jfatty on 2020/5/20
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "慧医疗系统配置配置请求实体")
public class ConfigProfileReq extends ConfigProfileDTO<ConfigProfileReq> {


}
