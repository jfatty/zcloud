package com.jfatty.zcloud.hospital.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.hospital.dto.HOSPageSettingsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/30
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "智慧医疗页面配置信息响应实体")
public class HOSPageSettingsRes extends HOSPageSettingsDTO<HOSPageSettingsRes> {

    /**
     * 医院logo二进制文件
     */
    @ApiModelProperty(name = "hosLogoImg", position = 1,  value = "医院logo二进制文件" )
    private byte[] hosLogoImg;

    /**
     * 激活状态电话图标二进制文件
     */
    @ApiModelProperty(name = "actAddressIconImg", position = 1, value = "激活状态电话图标二进制文件" )
    private byte[] actAddressIconImg;

    /**
     * 电话图标二进制文件
     */
    @ApiModelProperty(name = "addressIconImg", position = 1,  value = "电话图标二进制文件" )
    private byte[] addressIconImg;
    /**
     * 激活状态电话图标二进制
     */
    @ApiModelProperty(name = "actPhoneIconImg", position = 1,  value = "激活状态电话图标二进制" )
    private byte[] actPhoneIconImg;
    /**
     * 电话图标二进制
     */
    @ApiModelProperty(name = "phoneIconImg", position = 1, value = "电话图标二进制" )
    private byte[] phoneIconImg;

    /**
     * 域值
     */
    @ApiModelProperty(name = "realm", position = 1, value = "域值" , example = "sdsdsd454548548787s8ds4d8as4")
    private String realm;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", position = 1, required = true, value = "创建时间" , example = "2019-12-31 12:01:03" ,allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
