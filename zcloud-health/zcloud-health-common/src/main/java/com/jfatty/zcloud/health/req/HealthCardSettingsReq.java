package com.jfatty.zcloud.health.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.health.dto.HealthCardSettingsDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "电子健康卡平台配置信息请求实体")
public class HealthCardSettingsReq extends HealthCardSettingsDTO<HealthCardSettingsReq> {



}
