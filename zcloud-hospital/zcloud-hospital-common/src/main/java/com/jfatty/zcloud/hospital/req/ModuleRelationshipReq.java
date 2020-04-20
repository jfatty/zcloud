package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.ModuleRelationshipDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 系统模块与菜单对应关系
 *
 * @author jfatty on 2020/4/17
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统模块与菜单对应关系请求实体")
public class ModuleRelationshipReq extends ModuleRelationshipDTO<ModuleRelationshipReq> {



}
