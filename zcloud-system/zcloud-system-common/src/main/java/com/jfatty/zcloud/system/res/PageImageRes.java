package com.jfatty.zcloud.system.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.system.dto.PageImageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述 界面图片开发配置
 *
 * @author jfatty on 2019/12/31
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "界面图片开发配置响应实体")
public class PageImageRes extends PageImageDTO<PageImageRes> {

    /**
     * 激活图片二进制文件
     */
    private byte[] actImg;

    /**
     * 图片二进制文件
     */
    private byte[] img;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", position = 11,required = true,value = "正常使用 1 停用 0 使用状态" , example = "1" ,allowableValues = "0,1")
    private Integer state;


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
    private LocalDateTime createTime ;
}
