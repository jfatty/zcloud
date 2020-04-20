package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.ModuleDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/11
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统模块请求实体")
public class ModuleReq extends ModuleDTO<ModuleReq> {


}
