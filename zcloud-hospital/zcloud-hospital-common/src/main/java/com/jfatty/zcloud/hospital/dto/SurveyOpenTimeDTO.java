package com.jfatty.zcloud.hospital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述 量表开放时间管理
 *
 * @author jfatty on 2020/6/10
 * @email jfatty@163.com
 */
@Data
public class SurveyOpenTimeDTO<T extends BaseDTO> extends BaseDTO {


    /**
     * 主键ID
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;

    /**
     * 量表ID
     */
    @ApiModelProperty(name = "surveyId", position = 3 , required = true,value = "量表ID" , example = "4028fe8171f7125b0171f74bb79f0022" )
    private String surveyId;

    /**
     * 开始时间
     */
    @ApiModelProperty(name = "startTime", position = 3 , required = true,value = "开始时间" , example = "2020-06-09 10:01:15",allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(name = "endTime", position = 3 , required = true,value = "结束时间" , example = "2022-06-09 10:01:15",allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    /**
     * 描述(备注说明)
     */
    @ApiModelProperty(name = "description", position = 3 , value = "关联对象描述" , example = "山外青山楼外" )
    private String description;

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

}
