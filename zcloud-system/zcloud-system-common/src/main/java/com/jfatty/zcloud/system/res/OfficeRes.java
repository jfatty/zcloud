package com.jfatty.zcloud.system.res;

import com.jfatty.zcloud.system.dto.OfficeDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统科室响应实体")
public class OfficeRes extends OfficeDTO<OfficeRes> {
}
