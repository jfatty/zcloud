package com.jfatty.zcloud.hospital.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.hospital.dto.ConfigProfileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述 慧医疗系统配置配置
 *
 * @author jfatty on 2020/5/20
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "慧医疗系统配置配置响应实体")
public class ConfigProfileRes extends ConfigProfileDTO<ConfigProfileRes> {

    /**
     * 域值
     */
    @ApiModelProperty(name = "realm", position = 12 , value = "域值" )
    private String realm;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", position = 13 , value = "创建时间" ,allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
