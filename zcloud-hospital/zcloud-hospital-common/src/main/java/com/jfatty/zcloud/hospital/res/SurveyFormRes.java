package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.SurveyFormDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 调查表内容主题
 *
 * @author jfatty on 2020/5/27
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "调查表内容主题响应实体")
public class SurveyFormRes extends SurveyFormDTO<SurveyFormRes> {


}
