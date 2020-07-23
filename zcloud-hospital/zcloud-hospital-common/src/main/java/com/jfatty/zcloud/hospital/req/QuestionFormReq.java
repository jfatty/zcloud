package com.jfatty.zcloud.hospital.req;

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
@ApiModel(description = "调查表问题主题请求实体")
public class QuestionFormReq extends QuestionFormDTO<QuestionFormReq> {



}
