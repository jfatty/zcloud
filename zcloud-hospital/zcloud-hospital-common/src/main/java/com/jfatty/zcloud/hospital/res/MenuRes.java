package com.jfatty.zcloud.hospital.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.hospital.dto.MenuDTO;
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
@ApiModel(description = "智慧医疗菜单响应实体")
public class MenuRes extends MenuDTO<MenuRes> {

    /**
     * icon图标二进制文件
     */
    @ApiModelProperty(name = "iconImg", position = 2,required = true, value = "icon图标二进制文件" , example = "二进制文件")
    private byte[]  iconImg;

    /**
     * icon图标二进制文件
     */
    @ApiModelProperty(name = "actIconImg", position = 2,required = true, value = "菜单图标激活状态二进制文件" , example = "二进制文件")
    private byte[]  actIconImg;


    /**
     * 域值
     */
    @ApiModelProperty(name = "realm", position = 2,required = true, value = "域值" , example = "25845828")
    private String realm;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
