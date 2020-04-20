package com.jfatty.zcloud.system.req;

import com.jfatty.zcloud.system.dto.DepartmentDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统部门请求实体")
public class DepartmentReq  extends DepartmentDTO<DepartmentReq> {
}
