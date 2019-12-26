package com.jfatty.zcloud.health.res;

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
@ApiModel(description = "电子健康卡平台配置信息响应实体")
public class HealthCardSettingsRes extends HealthCardSettingsDTO<HealthCardSettingsRes> {

    /**
     * 域值
     */
    private String realm;

    /**
     * 使用状态
     */
    private Integer state;
    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
