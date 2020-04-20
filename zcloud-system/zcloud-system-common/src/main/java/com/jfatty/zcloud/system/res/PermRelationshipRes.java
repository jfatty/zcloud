package com.jfatty.zcloud.system.res;

import com.jfatty.zcloud.system.dto.PermRelationshipDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统权限依赖关系响应实体")
public class PermRelationshipRes extends PermRelationshipDTO<PermRelationshipRes> {
}
