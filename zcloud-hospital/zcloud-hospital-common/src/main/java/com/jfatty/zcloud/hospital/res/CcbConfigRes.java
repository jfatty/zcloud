package com.jfatty.zcloud.hospital.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.hospital.dto.CcbConfigDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述 建行支付配置信息
 *
 * @author jfatty on 2020/7/27
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "建行支付配置信息响应实体")
public class CcbConfigRes extends CcbConfigDTO<CcbConfigRes> {

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", position = 11,required = true,value = "正常使用 1 停用 0 使用状态" , example = "1" ,allowableValues = "0,1")
    private Integer state;

    /**
     * 创建时间
     */
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
