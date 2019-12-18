package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.SysPatientInfoDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统病人信息响应实体")
public class SysPatientInfoRes extends SysPatientInfoDTO<SysPatientInfoRes> {

}
