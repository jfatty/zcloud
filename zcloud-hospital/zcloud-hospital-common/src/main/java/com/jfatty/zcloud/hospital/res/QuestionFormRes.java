package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.QuestionFormDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 调查表问题主题
 *
 * @author jfatty on 2020/5/27
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "调查表问题主题响应实体")
public class QuestionFormRes extends QuestionFormDTO<QuestionFormRes> {

}
