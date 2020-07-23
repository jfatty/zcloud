package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.SurveyOpenTimeDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 量表开放时间管理
 *
 * @author jfatty on 2020/6/10
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "量表开放时间管理请求实体")
public class SurveyOpenTimeReq extends SurveyOpenTimeDTO<SurveyOpenTimeReq> {

}
