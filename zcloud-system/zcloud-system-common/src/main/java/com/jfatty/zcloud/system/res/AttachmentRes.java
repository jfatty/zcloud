package com.jfatty.zcloud.system.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.system.dto.AttachmentDTO;
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
@ApiModel(description = "系统附件响应实体")
public class AttachmentRes extends AttachmentDTO<AttachmentRes> {

    /**
     * 创建人
     */
    @ApiModelProperty(name = "createOperator", position = 12 , value = "创建人" , example = "张三" )
    private String createOperator;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", position = 13 , value = "创建时间" ,allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime ;
}
