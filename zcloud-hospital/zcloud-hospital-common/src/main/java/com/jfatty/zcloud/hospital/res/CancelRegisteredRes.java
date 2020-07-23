package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.CancelRegisteredDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 取消预约挂号响应实体
 *
 * @author jfatty on 2020/7/14
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "取消预约挂号响应实体")
public class CancelRegisteredRes extends CancelRegisteredDTO<CancelRegisteredRes> {



}
