package com.jfatty.zcloud.hospital.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.hospital.dto.BannerDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2020/4/11
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "轮播图响应实体")
public class BannerRes extends BannerDTO<BannerRes> {

    /**
     * 图片一般存储为地址
     */
    @ApiModelProperty(name = "img", position = 10 , value = "存储为地址",example = "http://119.29.96.206/zealsoft/ban01.jpg")
    private String img;

    /**
     * 图片二进制文件
     */
    @ApiModelProperty(name = "picture", position =11 , value = "图片二进制文件" )
    private byte[] picture;

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
    private LocalDateTime createTime = LocalDateTime.now();


}
