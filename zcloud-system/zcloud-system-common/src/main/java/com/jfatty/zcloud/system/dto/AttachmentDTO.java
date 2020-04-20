package com.jfatty.zcloud.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
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
public class AttachmentDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;
    /**
     * 关联对象id
     */
    @ApiModelProperty(name = "relationId", position = 2 , value = "关联对象id" , example = "sd45s54548a5s45s48" )
    private String relationId;

    /**
     * 原名称
     */
    @ApiModelProperty(name = "originalName", position = 2 , value = "原名称" , example = "原来.mp3" )
    private String originalName;

    /**
     * 当前名称
     */
    @ApiModelProperty(name = "currentName", position = 3 , value = "当前名称" , example = "现在.mp3" )
    private String currentName;

    /**
     * 文件路径
     */
    @ApiModelProperty(name = "filePath", position = 3 , value = "文件路径" , example = "E:\\VMware\\Win10\\Win10.vmxf" )
    private String filePath;

    /**
     * 文件大小
     */
    @ApiModelProperty(name = "fileSize", position = 3 , value = "文件大小" , example = "100M" )
    private String fileSize;

    /**
     * 上传时间
     */
    @ApiModelProperty(name = "fileSize", position = 3 , value = "上传时间" , example = "2020-04-09 13:03:06" )
    private String uploadTime;

    /**
     * 附件排序号
     */
    @ApiModelProperty(name = "number", position = 3 , value = "附件排序号" , example = "003" )
    private Integer number;

    /**
     * 文件类型
     */
    @ApiModelProperty(name = "attaFileFat", position = 3 , value = "文件类型" , example = "mp3" )
    private String attaFileFat;

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
     * 更新人
     */
    @ApiModelProperty(name = "updateOperator", position = 12 , value = "更新人" , example = "张三" )
    private String updateOperator;

    /**
     * 更新时间
     */
    @ApiModelProperty(name = "updateTime", position = 13 , value = "更新时间" ,allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
