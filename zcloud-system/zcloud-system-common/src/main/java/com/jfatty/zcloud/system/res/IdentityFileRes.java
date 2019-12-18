package com.jfatty.zcloud.system.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.system.dto.IdentityFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/15
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "XXX理实体")
public class IdentityFileRes extends IdentityFileDTO<IdentityFileRes> {

    /**
     * 人头面
     */
    @ApiModelProperty(name = "avatar", value = "人头面", required = true, position = 2, example = "湖南省")
    private byte[] avatar;

    /**
     * 国徽面
     */
    @ApiModelProperty(name = "emblem", value = "国徽面", required = true, position = 3, example = "长沙市")
    private byte[] emblem;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "status", value = "是否有效", position = 6, required = false, allowableValues = "1,0")
    private Integer state;

    /**
     * 创建时间=等同上传时间
     */
    @ApiModelProperty(name = "createTime", value = "创建时间", position = 7, required = false, allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
