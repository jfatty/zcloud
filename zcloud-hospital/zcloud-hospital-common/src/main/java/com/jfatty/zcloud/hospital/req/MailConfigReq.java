package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.MailConfigDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 智慧医疗邮件发送配置
 *
 * @author jfatty on 2020/4/22
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "智慧医疗邮件发送配置请求实体")
public class MailConfigReq extends MailConfigDTO<MailConfigReq> {



}
