package com.jfatty.zcloud.hospital.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.hospital.dto.ProtocolDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */

@Data
@ApiModel(description = "用户协议响应实体")
public class ProtocolRes extends ProtocolDTO<ProtocolRes> {

    /**
     * 域值
     */
    @ApiModelProperty(name = "realm", position = 2,required = true, value = "域值 " , example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String realm;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
