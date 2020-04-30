package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.TreatGuideDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 就诊指南
 *
 * @author jfatty on 2020/4/28
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "就诊指南请求实体")
public class TreatGuideReq extends TreatGuideDTO<TreatGuideReq> {


}
